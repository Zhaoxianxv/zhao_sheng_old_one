package com.yfy.app.integral;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.zhao_sheng.R;
import com.yfy.app.XlistLefttTxtAdapter;
import com.yfy.app.integral.beans.IntegralResult;
import com.yfy.base.Variables;
import com.yfy.base.activity.WcfActivity;
import com.yfy.final_tag.TagFinal;
import com.yfy.jpush.Logger;
import com.yfy.net.loading.interf.WcfTask;
import com.yfy.net.loading.task.ParamsTask;
import com.yfy.view.swipe.xlist.XListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class HonorRankActivity extends WcfActivity {

    @Bind(R.id.honor_type_xlist)
    XListView xlist;
    private List<String> names=new ArrayList<>();
    private List<String> types=new ArrayList<>();
    private XlistLefttTxtAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.integral_honor_type);
        getData();
        initSQToolbar();
        initView();

    }

    public void getData(){
        refresh(getIntent().getStringExtra("type"));
    }


    //获取学期列表
    public void refresh(String type){
        Object[] params = new Object[] {
                Variables.user.getSession_key(),
                type
        };
        ParamsTask send = new ParamsTask(params, TagFinal.HONOR_RANK, TagFinal.HONOR_RANK);
        execute(send);

    }
    @Override
    public boolean onSuccess(String result, WcfTask wcfTask) {
        Logger.e("zxx","  "+result);
        IntegralResult re=gson.fromJson(result,IntegralResult.class);
        names=re.getRewardtypes();
        adapter.notifyDataSetChanged(names);
        return false;
    }

    @Override
    public void onError(WcfTask wcfTask) {

    }



    private void initSQToolbar() {
        assert toolbar!=null;
        toolbar.setTitle("");
    }
    private void initView() {
        xlist.setPullRefreshEnable(false);
        xlist.setPullLoadEnable(false);
        adapter=new XlistLefttTxtAdapter(mActivity,names);
        xlist.setAdapter(adapter);
        xlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent();
                intent.putExtra("type_name",names.get(i-1));
                setResult(RESULT_OK,intent);
                onPageBack();
            }
        });
    }


}
