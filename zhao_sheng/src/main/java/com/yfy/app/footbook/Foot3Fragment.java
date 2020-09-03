package com.yfy.app.footbook;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.zhao_sheng.R;
import com.google.gson.Gson;
import com.yfy.app.bean.DateBean;
import com.yfy.app.net.ReqBody;
import com.yfy.app.net.ReqEnv;
import com.yfy.app.net.ResBody;
import com.yfy.app.net.ResEnv;
import com.yfy.app.net.RetrofitGenerator;
import com.yfy.app.net.footbook.FootBookGetPopularReq;
import com.yfy.app.net.footbook.FootBookPraiseReq;
import com.yfy.app.video.beans.VideoInfo;
import com.yfy.base.Variables;
import com.yfy.base.fragment.BaseFragment;
import com.yfy.final_tag.StringUtils;
import com.yfy.final_tag.TagFinal;
import com.yfy.jpush.Logger;
import com.yfy.view.swipe.xlist.XListView;
import com.yfy.view.swipe.xlist.XlistListener;
import com.yfy.final_tag.ConvertObjtect;
import com.yfy.final_tag.StringJudge;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yfyandr on 2017/8/1.
 */

public class Foot3Fragment extends BaseFragment implements Callback<ResEnv> {
    private static final String TAG = "zxx";

    @Bind(R.id.answer_tab1_xlist)
    XListView xlist;
    private FootBookAdapter adapter;
    private List<Foot> foots = new ArrayList<>();


    private int page = 0;
    private Gson gson = new Gson();
    private int type;

    private DateBean dateBean;

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        setContentView(R.layout.answer_tab1_fragment);
        dateBean = new DateBean();
        dateBean.setValue_long(System.currentTimeMillis(),true );
        FootBookMainActivity.setFootBookInterFace(2, foot);
        initView();

    }

    private String session_key="";
    @Override
    public void onResume() {
        super.onResume();
        if (Variables.user ==null){
            session_key="gus0";
        }else{
            session_key=Variables.user.getSession_key();
        }
        if (StringJudge.isEmpty(foots)){

        }else{
            refreshData(true);
        }
    }



    public void initView() {
        xlist.setPullLoadEnable(true);
        xlist.setPullRefreshEnable(true);
        adapter = new FootBookAdapter(mActivity, foots);
        xlist.setAdapter(adapter);
        adapter.setIsPriase(isPriase);
        xlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0)return;

//                startActivity(intent);
            }
        });
        xlist.setXListViewListener(new XlistListener() {
            @Override
            public void onRefresh() {
                super.onRefresh();
                refreshData(true);
            }

            @Override
            public void onLoadMore() {
                super.onLoadMore();
                refreshData(false);
            }
        });
    }





    public FootBookMainActivity.FootBookInterFace foot = new FootBookMainActivity.FootBookInterFace() {
        @Override
        public void foot(int i) {
            type = i;
            refreshData(true);
        }
    };




    private FootBookAdapter.IsPriase isPriase=new FootBookAdapter.IsPriase() {
        @Override
        public void isPriase(String id, String state) {
            int id_foot= ConvertObjtect.getInstance().getInt(id);
            if (state.equals("true")){
//                ispriase(id_foot,0);
            }else{
                ispriase(id_foot,1);
            }
        }
    };










    /**
     *------------------------------------
     */



    public void ispriase(int id,int state){


        ReqEnv env = new ReqEnv();
        ReqBody reqBody = new ReqBody();
        FootBookPraiseReq req = new FootBookPraiseReq();
        //获取参数

        req.setSession_key(session_key);
        req.setDate(dateBean.getValue());
        req.setState(state);
        req.setId(String.valueOf(id));

        reqBody.footBookPraiseReq = req;
        env.body = reqBody;
        Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().footbook_praise(env);
        call.enqueue(this);
        showProgressDialog("");
    }


    public void refreshData(boolean is){

        ReqEnv env = new ReqEnv();
        ReqBody reqBody = new ReqBody();
        FootBookGetPopularReq req = new FootBookGetPopularReq();
        //获取参数

        req.setSession_key(session_key);
        req.setDate(dateBean.getValue());
        req.setType(String.valueOf(type));
        req.setPage(page);

        reqBody.footBookGetPopularReq = req;
        env.body = reqBody;
        Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().footbook_get_popular(env);
        call.enqueue(this);
        showProgressDialog("");
    }






    @Override
    public void onResponse(Call<ResEnv> call, Response<ResEnv> response) {
        dismissProgressDialog();
        if (xlist!=null){
            xlist.stopRefresh();
            xlist.stopLoadMore();
        }
        if (response.code()==500){
            toastShow("数据出差了");
        }
        List<String> names=StringUtils.getListToString(call.request().headers().toString().trim(), "/");
        String name=names.get(names.size()-1);
        ResEnv respEnvelope = response.body();
        if (respEnvelope != null) {
            ResBody b=respEnvelope.body;
            if (b.footBookGetPopularRes !=null){
                String result=b.footBookGetPopularRes.result;
                Logger.e(StringUtils.getTextJoint("%1$s:\n%2$s",name,result));
                VideoInfo res=gson.fromJson(result, VideoInfo.class);
                if (res.getResult().equalsIgnoreCase(TagFinal.TRUE)){
                    if (res.getResult().equalsIgnoreCase(TagFinal.TRUE)){
                        if (page==0){
                            foots.clear();
                            foots=res.getCookbook();
                        }else{
                            foots.addAll(res.getCookbook());
                        }
                        adapter.setDataList(foots);

                    }else {
                        toastShow(res.getError_code());
                    }

                }else {
                    toastShow(res.getError_code());
                }
            }
            if (b.footBookPraiseRes !=null){
                String result=b.footBookPraiseRes.result;
                Logger.e(StringUtils.getTextJoint("%1$s:\n%2$s",name,result));
                FootRes res=gson.fromJson(result, FootRes.class);
                if (res.getResult().equalsIgnoreCase(TagFinal.TRUE)){
                    refreshData(true);
                }else {
                    toastShow(res.getError_code());
                }
            }

        }else{
            Logger.e(name+"---ResEnv:null");
        }

    }

    @Override
    public void onFailure(Call<ResEnv> call, Throwable t) {
        Logger.e("onFailure  :"+call.request().headers().toString());
        toastShow(R.string.fail_do_not);
        if (xlist!=null){
            xlist.stopRefresh();
            xlist.stopLoadMore();
        }

        dismissProgressDialog();
    }

}