package com.yfy.app.affiche;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.View;

import com.example.zhao_sheng.R;
import com.yfy.app.net.ReqBody;
import com.yfy.app.net.ReqEnv;
import com.yfy.app.net.ResBody;
import com.yfy.app.net.ResEnv;
import com.yfy.app.net.RetrofitGenerator;
import com.yfy.app.net.affiche.SchoolGetNewsListReq;
import com.yfy.app.school.bean.SchoolNews;
import com.yfy.app.school.bean.SchoolRes;
import com.yfy.base.activity.BaseActivity;
import com.yfy.final_tag.AppLess;
import com.yfy.final_tag.ColorRgbUtil;
import com.yfy.final_tag.StringUtils;
import com.yfy.final_tag.TagFinal;
import com.yfy.jpush.Logger;
import com.yfy.recycerview.EndlessRecyclerOnScrollListener;
import com.yfy.recycerview.RecycleViewDivider;
import com.yfy.final_tag.StringJudge;
import com.yfy.view.SQToolBar;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AfficheActivity extends BaseActivity implements Callback<ResEnv> {


	private final static String TAG = AfficheActivity.class.getSimpleName();
	private AfficheAdapter adapter;
	private List<SchoolNews> schoolNewsList = new ArrayList<SchoolNews>();

	private String no = "022102";
	private int page = 0;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.swip_recycler_main);
		iniySQToolbar();
		initRecycler();
		refresh(true,TagFinal.REFRESH);
	}

	private void iniySQToolbar() {
		assert toolbar!=null;
		toolbar.setTitle(R.string.affiche);
		toolbar.addMenuText(TagFinal.ONE_INT,"test");
		toolbar.setOnMenuClickListener(new SQToolBar.OnMenuClickListener() {
			@Override
			public void onClick(View view, int position) {
				test();
			}
		});
	}
	private void test(){
//RS2PQrwTzTvWVrmRl+qN7w==
		try {
			String pubKey="sdf@#35456-0DFSD@#!";
//			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
////			// 通过种子初始化
//			byte[] values = new byte[256];
//			SecureRandom random = new SecureRandom();
//			random.nextBytes(values);
////
//			SecureRandom secureRandom = new SecureRandom();
//			random.setSeed(pubKey.getBytes("UTF-8"));
//			keyGenerator.init(256, secureRandom);
//			Logger.e(random.getAlgorithm());
//			keyGenerator.init(random);
////			keyGenerator.init();
//			Logger.e(keyGenerator.getAlgorithm());
			// 秘钥
//			byte[] enCodeFormat = keyGenerator.generateKey().getEncoded();
//			byte[] enCodeFormat = Base64.decode(pubKey.getBytes("UTF-8"), Base64.URL_SAFE);
//			byte[] enCodeFormat =pubKey.getBytes("UTF-8");

            byte[] enCodeFormat=new byte[]{(byte)146,
                    (byte) 211,(byte)133,54,
                    (byte)161,(byte)219,(byte)212,
                    (byte)227,53,51,72,5,(byte)225,72,3,
                    (byte)204,(byte)175,(byte)143,(byte)244,(byte)194,(byte)177,
                    (byte)179,0,(byte)216,65,83,(byte)184,54,(byte)162,(byte)148,15,
                    (byte)134};

//			byte[] md5key = MessageDigest.getInstance("MD5").digest(pubKey.getBytes("UTF-8"));
			byte[] md5key=new byte[]{110, (byte) 237, (byte) 235, (byte) 227, (byte) 242,79,88,53, (byte) 225,54,26,127, (byte) 135,90, (byte) 159,8};
			// 创建AES秘钥
			SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
			IvParameterSpec ivParameterSpec = new IvParameterSpec(md5key);
			String msg="123";
			/*使用Cipher加密*/
			/*定义加密方式*/
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			/*使用公钥和加密模式初始化*/
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec,ivParameterSpec);
			/*获取加密内容以UTF-8为标准转化的字节进行加密后再使用base64编码成字符串*/
			/*加密后的字符串*/

			Logger.e(Base64.encodeToString(cipher.doFinal(msg.getBytes("UTF-8")),Base64.URL_SAFE));
//			Logger.e(Base64.encodeToString(enCodeFormat,Base64.URL_SAFE));
			Logger.e(Base64.encodeToString(md5key,Base64.URL_SAFE));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void finish() {
		super.finish();
	}



	private SwipeRefreshLayout swipeRefreshLayout;
	private RecyclerView recyclerView;
	public void initRecycler(){

		recyclerView =  findViewById(R.id.public_recycler);
		swipeRefreshLayout =  findViewById(R.id.public_swip);
		swipeRefreshLayout.setColorSchemeColors(ColorRgbUtil.getBaseColor(),ColorRgbUtil.getGreen());

		// 设置下拉刷新
		swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				// 刷新数据
				refresh(false,TagFinal.REFRESH);
			}
		});
		recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
			@Override
			public void onLoadMore() {
				refresh(false, TagFinal.REFRESH_MORE);
			}
		});

		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		//添加分割线
		recyclerView.addItemDecoration(new RecycleViewDivider(
				mActivity,
				LinearLayoutManager.HORIZONTAL,
				1,
				getResources().getColor(R.color.gray)));
		adapter=new AfficheAdapter(mActivity);
		recyclerView.setAdapter(adapter);
	}
	public void closeSwipeRefresh(){
		if (swipeRefreshLayout!=null){
			swipeRefreshLayout.postDelayed(new Runnable() {
				@Override
				public void run() {
					if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
						swipeRefreshLayout.setRefreshing(false);
					}
				}
			}, 200);
		}
	}






	/**
	 * ------------------retrofit------------------
	 */


	public void refresh(boolean is,String loadType){
		if (loadType.equals(TagFinal.REFRESH)){
			page=0;
		}else{
			page++;
		}
		ReqEnv evn = new ReqEnv();
		ReqBody reqBody = new ReqBody();
		SchoolGetNewsListReq req = new SchoolGetNewsListReq();
		//获取参数

		req.setNo(no);
		req.setPage(page);
		reqBody.schoolGetNewsListReq = req;
		evn.body = reqBody;
		Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().school_news_list(evn);
		call.enqueue(this);
		Logger.e(evn.toString());
		if (is) showProgressDialog("正在加载");
	}






	@Override
	public void onResponse(Call<ResEnv> call, Response<ResEnv> response) {
		if (!isActivity())return;
		dismissProgressDialog();
		if (response.code()==500){
			toastShow("数据出差了");
		}
		closeSwipeRefresh();
		ResEnv respEnvelope = response.body();
		if (respEnvelope != null) {
			ResBody b=respEnvelope.body;
			if (b.schoolGetNewsListRes !=null) {
				String result = b.schoolGetNewsListRes.result;
				Logger.e(call.request().headers().toString()+result);
				SchoolRes res=gson.fromJson(result,SchoolRes.class);
				if (StringJudge.isEmpty(res.getNews())){
					toast(R.string.success_not_more);
					return;
				}
				List<SchoolNews> list =res.getNews();
				if (list.size() < TagFinal.TEN_INT) {
					toastShow("全部加载完毕！");
				}
				if (page==0) {
					schoolNewsList = list;
				}else{
					schoolNewsList.addAll(list);
				}

				adapter.setDataList(schoolNewsList);
				adapter.setLoadState(2);
			}
		}else{
			List<String> names=StringUtils.getListToString(call.request().headers().toString().trim(), "/");
			String name=names.get(names.size()-1);
			Logger.e(name+"--------");
		}

	}

	@Override
	public void onFailure(Call<ResEnv> call, Throwable t) {
		if (!isActivity())return;
		Logger.e("onFailure  :"+call.request().headers().toString());
		dismissProgressDialog();
		closeSwipeRefresh();
		toast(R.string.fail_do_not);
	}


	@Override
	public boolean isActivity() {
		return AppLess.isTopActivy(TAG);
	}
}
