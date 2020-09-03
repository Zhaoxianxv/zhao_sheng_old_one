package com.yfy.app.check;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.zhao_sheng.R;
import com.yfy.app.bean.DateBean;
import com.yfy.app.check.adapter.CheckClassAdapter;
import com.yfy.app.check.adapter.CheckTypeAdapter;
import com.yfy.app.check.bean.CheckRes;
import com.yfy.app.check.bean.CheckState;
import com.yfy.app.check.bean.CheckStu;
import com.yfy.app.check.bean.ClasslistBean;
import com.yfy.app.check.bean.IllType;
import com.yfy.app.check.bean.IllTypeGroup;
import com.yfy.app.net.ReqBody;
import com.yfy.app.net.ReqEnv;
import com.yfy.app.net.ResBody;
import com.yfy.app.net.ResEnv;
import com.yfy.app.net.RetrofitGenerator;
import com.yfy.app.net.check.CheckGetClassReq;
import com.yfy.app.net.check.CheckGetIllTypeReq;
import com.yfy.app.net.check.CheckGetTypeReq;
import com.yfy.base.activity.BaseActivity;
import com.yfy.dialog.ConfirmDateWindow;
import com.yfy.final_tag.AppLess;
import com.yfy.final_tag.ColorRgbUtil;
import com.yfy.final_tag.DateUtils;
import com.yfy.final_tag.TagFinal;
import com.yfy.jpush.Logger;
import com.yfy.recycerview.DefaultItemAnimator;
import com.yfy.recycerview.RecycleViewDivider;
import com.yfy.view.SQToolBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckTypeActivity extends BaseActivity implements Callback<ResEnv> {

    private static final String TAG = CheckTypeActivity.class.getSimpleName();


    private CheckTypeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swip_recycler_main);

        getData();
        initRecycler();
        initSQtoolbar();
        getCheckIllType();

    }
    private CheckStu checkStu;
    private DateBean dateBean;
    private ClasslistBean classlistBean;
    private CheckState checkState;
    private IllType bean;
    public void getData(){
        checkStu=getIntent().getParcelableExtra(TagFinal.OBJECT_TAG);
        dateBean=getIntent().getParcelableExtra(TagFinal.TYPE_TAG);
        checkState=getIntent().getParcelableExtra(TagFinal.type);
        classlistBean=getIntent().getParcelableExtra(TagFinal.CLASS_BEAN);
    }


    private void initSQtoolbar() {
        assert toolbar!=null;
        toolbar.setTitle("选择类型");

    }





    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    public void initRecycler(){

        recyclerView = (RecyclerView) findViewById(R.id.public_recycler);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.public_swip);
        //AppBarLayout 展开执行刷新
        // 设置刷新控件颜色
        swipeRefreshLayout.setColorSchemeColors(ColorRgbUtil.getBaseColor());
        // 设置下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 刷新数据
                getCheckIllType();
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
                getResources().getColor(R.color.gray)));
        adapter=new CheckTypeAdapter(mActivity);
        recyclerView.setAdapter(adapter);
        adapter.setCheckState(checkState);
        adapter.setCheckStu(checkStu);
        adapter.setClasslistBean(classlistBean);
        adapter.setDateBean(dateBean);


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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            switch (requestCode){
                case TagFinal.UI_ADD:
                    setResult(RESULT_OK);
                    finish();
                    break;
            }
        }
    }

    /**
     * ----------------------------retrofit-----------------------
     */


    public void getCheckIllType() {

        ReqEnv evn = new ReqEnv();
        ReqBody reqBody = new ReqBody();
        CheckGetIllTypeReq request = new CheckGetIllTypeReq();
        //获取参数

        reqBody.checkGetIllTypeReq= request;
        evn.body = reqBody;
        Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().check_get_ill_type(evn);
        call.enqueue(this);
//        Logger.e(evn.toString());

    }

    @Override
    public void onResponse(Call<ResEnv> call, Response<ResEnv> response) {
        if (!isActivity())return;
        dismissProgressDialog();
        closeSwipeRefresh();
        if (response.code()==500){
            toastShow("数据出差了");
        }
        ResEnv respEnvelope = response.body();
        if (respEnvelope != null) {
            ResBody b=respEnvelope.body;


            if (b.checkGetIllTypeRes!=null) {
                String result = b.checkGetIllTypeRes.result;
                Logger.e(call.request().headers().toString() + result);
                CheckRes res=gson.fromJson(result,CheckRes.class);
                if (res.getResult().equals(TagFinal.TRUE)){

                    adapter_list.clear();
                    for (IllTypeGroup group:res.getInspecttype()){
                        IllType illType=new IllType();
                        illType.setView_type(TagFinal.TYPE_PARENT);
                        illType.setIlltypegroupname(group.getIlltypegroupname());
                        adapter_list.add(illType);
                        for (IllType type:group.getIlltypegroup()){
                            type.setView_type(TagFinal.TYPE_CHILD);
                            adapter_list.add(type);
                        }
                    }
                    adapter.setDataList(adapter_list);
                    adapter.setLoadState(TagFinal.LOADING_COMPLETE);
                }else{
                    toastShow(res.getError_code());
                }

            }
        }else{
            Logger.e("evn: null"+call.request().headers().toString() );
        }
    }
    List<IllType> adapter_list=new ArrayList<>();

    @Override
    public void onFailure(Call<ResEnv> call, Throwable t) {
        if (!isActivity())return;
        Logger.e("onFailure  "+call.request().headers().toString() );
        dismissProgressDialog();
        closeSwipeRefresh();
        toastShow(R.string.fail_do_not);
    }

    @Override
    public boolean isActivity() {
        return AppLess.isTopActivy(TAG);
    }
}
