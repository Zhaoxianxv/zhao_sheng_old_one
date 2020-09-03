/**
 *
 */
package com.yfy.app.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.zhao_sheng.R;
import com.yfy.app.login.bean.Stunlist;
import com.yfy.app.login.bean.UserRes;
import com.yfy.app.net.RetrofitGenerator;
import com.yfy.app.net.login.UserDuplicationLoginReq;
import com.yfy.app.net.login.UserGetDuplicationListReq;
import com.yfy.app.net.login.UserLoginReq;
import com.yfy.app.net.ReqBody;
import com.yfy.app.net.ReqEnv;
import com.yfy.app.net.ResEnv;
import com.yfy.app.net.ResBody;
import com.yfy.base.Base;
import com.yfy.base.Variables;
import com.yfy.base.activity.BaseActivity;
import com.yfy.db.GreenDaoManager;
import com.yfy.db.UserPreferences;
import com.yfy.dialog.ConfirmAlbumWindow;
import com.yfy.final_tag.AppLess;
import com.yfy.final_tag.RxCaptcha;
import com.yfy.final_tag.StringJudge;
import com.yfy.final_tag.StringUtils;
import com.yfy.final_tag.TagFinal;
import com.yfy.db.User;
import com.yfy.jpush.Logger;
import com.yfy.json.JsonParser;
import com.yfy.keyboard.password.KeyboardTouchListener;
import com.yfy.keyboard.password.KeyboardUtil;
import com.yfy.final_tag.ConvertObjtect;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.yfy.final_tag.RxCaptcha.TYPE.NUMBER;


/**
 * @author yfy1
 * @Date 2015年11月27日
 * @version 1.0
 * @Desprition
 */
public class LoginActivity extends BaseActivity implements Callback<ResEnv>{

	private final static String TAG =LoginActivity.class.getSimpleName();

	private List<Stunlist> stunLists =new ArrayList<>();
	private String stu_id;


	@Bind(R.id.login_phone)
	EditText account;
	@Bind(R.id.login_password)
	EditText password;
	@Bind(R.id.login_code)
	EditText code;
	@Bind(R.id.login_code_image)
	ImageView code_icon;
	private String edit_name = "";
	private String edit_password = "";
	private String edit_code = "";
	private String type = "";
	private String code_s="";
	private RxCaptcha rxCaptcha;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_main);
		initSQToolbar();
		initDialog();
		rxCaptcha=RxCaptcha.build();
		rxCaptcha.backColor(R.color.exchange_able_4)
				.codeLength(4)
				.fontSize(60)
				.lineNumber(2)
				.size(200, 70)
				.type(NUMBER)
				.into(code_icon);
		code_s=rxCaptcha.getCode();
//		Logger.e(code_s);
		initMoveKeyBoard();
	}

	@OnClick(R.id.login_code_image)
	void setImage(){
		rxCaptcha=RxCaptcha.build();
		rxCaptcha.backColor(R.color.exchange_able_4)
				.codeLength(4)
				.fontSize(60)
				.lineNumber(2)
				.size(200, 70)
				.type(NUMBER)
				.into(code_icon);
		code_s=rxCaptcha.getCode();
	}

	private void initSQToolbar(){
		assert toolbar!=null;
		toolbar.setTitle("登录");
	}
	ConfirmAlbumWindow album_select;
	private void initDialog() {
		album_select = new ConfirmAlbumWindow(mActivity);
		album_select.setOne_select("教师");
		album_select.setTwo_select("学生");
		album_select.setName("请选择账号类型");
		album_select.setOnPopClickListenner(new ConfirmAlbumWindow.OnPopClickListenner() {
			@Override
			public void onClick(View view) {
				switch (view.getId()) {
					case R.id.popu_select_one:
						type = "2";
						login();
						break;
					case R.id.popu_select_two:
						type = "1";
						login();
						break;
				}

			}
		});
	}

	@OnClick(R.id.login_button)
	void setlogin(){
		if (isCanSend()){
			album_select.showAtBottom();
		}

	}



	@OnClick(R.id.login_forget_password)
	void setForget(){

		Intent intent=new Intent(mActivity,PhoneCodectivity.class);
		startActivity(intent);
	}


	public AlertDialog.Builder  listDialog;
	private void initDialog(String[] sex) {
		listDialog = new AlertDialog.Builder(mActivity);
//		builder.setIcon(R.drawable.ic_launcher);
		listDialog.setTitle("请选择");
		//    设置一个单项选择下拉框
		/**
		 * 第一个参数指定我们要显示的一组下拉单选框的数据集合
		 * 第二个参数代表索引，指定默认哪一个单选框被勾选上，1表示默认'女' 会被勾选上
		 * 第三个参数给每一个单选项绑定一个监听器
		 */
		listDialog.setSingleChoiceItems(sex, -1, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				stu_id= stunLists.get(which).getStuid();
			}
		});
		listDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				duplicationLogin();
				dialog.dismiss();
			}
		});
		listDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});

		listDialog.show();
	}



	private boolean isCanSend() {
		closeKeyWord();
		edit_name = account.getText().toString().trim();
		edit_password = password.getText().toString().trim();
		edit_code = code.getText().toString().trim();


		if (StringJudge.isEmpty(edit_code)) {
			toast(R.string.please_edit_code);
			return false;
		}
		if (!edit_code.equals(code_s)){
			toastShow(R.string.please_edit_yse_code);
			return false;
		}
		if (StringJudge.isEmpty(edit_name)) {
			toast(R.string.please_edit_account);
			return false;
		}
		if (StringJudge.isEmpty(edit_password)) {
			toast(R.string.please_edit_password);
			return false;
		}
		return true;
	}


    /**
	 * ----------------------------retrofit-----------------------
	 */




	private void getDuplicationList() {
		ReqEnv reqEnv = new ReqEnv();
		ReqBody reqBody = new ReqBody();
		UserGetDuplicationListReq req = new UserGetDuplicationListReq();
		//获取参数
		req.setUsername(edit_name);
		req.setPassword(edit_password);
		req.setCode("");

		reqBody.userGetDuplicationListReq = req;
		reqEnv.body = reqBody;
		Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().user_get_duplication_user(reqEnv);
		call.enqueue(this);
		showProgressDialog("");
	}
	private void duplicationLogin() {
		//登陆时传的Constants.APP_ID：
		ReqEnv reqEnv = new ReqEnv();
		ReqBody reqBody = new ReqBody();
		UserDuplicationLoginReq req = new UserDuplicationLoginReq();
		//获取参数

		req.setUsername(edit_name);
		req.setPassword(edit_password);
		req.setAppid(type);
		req.setStuid(ConvertObjtect.getInstance().getInt(stu_id));

		reqBody.userDuplicationLoginReq = req;
		reqEnv.body = reqBody;
		Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().user_duplication_login(reqEnv);
		call.enqueue(this);
	}


	private void login() {
		//登陆时传的Constants.APP_ID：
		String apikey=JPushInterface.getRegistrationID(mActivity);
		if(apikey==null){
			apikey="";
		}
		ReqEnv reqEnv = new ReqEnv();
		ReqBody reqBody = new ReqBody();
		UserLoginReq request = new UserLoginReq();
		//获取参数
		request.setUsername(edit_name);
		request.setPassword(edit_password);
		request.setRole_id(type);
		request.setAppid(apikey);

		reqBody.userLoginReq = request;
		reqEnv.body = reqBody;
		Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().user_login(reqEnv);
		call.enqueue(this);
		showProgressDialog("");

	}

	@Override
	public void onResponse(Call<ResEnv> call, Response<ResEnv> response) {

		if (!isActivity())return;
		dismissProgressDialog();
		List<String> names=StringUtils.getListToString(call.request().headers().toString().trim(), "/");
		String name=names.get(names.size()-1);
		ResEnv respEnvelope = response.body();
		if (respEnvelope != null) {
			ResBody b=respEnvelope.body;
			if (b.userLoginRes !=null){
				String result=b.userLoginRes.result;
				Logger.e(StringUtils.getTextJoint("%1$s:\n%2$s",name,result));
				UserRes res= gson.fromJson(result,UserRes.class);
				if (JsonParser.isSuccess(result)) {
					toastShow("登录成功");
					User user=new User(null);
					user.setSession_key(res.getSession_key());
					user.setHeadPic(res.getUserinfo().getHeadPic());
					user.setFxid(res.getUserinfo().getFxid());
					user.setName(res.getUserinfo().getName());
					user.setPwd(edit_password);
					user.setUsertype( type.equals("1")? TagFinal.USER_TYPE_STU : TagFinal.USER_TYPE_TEA);
					user.setIdU(res.getUserinfo().getId());
					user.setUsername(res.getUserinfo().getUsername());
					Variables.user =user;
					Base.user=user;
					UserPreferences.getInstance().setUserInfo(user);
					UserPreferences.getInstance().saveClassId(res.getUserinfo().getClassid());
					GreenDaoManager.getInstance().saveNote(user);

					finish();
				} else {
					if (res.getError_code().equals("重名")){
						getDuplicationList();
					}else{
						toastShow(res.getError_code());
					}

				}
			}
			if (b.userGetDuplicationListRes !=null){
				String result=b.userGetDuplicationListRes.result;
				Logger.e(StringUtils.getTextJoint("%1$s:\n%2$s",name,result));
				UserRes res= gson.fromJson(result,UserRes.class);
				stunLists =res.getStunlist();
				List<String> s=new ArrayList<>();
				for (Stunlist stu: stunLists) {
					s.add(stu.getClassname());
				}
				String[] st=new String[s.size()];
				initDialog(s.toArray(st));
			}
			if (b.userDuplicationLoginRes !=null){
				String result=b.userDuplicationLoginRes.result;
				Logger.e(StringUtils.getTextJoint("%1$s:\n%2$s",name,result));
				UserRes res= gson.fromJson(result,UserRes.class);
				if (JsonParser.isSuccess(result)) {
					toastShow("登录成功");
					User user=new User(null);
					user.setSession_key(res.getSession_key());
					user.setHeadPic(res.getUserinfo().getHeadPic());
					user.setFxid(res.getUserinfo().getFxid());
					user.setName(res.getUserinfo().getName());
					user.setPwd(edit_password);
					user.setUsertype( type.equals("1")? TagFinal.USER_TYPE_STU : TagFinal.USER_TYPE_TEA);
					user.setIdU(res.getUserinfo().getId());
					user.setUsername(res.getUserinfo().getUsername());
					Variables.user =user;
					Base.user=user;
					UserPreferences.getInstance().setUserInfo(user);
					UserPreferences.getInstance().saveClassId(res.getUserinfo().getClassid());
					GreenDaoManager.getInstance().saveNote(user);
					finish();
				}
			}
		}else{

			Logger.e(StringUtils.getTextJoint("%1$s:%2$d",name,response.code()));
			toastShow(StringUtils.getTextJoint("数据错误:%1$d",response.code()));
		}

	}

	@Override
	public void onFailure(Call<ResEnv> call, Throwable t) {
		if (!isActivity())return;
		dismissProgressDialog();
		Logger.e( "onFailure  "+call.request().headers().toString() );
		toast(R.string.fail_do_not);

	}

	@Override
	public boolean isActivity() {
		return AppLess.isTopActivy(TAG);
	}




	//password edit keyboard
	@Bind(R.id.all_ed)
	LinearLayout rootView;
	@Bind(R.id.sv_main)
	ScrollView scrollView;
	private KeyboardUtil keyboardUtil;
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0 ) {
			if(keyboardUtil.isShow){
				keyboardUtil.hideSystemKeyBoard();
				keyboardUtil.hideAllKeyBoard();
				keyboardUtil.hideKeyboardLayout();
			}else {
				return super.onKeyDown(keyCode, event);
			}

			return false;
		} else
			return super.onKeyDown(keyCode, event);
	}

	private void initMoveKeyBoard() {
		keyboardUtil = new KeyboardUtil(this, rootView, scrollView);
		keyboardUtil.setOtherEdittext(account,code);
		// monitor the KeyBarod state
		keyboardUtil.setKeyBoardStateChangeListener(new KeyBoardStateListener());
		// monitor the finish or next Key
		keyboardUtil.setInputOverListener(new inputOverListener());
		password.setOnTouchListener(new KeyboardTouchListener(keyboardUtil, KeyboardUtil.INPUTTYPE_ABC, -1));
	}

	class KeyBoardStateListener implements KeyboardUtil.KeyBoardStateChangeListener {

		@Override
		public void KeyBoardStateChange(int state, EditText editText) {
//            System.out.println("state" + state);
//            System.out.println("editText" + editText.getText().toString());
		}
	}

	class inputOverListener implements KeyboardUtil.InputFinishListener {

		@Override
		public void inputHasOver(int onclickType, EditText editText) {
//            System.out.println("onclickType" + onclickType);
//            System.out.println("editText" + editText.getText().toString());
		}
	}

}
