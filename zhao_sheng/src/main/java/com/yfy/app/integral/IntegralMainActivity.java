package com.yfy.app.integral;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.zhao_sheng.R;
import com.yfy.app.WebActivity;
import com.yfy.app.album.AlbumOneActivity;
import com.yfy.app.bean.BaseRes;
import com.yfy.app.login.AlterCllActivity;
import com.yfy.app.login.AlterPassActivity;
import com.yfy.app.net.login.UserLogoutReq;
import com.yfy.app.oashow.BossMainActivity;
import com.yfy.base.Base;
import com.yfy.dialog.ConfirmAlbumWindow;
import com.yfy.final_tag.Photo;
import com.yfy.app.integral.adapter.IntegralMainAdapter;
import com.yfy.app.integral.beans.IntegralResult;
import com.yfy.app.login.UserBaseActivity;
import com.yfy.app.net.RetrofitGenerator;
import com.yfy.app.net.base.UserGetCallReq;
import com.yfy.app.net.ReqBody;
import com.yfy.app.net.ReqEnv;
import com.yfy.app.net.ResBody;
import com.yfy.app.net.ResEnv;
import com.yfy.base.Variables;
import com.yfy.base.activity.WcfActivity;
import com.yfy.dialog.LoadingDialog;
import com.yfy.final_tag.*;
import com.yfy.glide.GlideTools;
import com.yfy.jpush.Logger;
import com.yfy.permission.PermissionTools;
import com.yfy.db.GreenDaoManager;
import com.yfy.db.UserPreferences;
import com.yfy.net.loading.interf.WcfTask;
import com.yfy.net.loading.task.ExtraRunTask;
import com.yfy.net.loading.task.ParamsTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import jp.wasabeef.glide.transformations.BlurTransformation;

import com.yfy.permission.PermissionFail;
import com.yfy.permission.PermissionGen;
import com.yfy.permission.PermissionSuccess;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IntegralMainActivity extends WcfActivity implements Callback<ResEnv> {

    private static final String TAG = IntegralMainActivity.class.getSimpleName();

    @Bind(R.id.integral_main_list)
    ListView list;
    private final  int ADD_PHOTO = 1;
    private final  int REFRESH = 3;

    private ImageView head_iamge;
    private ImageView head_bg;
    private TextView name;
    private TextView type,replace_protraits;
    private TextView integral_text;



    private List<String> s_name=new ArrayList<>();
    private  List<Map<String,Object>> activitys;
    private IntegralMainAdapter adapter;


    private LoadingDialog loadingDialog;
    public String uploadPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.integral_main);
        loadingDialog = new LoadingDialog(this);
        initSQToolbar();
        initDialog();
        getData();
        initView();
        refresh();
        getCall();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case TagFinal.CAMERA:
                    uploadPath=FileCamera.photo_camera;
                    uploadPic(uploadPath);
                    break;
                case TagFinal.PHOTO_ALBUM:
                    ArrayList<Photo> photo_a=data.getParcelableArrayListExtra(TagFinal.ALBUM_TAG);
                    if (photo_a==null)return;
                    if (photo_a.size()==0)return;
                    uploadPath=photo_a.get(0).getPath();
                    uploadPic(uploadPath);
//                    InitUtils.homeHeadPic(this);
                    break;
                case TagFinal.UI_TAG:
                    getCall();
                    break;

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onSuccess(String result, WcfTask wcfTask) {
        switch (wcfTask.getId()) {

            case ADD_PHOTO:
                toastShow(R.string.success_send_head);
                Variables.user.setHeadPic(uploadPath);
                Base.user.setHeadPic(uploadPath);
                GreenDaoManager.getInstance().clearUser();
                GreenDaoManager.getInstance().saveNote(Variables.user);
                refreshHeadPic();
                break;
            case REFRESH:
                IntegralResult info=gson.fromJson(result, IntegralResult.class);
                create(info.getInfo(),info.getScore());
                break;
            default:
                break;

        }


        return false;
    }

    @Override
    public void onError(WcfTask wcfTask) {

    }


    @OnClick(R.id.integral_user_out)
    void setBack(){
        mDialog("确定要退出登录！",oklistener);

    }


    private DialogInterface.OnClickListener oklistener= new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            logout();
        }
    };



    private void initSQToolbar() {
        assert toolbar!=null;
        toolbar.setTitle("用户信息");
    }



    private TextView call_phone,alter_pass;
    private void initView() {
        adapter=new IntegralMainAdapter(mActivity,s_name);
        View header= LayoutInflater.from(mActivity).inflate(R.layout.integral_main_header,null);
        head_iamge= (ImageView) header.findViewById(R.id.integral_main_head_pic);
        head_bg= (ImageView) header.findViewById(R.id.integral_main_head_bg);


        RelativeLayout call=header.findViewById(R.id.integral_main_item_call_layout);
        if (Variables.user.getUsertype().equals(TagFinal.USER_TYPE_TEA)){
            call.setVisibility(View.VISIBLE);
        }else{
            call.setVisibility(View.GONE);
        }
        call_phone=header.findViewById(R.id.integral_main_item_call);
        call_phone.setTextColor(ColorRgbUtil.getGrayBackground());
        name= (TextView) header.findViewById(R.id.integral_main_name);
        TextView integral= (TextView) header.findViewById(R.id.integral_main_scroe);
        type= (TextView) header.findViewById(R.id.integral_main_type);
        integral_text= (TextView) header.findViewById(R.id.integral_main_fen);
        replace_protraits= (TextView) header.findViewById(R.id.integral_replace_head_protraits);
        alter_pass= (TextView) header.findViewById(R.id.integral_alter);
        integral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Variables.user.getUsertype().equals(TagFinal.USER_TYPE_TEA)){
                    startActivity(new Intent(mActivity,IntegralListActivity.class));
                }else{
                    startActivity(new Intent(mActivity,IntegralListActivity.class));
                }

            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(mActivity, AlterCllActivity.class);
                startActivityForResult(intent,TagFinal.UI_TAG );
            }
        });
        replace_protraits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyWord();
                album_select.showAtBottom();
            }
        });

        alter_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mActivity, AlterPassActivity.class);
                startActivityForResult(intent,TagFinal.UI_ADMIN);
                finish();
            }
        });

        list.setAdapter(adapter);
        list.addHeaderView(header);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i<1)return;
                if (s_name.get(i-1).equals("课表")){
                    String url = TagFinal.SCHEDULE + Variables.user.getSession_key();
                    Intent intent=(Intent) activitys.get(i-1).get("intent");
                    Bundle b = new Bundle();
                    b.putString(TagFinal.URI_TAG, url);
                    b.putString(TagFinal.TITLE_TAG, "课程表");
                    intent.putExtras(b);
                    startActivity(intent);
                }else{
                    startActivity((Intent) activitys.get(i-1).get("intent"));
                }
            }
        });
        name.setText(Variables.user.getName());
        if (Variables.user.getHeadPic() != null) {

            GlideTools.chanCircle(mActivity, Variables.user.getHeadPic(), head_iamge, R.drawable.user);


            Glide.with(mActivity)
                    .load(Variables.user.getHeadPic())
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation()))
                    .into(head_bg);
        } else {


            GlideTools.chanCircle(mActivity, R.drawable.user, head_iamge);


            Glide.with(mActivity)
                    .load(R.drawable.user)
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation()))
                    .into(head_bg);
        }
    }


    private void refreshHeadPic() {
        if (Variables.user == null) {
            return;
        }
        if (Variables.user.getHeadPic() != null) {

            GlideTools.chanCircle(mActivity, Variables.user.getHeadPic(), head_iamge,R.drawable.user);

            Glide.with(mActivity)
                    .load(Variables.user.getHeadPic())
                    .apply(new RequestOptions().placeholder(R.drawable.user))
                    .apply(RequestOptions.centerCropTransform())
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation()))
                    .into(head_bg);
        } else {
            GlideTools.chanCircle(mActivity, R.drawable.user, head_iamge);

            Glide.with(mActivity)
                    .load(R.drawable.user)
                    .apply(new RequestOptions().error(R.drawable.user))
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation()))
                    .into(head_bg);
        }
    }



    private void create(String type_s,String srcoe ){

        type.setText(type_s);
        integral_text.setText(srcoe);
    }

    public List<Map<String,Object>> getData(){
        activitys= new ArrayList<>();


        if (Variables.admin.getIsheadmasters().equalsIgnoreCase(TagFinal.TRUE)){
//        if (Variables.admin.getIshqadmin().equalsIgnoreCase(TagFinal.TRUE)){
            addItem(activitys, "校长查看", BossMainActivity.class,false,0);
//            addItem(activitys, "请假", BAttenActivity.class,false,0);

        }

        if (Base.user.getUsertype().equals(TagFinal.USER_TYPE_TEA)){
            addItem(activitys, "学科优生", SubjectGoodTeaActivity.class,false,0);
            addItem(activitys, "学生成果", HonorTeaActivity.class,false,0);
//            addItem(activitys, "学生密码管理", TeaResetStuPassActivity.class,false,0);
        }else{
            addItem(activitys, "基本信息", UserBaseActivity.class,false,1);
            addItem(activitys, "学科优生", SubjectGoodStuActivity.class,false,0);
            addItem(activitys, "成长数据", IntegralGrowActivity.class ,false,0);
            addItem(activitys, "家庭数据", IntegralFamilyActivity.class,false,0);
            addItem(activitys, "个人成果", IntegralHonorActivity.class,false,0);
        }


        addItem(activitys, "学期评语", TermidCommtActivity.class,false,0);
        addItem(activitys, "课表", WebActivity.class,false,10);
        addItem(activitys, "积分详情", IntegralListActivity.class,true,0);

        return activitys;
    }
    public void addItem(List<Map<String,Object>> activitys,String text,Class<?> obj,boolean is,int num) {
        Intent intent=new Intent(mActivity,obj);
        switch (num){
            case 1:

                break;
        }
        addItem(activitys, text,intent ,is);

    }
    protected void addItem(List<Map<String, Object>> data, String name, Intent intent,boolean is) {
        Map<String, Object> temp = new HashMap<String, Object>();
        s_name.add(name);
        temp.put("intent", intent);
        temp.put("type", is);

        data.add(temp);
    }




    private ConfirmAlbumWindow album_select;
    private void initDialog() {
        album_select = new ConfirmAlbumWindow(mActivity);
        album_select.setOne_select(getResources().getString(R.string.take_photo));
        album_select.setTwo_select(getResources().getString(R.string.album));
        album_select.setName(getResources().getString(R.string.upload_type));
        album_select.setOnPopClickListenner(new ConfirmAlbumWindow.OnPopClickListenner() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.popu_select_one:
                        PermissionTools.tryCameraPerm(mActivity);
                        break;
                    case R.id.popu_select_two:
                        PermissionTools.tryWRPerm(mActivity);
                        break;
                }
            }
        });
    }


    private void uploadPic(String path) {
        Object[] params = new Object[] {
                Variables.user.getSession_key(),
                path,
                path };
        ParamsTask uploadPicTask = new ParamsTask(params, TagFinal.USER_ADD_HEAD, ADD_PHOTO, loadingDialog);
        ExtraRunTask wrapTask = new ExtraRunTask(uploadPicTask);
        wrapTask.setExtraRunnable(extraRunnable);
        execute(wrapTask);
    }


    private ExtraRunTask.ExtraRunnable extraRunnable = new ExtraRunTask.ExtraRunnable() {

        @Override
        public Object[] onExecute(Object[] params) {
            String photoPath = params[1].toString();
            params[1] = Base64Utils.fileToBase64Str(photoPath);
            params[2] = FileTools.getFileName(photoPath);
            return params;
        }
    };


    @PermissionSuccess(requestCode = TagFinal.CAMERA)
    private void takePhoto() {
        FileCamera camera=new FileCamera(mActivity);
        startActivityForResult(camera.takeCamera(), TagFinal.CAMERA);
    }
    @PermissionSuccess(requestCode = TagFinal.PHOTO_ALBUM)
    private void photoAlbum() {
        Intent intent;
        intent = new Intent(mActivity,AlbumOneActivity.class);
        Bundle b = new Bundle();
        b.putInt(TagFinal.ALBUM_LIST_INDEX, 0);
        b.putBoolean(TagFinal.ALBUM_SINGLE, true);
        intent.putExtras(b);
        startActivityForResult(intent,TagFinal.PHOTO_ALBUM);
    }
    @PermissionFail(requestCode = TagFinal.CAMERA)
    private void showCamere() {
        Toast.makeText(getApplicationContext(), R.string.permission_fail_camere, Toast.LENGTH_SHORT).show();
    }
    @PermissionFail(requestCode = TagFinal.PHOTO_ALBUM)
    private void showTip1() {
        Toast.makeText(getApplicationContext(), R.string.permission_fail_album, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    /**
     *----------------------- retrofit -----------------
     */



    private void refresh(){
        Object[] params=new Object[]{
                Variables.user.getSession_key()
        };
        ParamsTask refresh=new ParamsTask(params,TagFinal.USER_INFO,REFRESH);
        execute(refresh);
    }
    private void logout() {

        ReqEnv reqEnv = new ReqEnv();
        ReqBody reqBody = new ReqBody();
        UserLogoutReq req = new UserLogoutReq();
        //获取参数
        req.setApikey(JPushInterface.getRegistrationID(mActivity));
        req.setAndios("and");
        reqBody.userLogoutReq = req;
        reqEnv.body = reqBody;
        Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().user_logout(reqEnv);
        call.enqueue(this);
    }
    public void getCall() {

        ReqEnv reqEnv = new ReqEnv();
        ReqBody reqBody = new ReqBody();
        UserGetCallReq req = new UserGetCallReq();
        //获取参数
        reqBody.userGetCallReq = req;
        reqEnv.body = reqBody;
        Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().user_get_call(reqEnv);
        call.enqueue(this);
    }
    @Override
    public void onResponse(Call<ResEnv> call, Response<ResEnv> response) {
        if (!isActivity())return;
        dismissProgressDialog();
        ResEnv respEnvelope = response.body();
        List<String> names=StringUtils.getListToString(call.request().headers().toString().trim(), "/");
        String name=names.get(names.size()-1);
        if (respEnvelope != null) {
            ResBody b=respEnvelope.body;
            if (b.userGetCallRes !=null){
                String result=b.userGetCallRes.result;
                Logger.e(StringUtils.getTextJoint("%1$s:\n%2$s",name,result));
				IntegralResult info=gson.fromJson(result,IntegralResult.class);
				if (StringJudge.isEmpty(info.getMobile())){
				    call_phone.setText("点击录入");
				    call_phone.setTextColor(ColorRgbUtil.getGrayBackground());
                }else{
                    call_phone.setText(info.getMobile());
                    call_phone.setTextColor(ColorRgbUtil.getBaseText());
                    UserPreferences.getInstance().saveTell(info.getMobile());
				}
            }
            if (b.userLogoutRes !=null){
                String result=b.userLogoutRes.result;
                Logger.e(StringUtils.getTextJoint("%1$s:\n%2$s",name,result));

                BaseRes res=gson.fromJson(result,BaseRes.class);
                if (res.getResult().equalsIgnoreCase(TagFinal.TRUE)){
                    Variables.clearAll(mActivity);
                    Base.user=null;
                    GreenDaoManager.getInstance().clearUser();
                    GreenDaoManager.getInstance().clearMainIndex();
                    UserPreferences.getInstance().clearUserAll();
                    toastShow(R.string.success_user_out);
                    Variables.admin=null;
                    finish();
                }else{
                    toast(res.getError_code());
                }

            }
        }else{
            Logger.e(StringUtils.getTextJoint("%1$s:%2$d",name,response.code()));
        }

    }

    @Override
    public void onFailure(Call<ResEnv> call, Throwable t) {
        if (!isActivity())return;
        Logger.e("onFailure  :"+call.request().headers().toString());
        toast(R.string.fail_do_not);
        dismissProgressDialog();
    }

    @Override
    public boolean isActivity() {
        return AppLess.isTopActivy(TAG);
    }

}
