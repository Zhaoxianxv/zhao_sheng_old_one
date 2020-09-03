package com.yfy.app.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.zhao_sheng.R;
import com.yfy.app.net.ReqBody;
import com.yfy.app.net.ReqEnv;
import com.yfy.app.net.ResBody;
import com.yfy.app.net.ResEnv;
import com.yfy.app.net.RetrofitGenerator;
import com.yfy.app.net.base.UserAlterPassReq;
import com.yfy.base.Variables;
import com.yfy.base.activity.BaseActivity;
import com.yfy.db.GreenDaoManager;
import com.yfy.db.UserPreferences;
import com.yfy.dialog.LoadingDialog;
import com.yfy.final_tag.AppLess;
import com.yfy.final_tag.StringJudge;
import com.yfy.final_tag.StringUtils;
import com.yfy.jpush.Logger;
import com.yfy.json.JsonParser;
import com.yfy.view.SQToolBar;

import java.util.List;

import butterknife.Bind;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlterPassActivity extends BaseActivity implements Callback<ResEnv> {
    private static final String TAG = AlterPassActivity.class.getSimpleName();
    @Bind(R.id.alter_old_password)
    EditText old;
    @Bind(R.id.alter_new_first_password)
    EditText first;
    @Bind(R.id.alter_new_again_password)
    EditText again;
    private String oldpass,firstpass,againpass;

    private LoadingDialog loadingDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_center);
        loadingDialog=new LoadingDialog(mActivity);
        initSQToolbar();
    }


    public void initSQToolbar(){
        assert toolbar!=null;
        toolbar.setTitle("修改密码");

        toolbar.addMenuText(1,R.string.ok);

        toolbar.setOnMenuClickListener(new SQToolBar.OnMenuClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (isSend()){
                    alterpass();
                }

            }
        });
    }

    public boolean isSend(){
        oldpass=old.getText().toString().trim();
        firstpass=first.getText().toString().trim();
        againpass=again.getText().toString().trim();
        if (StringJudge.isEmpty(oldpass)){
            toast("请输入密码");
            return false;
        }
        if (StringJudge.isEmpty(firstpass)){
            toast("请输入新密码");
            return false;
        }
        if (StringJudge.isEmpty(againpass)){
            toast("请再次输入新密码");
            return false;
        }
        if (firstpass.equals(againpass)){

        }else{
            toast("新密码输入不一致");
            return false;
        }
        return true;
    }



    /**
     *-----------------------------retrofit
     */


    private void alterpass() {



        ReqEnv reqEnv = new ReqEnv();
        ReqBody reqBody = new ReqBody();
        UserAlterPassReq req = new UserAlterPassReq();
        //获取参数
        req.setNewpassword(firstpass);
        req.setOldpassword(oldpass);
        reqBody.userAlterPassReq = req;
        reqEnv.body = reqBody;
        Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().user_alter_pass(reqEnv);
        call.enqueue(this);
        showProgressDialog("");
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
            if (b.userAlterPassRes !=null){
                String result=b.userAlterPassRes.result;
                Logger.e(StringUtils.getTextJoint("%1$s:\n%2$s",name,result));
                if (JsonParser.isSuccess(result)){
                    Variables.user =null;
                    UserPreferences.getInstance().clearUserAll();
                    GreenDaoManager.getInstance().clearUser();
                    toast("密码修改成功，请重新登录");

                    startActivity(new Intent(mActivity,LoginActivity.class));
                    onPageBack();
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
        dismissProgressDialog();
    }

    @Override
    public boolean isActivity() {
        return AppLess.isTopActivy(TAG);
    }

}
