package com.yfy.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.zhao_sheng.R;
import com.yfy.base.App;
import com.yfy.base.Base;
import com.yfy.base.Variables;
import com.yfy.db.GreenDaoManager;
import com.yfy.db.MainIndex;
import com.yfy.dialog.ConfirmAlbumWindow;
import com.yfy.final_tag.ColorRgbUtil;
import com.yfy.final_tag.StringJudge;
import com.yfy.final_tag.TagFinal;
import com.yfy.jpush.Logger;

import java.util.List;

/**
 * Created by yfyandr on 2017/12/27.
 */

public class HomeMainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<HomeIntent> dataList;
    private HomeNewActivity mContext;
    private String user_name;
    public void setDataList(List<HomeIntent> dataList) {

        this.dataList = dataList;
//        getRandomHeights(dataList);
    }
    // 普通布局
    private final int TYPE_ITEM = 1;
    // 脚布局
    private final int TYPE_FOOTER = 2;
    // 当前加载状态，默认为加载完成
    private int loadState = 2;
    // 正在加载
    public final int LOADING = 1;
    // 加载完成
    public final int LOADING_COMPLETE = 2;
    // 加载到底
    public final int LOADING_END = 3;

    public HomeMainAdapter(HomeNewActivity mContext, List<HomeIntent> dataList) {
        this.mContext=mContext;
        this.dataList = dataList;

    }

    @Override
    public int getItemViewType(int position) {
        // 最后一个item设置为FooterView
            return TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //进行判断显示类型，来创建返回不同的View
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_main_item_recyclerview, parent, false);
            return new RecyclerViewHolder(view);

        }
        return null;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecyclerViewHolder) {
            RecyclerViewHolder reHolder = (RecyclerViewHolder) holder;
            reHolder.bean=dataList.get(position);
            reHolder.icon.setImageResource(reHolder.bean.getDrawableId());
            reHolder.name.setText(reHolder.bean.getName());
            reHolder.initDialog();
            int count = reHolder.bean.getPushCount();
            if (count > 0 && count < 100) {
                reHolder.dot.setText("");
                reHolder.dot.setVisibility(View.VISIBLE);
            } else if (count >= 100) {
                reHolder.dot.setText("99+");
                reHolder.dot.setVisibility(View.VISIBLE);
            } else {
                reHolder.dot.setVisibility(View.GONE);
            }

            if (reHolder.bean.isBase()){
                reHolder.icon.setColorFilter(ColorRgbUtil.getBaseColor());
            }else{
                reHolder.icon.setColorFilter(ColorRgbUtil.getGrayText());
            }

        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout layout;
        ImageView icon;
        TextView name;
        TextView dot;
        HomeIntent bean;
        RecyclerViewHolder(View itemView) {
            super(itemView);
            layout= (RelativeLayout) itemView.findViewById(R.id.home_main_item_layout);
            icon= (ImageView) itemView.findViewById(R.id.home_item_project_icon);
            name= (TextView) itemView.findViewById(R.id.home_item_project_name);
            dot= (TextView) itemView.findViewById(R.id.home_item_project_dot);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (StringJudge.isEmpty( App.getApp().getDaoSession().getMainIndexDao().queryRaw("where key = \""+bean.getIndex()+"\""))){
                    }else{
                        MainIndex mainIndex=GreenDaoManager.getInstance().geMainIndex(bean.getIndex());
                        int num=mainIndex.getNum();
                        ++num;
                        Logger.e(""+num);
                        mainIndex.setNum(num);
                        GreenDaoManager.getInstance().saveMainIndex(mainIndex);
                    }
                    if (bean.isChoice()){
                        if (StringJudge.isEmpty(bean.getAdmin())){
                            mContext.getUserAdmin();
                        }else{
                            switch (bean.getIndex()){
                                case "11":
                                    String url = TagFinal.SCHEDULE + Variables.user.getSession_key();
                                    Intent intent=bean.getIntent();
                                    Bundle b = new Bundle();
                                    b.putString(TagFinal.URI_TAG, url);
                                    b.putString(TagFinal.TITLE_TAG, "课程表");
                                    intent.putExtras(b);
                                    mContext.startActivity(intent);
                                    break;
                                case "25":
                                    album_select.showAtCenter();
                                    break;
                                case "26":
                                    album_select.showAtCenter();

                                    break;
                                case "28":


                                    if (Base.user.getUsertype().equals(TagFinal.USER_TYPE_TEA)){
                                        Intent intentdelay =bean.getIntent();
                                        Bundle b_delay = new Bundle();
                                        b_delay.putBoolean(TagFinal.TYPE_TAG,false);
                                        b_delay.putBoolean("admin",false );
                                        intentdelay.putExtras(b_delay);
                                        mContext.startActivity(intentdelay);
                                    }
                                    break;
//                                case "29":
//                                    if (Base.user.getUsertype().equals(TagFinal.USER_TYPE_TEA)){
//                                        Intent intentdelay =bean.getIntent();
//                                        Bundle b_delay = new Bundle();
//                                        b_delay.putBoolean(TagFinal.TYPE_TAG,false);
//                                        b_delay.putBoolean("admin",false );
//                                        intentdelay.putExtras(b_delay);
//                                        mContext.startActivity(intentdelay);
//                                    }
//                                    break;
                                    default:
                                        mContext.startActivity(bean.getIntent());
                                        break;
                            }
                        }
                    }else{
                        mContext.toastShow("请登录教师用户");
                    }

                }
            });
        }

        private ConfirmAlbumWindow album_select;
        private void initDialog() {
            album_select = new ConfirmAlbumWindow(mContext);
            album_select.setOne_select("教师");
            album_select.setTwo_select("学生");
            album_select.setName("请选择");
            album_select.setOnPopClickListenner(new ConfirmAlbumWindow.OnPopClickListenner() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.popu_select_one:
                            Base.user_check_type="tea";
                            mContext.startActivity(bean.getIntent());
                            break;
                        case R.id.popu_select_two:
                            Base.user_check_type="stu";
                            mContext.startActivity(bean.getIntent());
                            break;
                    }
                }
            });
        }
    }



    /**
     * 设置上拉加载状态
     *
     * @param loadState 1.正在加载 2.加载完成 3.加载到底
     */
    public void setLoadState(int loadState) {
        this.loadState = loadState;
        notifyDataSetChanged();
    }

}
