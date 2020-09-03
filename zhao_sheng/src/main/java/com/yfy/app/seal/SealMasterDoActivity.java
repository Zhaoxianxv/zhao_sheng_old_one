//package com.yfy.app.seal;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.design.internal.FlowLayout;
//import android.support.v7.widget.AppCompatImageView;
//import android.support.v7.widget.DefaultItemAnimator;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.example.zhao_sheng.R;
//import com.yfy.app.bean.KeyValue;
//import com.yfy.base.activity.BaseActivity;
//import com.yfy.final_tag.TagFinal;
//import com.yfy.recycerview.RecycleViewDivider;
//import com.yfy.view.SQToolBar;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.Bind;
//
//public class SealMasterDoActivity extends BaseActivity {
//    private static final String TAG = SealMasterDoActivity.class.getSimpleName();
//
//    @Bind(R.id.seal_do_state)
//    FlowLayout state_flow;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.seal_master_do);
//        initData();
//        initSQtoobar("申请管理");
//
//    }
//
//
//    private void initSQtoobar(String title) {
//        assert toolbar!=null;
//        toolbar.setTitle(title);
//        toolbar.addMenuText(TagFinal.ONE_INT, "确定");
//        toolbar.setOnMenuClickListener(new SQToolBar.OnMenuClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                setResult(RESULT_OK);
//                finish();
//            }
//        });
//    }
//
//
//
//    private void initData(){
//        do_states.add(new KeyValue(TagFinal.FALSE,"1","同意"));
//        do_states.add(new KeyValue(TagFinal.FALSE,"2","拒绝"));
//        setChild(do_states, state_flow);
//    }
//    private List<KeyValue> do_states=new ArrayList<>();
//    private String state_value="";
//    public void setChild(List<KeyValue> list, FlowLayout flow){
//        LayoutInflater mInflater = LayoutInflater.from(mActivity);
//        if (flow.getChildCount()!=0){
//            flow.removeAllViews();
//        }
//        for (final KeyValue bean:list){
//            RelativeLayout layout = (RelativeLayout) mInflater.inflate(R.layout.seal_do_item,flow, false);
//            layout=layout.findViewById(R.id.seal_do_layout);
//            TextView key=layout.findViewById(R.id.seal_do_key);
//            final AppCompatImageView value=layout.findViewById(R.id.seal_do_value);
//            key.setText(bean.getName());
//            value.setVisibility(View.GONE);
//            if (bean.getKey().equalsIgnoreCase(TagFinal.TRUE)){
//                value.setVisibility(View.VISIBLE);
//            }else{
//                value.setVisibility(View.GONE);
//            }
//            layout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                   initCrate(bean);
//
//                }
//            });
//            flow.addView(layout);
//        }
//    }
//
//
//    private void initCrate(KeyValue bean){
//
//        for (KeyValue value:do_states){
//            value.setKey(TagFinal.FALSE);
//            if (bean.getValue().equals(value.getValue())){
//                value.setKey(TagFinal.TRUE);
//            }
//        }
//        setChild(do_states, state_flow);
//    }
//
//
//
//}
