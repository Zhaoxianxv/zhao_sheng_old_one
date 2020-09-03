/**
 *
 */
package com.yfy.app.vote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zhao_sheng.R;
import com.yfy.app.maintainnew.bean.MainRes;
import com.yfy.app.net.ReqBody;
import com.yfy.app.net.ReqEnv;
import com.yfy.app.net.ResEnv;
import com.yfy.app.net.ResBody;
import com.yfy.app.net.RetrofitGenerator;
import com.yfy.app.net.maintain.MaintainGetUserListReq;
import com.yfy.app.net.vote.VoteGetMainListReq;
import com.yfy.app.vote.adapter.VoteMainAdapter;
import com.yfy.app.vote.bean.Vote;
import com.yfy.app.vote.bean.VoteRes;
import com.yfy.base.activity.BaseActivity;
import com.yfy.final_tag.AppLess;
import com.yfy.final_tag.ColorRgbUtil;
import com.yfy.final_tag.StringUtils;
import com.yfy.final_tag.TagFinal;
import com.yfy.jpush.Logger;
import com.yfy.json.JsonParser;
import com.yfy.recycerview.EndlessRecyclerOnScrollListener;
import com.yfy.recycerview.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author yfy1
 * @Date 2015年11月26日
 * @version 1.0
 * @Desprition
 */
public class VoteListActivity extends BaseActivity implements Callback<ResEnv> {

	private final static String TAG = VoteListActivity.class.getSimpleName();

	private VoteMainAdapter adapter;
	private List<Vote> voteList = new ArrayList<>();

	private int page = 0;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.swip_recycler_main);
		initSQToolbar();
		initRecycler();
		refresh(true,TagFinal.REFRESH);
	}

	private void initSQToolbar() {
		assert toolbar!=null;
		toolbar.setTitle("投票");

	}







	private SwipeRefreshLayout swipeRefreshLayout;
	private RecyclerView recyclerView;
	public void initRecycler(){

		recyclerView =  findViewById(R.id.public_recycler);
		swipeRefreshLayout =  findViewById(R.id.public_swip);
		//AppBarLayout 展开执行刷新
		// 设置刷新控件颜色
		swipeRefreshLayout.setColorSchemeColors(ColorRgbUtil.getBaseColor());
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
				refresh(false,TagFinal.REFRESH_MORE);
			}
		});

		recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        xlist.setLayoutManager(new GridLayoutManager(this, 1));
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		//添加分割线
		recyclerView.addItemDecoration(new RecycleViewDivider(
				mActivity,
				LinearLayoutManager.HORIZONTAL,
				1,
				ColorRgbUtil.getGainsboro()));
		adapter=new VoteMainAdapter(mActivity);
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






	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			switch (requestCode){
				case TagFinal.UI_ADD:
					refresh(false,TagFinal.REFRESH);
					break;
			}
		}
	}


	/**
	 * -------------------retrofit---------------------
	 */


	private void refresh(boolean is,String loadType) {
		if (loadType.equals(TagFinal.REFRESH)){
			page=0;
		}else{
			adapter.setLoadState(TagFinal.LOADING);
			page++;
		}
		ReqEnv reqEnv = new ReqEnv();
		ReqBody reqBody = new ReqBody();
		VoteGetMainListReq req = new VoteGetMainListReq();
		//获取参数
		req.setPage(page);
		req.setSize(TagFinal.FIFTEEN_INT);

		reqBody.voteGetMainListReq = req;
		reqEnv.body = reqBody;
		Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().vote_get_main_list(reqEnv);
		call.enqueue(this);
		if (is) showProgressDialog("");
	}





	@Override
	public void onResponse(Call<ResEnv> call, Response<ResEnv> response) {
		if (!isActivity())return;
		dismissProgressDialog();
		closeSwipeRefresh();
		List<String> names=StringUtils.getListToString(call.request().headers().toString().trim(), "/");
		String name=names.get(names.size()-1);
		ResEnv respEnvelope = response.body();
		if (respEnvelope != null) {
			ResBody b=respEnvelope.body;
			if (b.voteGetMainListRes !=null){
				String result=b.voteGetMainListRes.result;
				Logger.e(StringUtils.getTextJoint("%1$s:\n%2$s",name,result));
//				if (JsonParser.isSuccess(result)) {
//
//				} else {
//					toastShow(JsonParser.getErrorCode(result));
//				}
				VoteRes res=gson.fromJson(result,VoteRes.class);
				if (page==0){
					voteList=res.getVotetitle();
				}else {
					voteList.addAll(res.getVotetitle());
				}
				if (res.getVotetitle().size()!=TagFinal.FIFTEEN_INT){
					toast(R.string.success_not_more);
					adapter.setLoadState(TagFinal.LOADING_END);
				}else{
					adapter.setLoadState(TagFinal.LOADING_COMPLETE);
				}
				adapter.setDataList(voteList);

			}

		}else{
			Logger.e(StringUtils.getTextJoint("%1$s:%2$d",name,response.code()));
			toastShow(StringUtils.getTextJoint("数据错误:%1$d",response.code()));
		}
	}

	@Override
	public void onFailure(Call<ResEnv> call, Throwable t) {
		if (!isActivity())return;
		Logger.e("onFailure  :"+call.request().headers().toString());
		toast(R.string.fail_do_not);
        closeSwipeRefresh();
        dismissProgressDialog();
	}

	@Override
	public boolean isActivity() {
		return AppLess.isTopActivy(TAG);
	}

}
