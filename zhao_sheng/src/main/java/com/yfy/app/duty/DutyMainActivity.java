package com.yfy.app.duty;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.zhao_sheng.R;
import com.yfy.app.duty.adpater.DutyMainAdapter;
import com.yfy.app.duty.bean.Info;
import com.yfy.app.duty.bean.InfoRes;
import com.yfy.app.duty.bean.MainB;
import com.yfy.app.duty.bean.MainBean;
import com.yfy.app.duty.bean.MainInfo;
import com.yfy.app.duty.bean.WeekBean;
import com.yfy.app.goods.bean.BeanItem;
import com.yfy.app.net.ReqBody;
import com.yfy.app.net.ReqEnv;
import com.yfy.app.net.ResBody;
import com.yfy.app.net.ResEnv;
import com.yfy.app.net.RetrofitGenerator;
import com.yfy.app.net.duty.DutyTypeReq;
import com.yfy.app.net.duty.DutyUserListReq;
import com.yfy.base.Variables;
import com.yfy.base.activity.BaseActivity;
import com.yfy.base.activity.WcfActivity;
import com.yfy.db.UserPreferences;
import com.yfy.final_tag.AppLess;
import com.yfy.final_tag.ColorRgbUtil;
import com.yfy.final_tag.DateUtils;
import com.yfy.final_tag.StringJudge;
import com.yfy.final_tag.StringUtils;
import com.yfy.final_tag.TagFinal;
import com.yfy.jpush.Logger;
import com.yfy.net.loading.interf.WcfTask;
import com.yfy.net.loading.task.ParamsTask;
import com.yfy.recycerview.EndlessRecyclerOnScrollListener;
import com.yfy.recycerview.RecycleViewDivider;
import com.yfy.view.SQToolBar;
import com.yfy.view.button.BottomItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class  DutyMainActivity extends BaseActivity implements Callback<ResEnv> {
    private static final String TAG = DutyMainActivity.class.getSimpleName();

    @Bind(R.id.duty_main_time)
    TextView chioce_time;//school

    @Bind(R.id.duty_top_one)
    AppCompatTextView one_duty;
    @Bind(R.id.duty_top_two)
    AppCompatTextView two_duty;

    @Bind(R.id.top_layout)
    View top_layout;
    @Bind(R.id.public_top_text)
    TextView parent_name;


    private int page=0;
    private DutyMainAdapter adapter;
    private String enddate="";
    private String startdate="";
    private List<MainB> mainBS=new ArrayList<>();
//    private List<Info> infos=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duty_main);
        initView();
        initSQToolbar();
        initRecycler();
        refresh(true,startdate ,enddate , TagFinal.REFRESH);
    }

    private void initSQToolbar(){
        assert toolbar!=null;
        toolbar.setTitle(R.string.duty_title);

        if (UserPreferences.getInstance().getUserAdmin().getIsdutyreport().equals(TagFinal.TRUE)){
            toolbar.addMenuText(TagFinal.ONE_INT,"我的值周");
        }

        toolbar.setOnMenuClickListener(new SQToolBar.OnMenuClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent;
                switch (position){
                    case  TagFinal.ONE_INT:
                        intent=new Intent(mActivity,DutyTimeActivity.class);
                        startActivityForResult(intent,TagFinal.UI_ADD);
                        break;
                }
            }
        });
    }
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    public void initRecycler(){
        parent_name.setBackgroundColor(ColorRgbUtil.getWhite());
        recyclerView = (RecyclerView) findViewById(R.id.duty_main_recycler);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.public_swip);
        //AppBarLayout 展开执行刷新
        // 设置刷新控件颜色
        swipeRefreshLayout.setColorSchemeColors(ColorRgbUtil.getBaseColor());
        // 设置下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 刷新数据
                refresh(false,startdate ,enddate , TagFinal.REFRESH);
            }
        });

//        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
//            @Override
//            public void onLoadMore() {
//                refresh(false,startdate ,enddate , TagFinal.REFRESH_MORE);
//            }
//        });
        recyclerView.addOnScrollListener(onScrollListener);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter=new DutyMainAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    private RecyclerView.OnScrollListener onScrollListener=new RecyclerView.OnScrollListener() {
        // 用来标记是否正在向上滑动
        private boolean isSlidingUpward = false;
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            isSlidingUpward = dy > 0;
            LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int first=manager.findFirstVisibleItemPosition();
            RecyclerView.ViewHolder holder;
            if (isSlidingUpward){
                holder = recyclerView.findViewHolderForAdapterPosition(first+1);
                if (holder!=null){
                    if (holder instanceof DutyMainAdapter.TopViewHolder){
                        int headerMoveY = holder.itemView.getTop() - top_layout.getMeasuredHeight();
                        if (headerMoveY<0) {
                            top_layout.setTranslationY(headerMoveY);
                        }
                    } else if (holder instanceof DutyMainAdapter.ParentViewHolder){
                        top_layout.setTranslationY(0);
                        parent_name.setText(((DutyMainAdapter.ParentViewHolder) holder).bean.getDate());
                    }else if (holder instanceof DutyMainAdapter.ChildViewHolder){
                        top_layout.setTranslationY(0);
                        parent_name.setText(((DutyMainAdapter.ChildViewHolder) holder).bean.getDate());
                    }
                }
            }else{
                holder = recyclerView.findViewHolderForAdapterPosition(first);
                if (holder!=null){
                    if (holder instanceof DutyMainAdapter.ChildViewHolder){
                        parent_name.setText(((DutyMainAdapter.ChildViewHolder) holder).bean.getDate());
                    }
                }
            }

        }
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
            // 当不滑动时
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                // 获取最后一个完全显示的itemPosition
                int lastItemPosition = manager.findLastCompletelyVisibleItemPosition();
                int itemCount = manager.getItemCount();

                // 判断是否滑动到了最后一个item，并且是向上滑动
                if (lastItemPosition == (itemCount - 1) && isSlidingUpward) {
                    // 加载更多
                    refresh(false,startdate ,enddate , TagFinal.REFRESH_MORE);
                }
            }
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            switch (requestCode){
                case TagFinal.UI_ADD:
                    refresh(true,startdate ,enddate , TagFinal.REFRESH);
                    break;
                case TagFinal.UI_TAG:
                    boolean is=data.getBooleanExtra(TagFinal.TYPE_TAG,false);
                    WeekBean bean=data.getParcelableExtra(TagFinal.OBJECT_TAG);
                    if (is){
                        startdate = bean.getStartdate();
                        enddate = bean.getEnddate();
                        refresh(false,startdate ,enddate , TagFinal.REFRESH);
                        chioce_time.setText(bean.getTermname()
                                +" " + DateUtils.changeDate(startdate,getString(R.string.date_type_2))
                                +" 至 "+DateUtils.changeDate(enddate,getString(R.string.date_type_2)));
                    }else{
                        startdate = bean.getStartdate();
                        enddate = bean.getEnddate();
                        if (StringJudge.isEmpty(bean.getStartdate())){
                            chioce_time.setText(bean.getWeekname());
                        }else{
                            chioce_time.setText(bean.getWeekname()
                                    +"  "+DateUtils.changeDate(startdate,getString(R.string.date_type_2))
                                    +" 至 "+DateUtils.changeDate(enddate,getString(R.string.date_type_2)));
                        }

                        refresh(false,startdate,enddate,TagFinal.REFRESH);
                    }
                    break;
            }
        }
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



    private void initView(){


        two_duty.setTextColor(ColorRgbUtil.getBaseColor());
        two_duty.setBackgroundResource(R.drawable.ic_line_weight_black_24dp);
        one_duty.setTextColor(ColorRgbUtil.getBaseText());
        one_duty.setBackgroundColor(Color.TRANSPARENT);



//        if (true){
//            one_duty.setTextColor(ColorRgbUtil.getBaseColor());
//            two_duty.setTextColor(ColorRgbUtil.getBaseText());
//        }else{
//            two_duty.setTextColor(ColorRgbUtil.getBaseColor());
//            one_duty.setTextColor(ColorRgbUtil.getBaseText());
//        }
    }

    @OnClick(R.id.duty_main_time)
    void setChoice(){
        Intent intent=new Intent(mActivity,DutyDateActivity.class);
        startActivityForResult(intent,TagFinal.UI_TAG);

    }
    @OnClick(R.id.duty_top_one)
    void setOne_duty(){
        one_duty.setTextColor(ColorRgbUtil.getBaseColor());
        one_duty.setBackgroundResource(R.drawable.ic_line_weight_black_24dp);
        two_duty.setTextColor(ColorRgbUtil.getBaseText());
        two_duty.setBackgroundColor(Color.TRANSPARENT);
    }

    @OnClick(R.id.duty_top_two)
    void setTwo_duty(){
        two_duty.setTextColor(ColorRgbUtil.getBaseColor());
        two_duty.setBackgroundResource(R.drawable.ic_line_weight_black_24dp);
        one_duty.setTextColor(ColorRgbUtil.getBaseText());
        one_duty.setBackgroundColor(Color.TRANSPARENT);
    }




    private void getAdapter(List<Info> infos,boolean is){
        if (is) mainBS.clear();
        boolean first=true;
        for (Info info:infos){
            String dat=DateUtils.changeDate(info.getDate(),getString(R.string.date_type));
            String week=DateUtils.getWeek(info.getDate());

            String s_name=info.getTermname()+" "+info.getWeekname()+" "+week+" "+dat;
            if (first){
                first=false;
                parent_name.setText(s_name);
            }
            mainBS.add(new MainB(s_name));//DateUtils.changeDate(info.getDate(),getString(R.string.date_type_2))
            getTwo(info.getDutyreport_type(),s_name);
        }
        adapter.setDataList(mainBS);
        adapter.setLoadState(TagFinal.LOADING_COMPLETE);
    }

    private void getTwo(List<MainInfo> infos,String date) {
        for (MainInfo info : infos) {
            MainB two=new MainB(info.getRealname(),info.getType());
            two.setDate(date);
            mainBS.add(two);
            getThree(info.getDutyreport_list(),date);
        }
    }
    private void getThree(List<MainBean> infos,String date) {
        for (int i=0;i<infos.size();i++) {
            MainBean bean=infos.get(i);
            MainB b=new MainB(bean.getTitle(),bean.getContent(),bean.getIsnormal(),bean.getImage());
            b.setRealname(bean.getRealname());
            b.setDate(date);
            if (i==0){
                b.setChild_bg(TagFinal.ONE_INT);
            }else if (i==infos.size()-1){
                b.setChild_bg(TagFinal.THREE_INT);
            }else{
                b.setChild_bg(TagFinal.TWO_INT);
            }
            mainBS.add(b);
        }
    }

//    @Override
//    public boolean onSuccess(String result, WcfTask wcfTask) {
//        if (!isActivity())return false;
//        dismissProgressDialog();
//        closeSwipeRefresh();
//        Logger.e(TagFinal.ZXX, "onSuccess: "+result);
//        String name=wcfTask.getName();
//        InfoRes infores=gson.fromJson(result,InfoRes.class);
//        if (name.equals(TagFinal.REFRESH)){
//            getAdapter(infores.getDutyreport_list(),true);
//            if (StringJudge.isEmpty(infores.getDutyreport_list())){
//                toast("没有数据！");
//                return false;
//            }
//        }
//        if (name.equals(TagFinal.REFRESH_MORE)){
//            getAdapter(infores.getDutyreport_list(),false);
//            if (infores.getDutyreport_list().size()<TagFinal.TEN_INT){
//                toast("加载完毕！");
//                return false;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public void onError(WcfTask wcfTask) {
//        if (!isActivity())return ;
//        dismissProgressDialog();
//        closeSwipeRefresh();
//        toast(R.string.fail_do_not);
//    }







    /**
     * ----------------------------retrofit-----------------------
     */

   


    public void refresh(boolean is,String sdate,String edate,String loadType){
        if (loadType.equals(TagFinal.REFRESH)){
            page=0;
        }else{
            page++;
        }

        ReqEnv evn = new ReqEnv();
        ReqBody reqBody = new ReqBody();
        DutyUserListReq req = new DutyUserListReq();
        //获取参数
        req.setSdate(sdate);
        req.setEdate(edate);
        req.setPage(page);
        reqBody.dutyUserListReq = req;
        evn.body = reqBody;
        Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().duty_user_list(evn);
        call.enqueue(this);
        if (is)showProgressDialog("");

    }
    @Override
    public void onResponse(Call<ResEnv> call, Response<ResEnv> response) {
        if (!isActivity())return;
        dismissProgressDialog();
        closeSwipeRefresh();
        if (response.code()==500){
//            toast("未获取到数据");
        }

        ResEnv respEnvelope = response.body();
        if (respEnvelope != null) {
            ResBody b=respEnvelope.body;
            if (b.dutyUserListRes!=null){
                String result=b.dutyUserListRes.result;
                Logger.e(call.request().headers().toString()+result );
                InfoRes res=gson.fromJson(result,InfoRes.class);
                if (page==0){
                    getAdapter(res.getDutyreport_list(),true);
                    if (StringJudge.isEmpty(res.getDutyreport_list())){
                        toastShow("没有数据！");
                    }
                }else{
                    getAdapter(res.getDutyreport_list(),false);
                    if (res.getDutyreport_list().size()<TagFinal.TEN_INT){
                        toastShow("加载完毕！");
                    }
                }

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
        toastShow(R.string.fail_do_not);
    }



    @Override
    public boolean isActivity() {
        return AppLess.isTopActivy(TAG);
    }
}
