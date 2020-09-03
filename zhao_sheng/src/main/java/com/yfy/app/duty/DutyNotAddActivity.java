package com.yfy.app.duty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zhao_sheng.R;
import com.yfy.app.duty.adpater.DutyNotAddAdapter;
import com.yfy.app.duty.bean.AddBean;
import com.yfy.app.duty.bean.Addinfo;
import com.yfy.app.duty.bean.InfoRes;
import com.yfy.app.duty.bean.PlaneA;
import com.yfy.base.Variables;
import com.yfy.base.activity.WcfActivity;
import com.yfy.final_tag.AppLess;
import com.yfy.final_tag.StringJudge;
import com.yfy.final_tag.TagFinal;
import com.yfy.net.loading.interf.WcfTask;
import com.yfy.net.loading.task.ParamsTask;

import java.util.ArrayList;
import java.util.List;

public class DutyNotAddActivity extends WcfActivity {
    private static final String TAG = DutyNotAddActivity.class.getSimpleName();

    private DutyNotAddAdapter adapter;
    private List<Addinfo> list=new ArrayList<>();
    private List<AddBean> addBeans=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.public_recycler_view);
        initRecycler();
        getData();
    }


    private void getData(){
        Intent intent=getIntent();
        PlaneA beanA=intent.getParcelableExtra(TagFinal.OBJECT_TAG);
        initSQToolbar(beanA.getDate());

        AddBean bean=new AddBean(true);
        bean.setType_name(beanA.getDutyreporttype());
        addBeans.add(bean);
        adapter.setDataList(addBeans);
        adapter.setLoadState(TagFinal.LOADING_COMPLETE);

        getPlane(beanA.getDate(),beanA.getTypeid());

    }
    private void initSQToolbar(String title){
        assert toolbar!=null;
        toolbar.setTitle(title);

    }



    private RecyclerView recyclerView;
    public void initRecycler(){

        recyclerView = (RecyclerView) findViewById(R.id.public_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        adapter=new DutyNotAddAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    public void getPlane(String date,String typeid){
        Object[] params = new Object[] {
                Variables.user.getSession_key(),
                typeid,
                date
        };
        ParamsTask get_plane = new ParamsTask(params, TagFinal.DUTY_GET_ADD_DETAILS, TagFinal.DUTY_GET_ADD_DETAILS);
        execute(get_plane);
        showProgressDialog("");

    }


    @Override
    public boolean onSuccess(String result, WcfTask wcfTask) {
        if (!isActivity())return true;
        dismissProgressDialog();
        String name=wcfTask.getName();
        if (name.equals(TagFinal.DUTY_GET_ADD_DETAILS)){
            InfoRes info=gson.fromJson(result,InfoRes.class );
            if (StringJudge.isEmpty(info.getDutyreport_type())){
                toastShow("数据出差");
            }else{
                list = info.getDutyreport_type();
                if (list.size()==TagFinal.ONE_INT){
                    //直接赋值
                    addBeans.addAll(list.get(0).getDutyreport_content());
                    adapter.setDataList(addBeans);
                    adapter.setLoadState(TagFinal.LOADING_COMPLETE);
                }
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

    @Override
    public boolean isActivity() {
        return AppLess.isTopActivy(TAG);
    }




}
