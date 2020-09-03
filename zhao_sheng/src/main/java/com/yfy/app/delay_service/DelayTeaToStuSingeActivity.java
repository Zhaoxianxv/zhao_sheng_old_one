package com.yfy.app.delay_service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zhao_sheng.R;
import com.yfy.app.album.AlbumOneActivity;
import com.yfy.app.album.MultPicShowActivity;
import com.yfy.app.bean.DateBean;
import com.yfy.app.delay_service.bean.EventClass;
import com.yfy.app.delay_service.bean.EventRes;
import com.yfy.app.delay_service.bean.OperType;
import com.yfy.base.Base;
import com.yfy.base.activity.WcfActivity;
import com.yfy.dialog.ConfirmAlbumWindow;
import com.yfy.final_tag.AppLess;
import com.yfy.final_tag.Base64Utils;
import com.yfy.final_tag.FileCamera;
import com.yfy.final_tag.Photo;
import com.yfy.final_tag.StringJudge;
import com.yfy.final_tag.StringUtils;
import com.yfy.final_tag.TagFinal;
import com.yfy.jpush.Logger;
import com.yfy.net.loading.interf.WcfTask;
import com.yfy.net.loading.task.ExtraRunTask;
import com.yfy.net.loading.task.ParamsTask;
import com.yfy.permission.PermissionFail;
import com.yfy.permission.PermissionGen;
import com.yfy.permission.PermissionSuccess;
import com.yfy.permission.PermissionTools;
import com.yfy.view.SQToolBar;
import com.yfy.view.multi.MultiPictureView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class DelayTeaToStuSingeActivity extends WcfActivity {
    private static final String TAG = DelayTeaToStuSingeActivity.class.getSimpleName();



    @Bind(R.id.delay_tea_to_stu_set_multi)
    MultiPictureView multi;
    @Bind(R.id.delay_tea_to_stu_set_date)
    AppCompatTextView date_show;
    @Bind(R.id.delay_tea_to_stu_set_user)
    AppCompatTextView user_name;
    @Bind(R.id.delay_tea_to_stu_set_type)
    AppCompatTextView delay_type;
    @Bind(R.id.delay_tea_to_stu_set_reason_edit)
    EditText reason_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delay_tea_tostu_set);
        getData();
        initMulti();
        initDialog();
        initSQtoobar("学生考勤",true);

    }


    private String tea_id;
    private DateBean dateBean;
    private EventClass stubean;
    private void getData(){
        Bundle b=getIntent().getExtras();

        stubean=b.getParcelable(Base.data);
        tea_id=b.getString(Base.id);
        dateBean=b.getParcelable(Base.date);

        date_show.setText(dateBean.getName());
        user_name.setText(stubean.getStuname());


    }

    private void initSQtoobar(String title ,boolean is) {
        assert toolbar!=null;
        toolbar.setTitle(title);
        toolbar.addMenuText(TagFinal.ONE_INT,"添加" );
        toolbar.setOnMenuClickListener(new SQToolBar.OnMenuClickListener() {
            @Override
            public void onClick(View view, int position) {
                add();
            }
        });
    }




    /**
     * ----------------------------retrofit-----------------------
     */





    private void add(){
        String content=reason_edit.getText().toString().trim();
        if (StringJudge.isEmpty(content))content="";

        if (select_opertype==null){
            toastShow("请选择考评类型");
            return;
        }

        List<String> stuids=new ArrayList<>();
        List<String> ids=new ArrayList<>();
        ids.add("0");
        stuids.add(stubean.getStuid());


        Object[] params = new Object[] {
                Base.user.getSession_key(),
                StringUtils.getParamsXml(ids),
                stubean.getElectiveid(),
                tea_id,
                StringUtils.getParamsXml(stuids),
                StringUtils.upJson(content),//content,//content
                dateBean.getValue(),//data
                select_opertype.getOpearname(),//type
                "",//image
                "",//
                "0",//stucount
                "0",
                "tea",//checktype
        };
        ParamsTask choice = new ParamsTask(params, TagFinal.DELAY_TEA_ADD,TagFinal.DELAY_TEA_ADD);
        ExtraRunTask wrapTask = new ExtraRunTask(choice);
        wrapTask.setExtraRunnable(extraRunnable);
        showProgressDialog("");
        execute(wrapTask);
    }


    private ExtraRunTask.ExtraRunnable extraRunnable = new ExtraRunTask.ExtraRunnable() {

        @Override
        public Object[] onExecute(Object[] params) {
            List<Photo> list=new ArrayList<>();
            int i=0;
            for (String uri:multi.getList()){
                Photo p=new Photo();
                i++;
                String picName = String.valueOf(System.currentTimeMillis())+String.valueOf(i);
                p.setFileName(picName+".jpg");
                p.setPath(uri);
                list.add(p);
            }

            List<String> images=new ArrayList<>();
            images.add("#");
            String image=StringUtils.getParamsXml(images);
            if (StringJudge.isEmpty(list)){
                params[8] = image.replace("#", "");
            }else{
                params[8] = image.replace("#", Base64Utils.getZipTitleNotice(list));
            }

            params[9] = Base64Utils.filesToZipBase64Notice(list);
            return params;
        }
    };




    @Override
    public boolean onSuccess(String result, WcfTask wcfTask) {
        if (!isActivity())return false;
        dismissProgressDialog();
        Logger.e(result);
        String name=wcfTask.getName();
        if (name.equals(TagFinal.DELAY_TEA_ADD)){
            EventRes res=gson.fromJson(result,EventRes.class );
            if (res.getResult().equals(TagFinal.TRUE)){
                toastShow("设置成功！");
                setResult(RESULT_OK);
                finish();
            }else{
                toastShow(res.getError_code());
            }
        }

        return false;
    }

    @Override
    public void onError(WcfTask wcfTask) {
        if (!isActivity())return;
        dismissProgressDialog();
        toastShow(R.string.fail_do_not);

    }


    /**
     * ----------------------------retrofit-----------------------
     */


    ConfirmAlbumWindow album_select;
    private void initDialog() {
        album_select = new ConfirmAlbumWindow(mActivity);
        album_select.setTwo_select(getResources().getString(R.string.album));
        album_select.setOne_select(getResources().getString(R.string.take_photo));
        album_select.setName(getResources().getString(R.string.upload_place));
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

    @Override
    public boolean isActivity() {
        return AppLess.isTopActivy(TAG);
    }


    private void initMulti(){
        multi.setAddClickCallback(new MultiPictureView.AddClickCallback() {
            @Override
            public void onAddClick(View view) {
                closeKeyWord();
                album_select.showAtBottom();
            }
        });

        multi.setClickable(false);

        multi.setDeleteClickCallback(new MultiPictureView.DeleteClickCallback() {
            @Override
            public void onDeleted(@NotNull View view, int index) {
                multi.removeItem(index,true);
            }
        });
        multi.setItemClickCallback(new MultiPictureView.ItemClickCallback() {
            @Override
            public void onItemClicked(@NotNull View view, int index, @NotNull ArrayList<String> uris) {
                Intent intent=new Intent(mActivity, MultPicShowActivity.class);
                Bundle b=new Bundle();
                b.putStringArrayList(TagFinal.ALBUM_SINGE_URI,uris);
                b.putInt(TagFinal.ALBUM_LIST_INDEX,index);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

    }



    private OperType select_opertype;
    @OnClick(R.id.delay_tea_to_stu_set_type)
    void setOval(){
        Intent intent=new Intent(mActivity,DelayServiceOperActivity.class);
//        isclass 0为给学生打分选项 1为给班级打分选项
        int isclass=0;
        intent.putExtra(Base.id, isclass);
        startActivityForResult(intent,TagFinal.UI_ADMIN );
    }






    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case TagFinal.CAMERA:
                    addMult(FileCamera.photo_camera);
                    break;
                case TagFinal.PHOTO_ALBUM:
                    ArrayList<Photo> photo_a=data.getParcelableArrayListExtra(TagFinal.ALBUM_TAG);
                    if (photo_a==null)return;
                    if (photo_a.size()==0)return;
                    setMultList(photo_a);
                    break;
                case TagFinal.UI_ADMIN:
                    select_opertype=data.getParcelableExtra(Base.data);
                    delay_type.setText(select_opertype.getOpearname());
                    break;
            }
        }
    }






    public void addMult(String uri){
        if (uri==null) return;
        multi.addItem(uri);
    }
    public void setMultList(List<Photo> list){
        for (Photo photo:list){
            if (photo==null) continue;
            addMult(photo.getPath());
        }
    }

    @PermissionSuccess(requestCode = TagFinal.CAMERA)
    private void takePhoto() {
        FileCamera camera=new FileCamera(mActivity);
        startActivityForResult(camera.takeCamera(), TagFinal.CAMERA);
    }
    @PermissionSuccess(requestCode = TagFinal.PHOTO_ALBUM)
    private void photoAlbum() {
        Intent intent;
        intent = new Intent(mActivity, AlbumOneActivity.class);
        Bundle b = new Bundle();
        b.putInt(TagFinal.ALBUM_LIST_INDEX, 0);
        b.putBoolean(TagFinal.ALBUM_SINGLE, false);
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



}
