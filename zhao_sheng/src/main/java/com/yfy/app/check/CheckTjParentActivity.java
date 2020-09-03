package com.yfy.app.check;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zhao_sheng.R;
import com.yfy.app.bean.DateBean;
import com.yfy.app.check.adapter.CheckTjParentAdapter;
import com.yfy.app.check.bean.CheckRes;
import com.yfy.app.check.bean.IllGroup;
import com.yfy.app.net.ResBody;
import com.yfy.app.net.ResEnv;
import com.yfy.base.Base;
import com.yfy.base.activity.BaseActivity;
import com.yfy.final_tag.AppLess;
import com.yfy.final_tag.ColorRgbUtil;
import com.yfy.final_tag.StringUtils;
import com.yfy.final_tag.TagFinal;
import com.yfy.jpush.Logger;
import com.yfy.recycerview.DefaultItemAnimator;
import com.yfy.recycerview.RecycleViewDivider;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckTjParentActivity extends BaseActivity implements Callback<ResEnv> {

    private static final String TAG = CheckTjParentActivity.class.getSimpleName();
    private CheckTjParentAdapter adapter;


    private DateBean dateBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.public_recycler_view);
        initSQToolbar();
        initRecycler();
        getData();
    }


    private ArrayList<IllGroup> data_list=new ArrayList<>();
    private void getData(){
        data_list=getIntent().getParcelableArrayListExtra(TagFinal.OBJECT_TAG);
        dateBean=getIntent().getParcelableExtra(Base.date);
//        Logger.e(dateBean.getName());
        adapter.setDateBean(dateBean);
        adapter.setDataList(data_list);
        adapter.setLoadState(TagFinal.LOADING_END);
    }
    private void initSQToolbar(){
        assert toolbar!=null;
        toolbar.setTitle("年级统计");

    }


    private RecyclerView recyclerView;
    public void initRecycler(){

        recyclerView = (RecyclerView) findViewById(R.id.public_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        xlist.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        recyclerView.addItemDecoration(new RecycleViewDivider(
                mActivity,
                LinearLayoutManager.HORIZONTAL,
                1,
                ColorRgbUtil.getGainsboro()));
        adapter=new CheckTjParentAdapter(mActivity);
        recyclerView.setAdapter(adapter);





    }



    /**
     * ----------------------------retrofit-----------------------
     */







    @Override
    public void onResponse(Call<ResEnv> call, Response<ResEnv> response) {
        if (!isActivity())return;
        dismissProgressDialog();
//        closeSwipeRefresh();
        if (response.code()==500){
            toastShow("数据出差了");
        }
        ResEnv respEnvelope = response.body();
        if (respEnvelope != null) {
            ResBody b=respEnvelope.body;
            if (b.checkTjListRes!=null) {
                String result = b.checkTjListRes.result;
                Logger.e(call.request().headers().toString() + result);
                CheckRes res=gson.fromJson(result,CheckRes.class);
                adapter.setDataList(res.getGrouplist());
                adapter.setLoadState(TagFinal.LOADING_COMPLETE);
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
        Logger.e("onFailure  "+call.request().headers().toString() );
        dismissProgressDialog();
//        closeSwipeRefresh();
        toastShow(R.string.fail_do_not);
    }

    @Override
    public boolean isActivity() {
        return AppLess.isTopActivy(TAG);
    }
}
