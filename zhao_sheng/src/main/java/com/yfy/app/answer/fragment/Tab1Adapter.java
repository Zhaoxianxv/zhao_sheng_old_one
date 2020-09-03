package com.yfy.app.answer.fragment;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.zhao_sheng.R;
import com.yfy.app.answer.bean.AnswerListBean;
import com.yfy.base.XlistAdapter;

import java.util.List;

/**
 * Created by yfyandr on 2017/8/2.
 */

public class Tab1Adapter extends XlistAdapter<AnswerListBean> {

    private final String S="条回答 | ";
    private Context context;

    public Tab1Adapter(Context context, List<AnswerListBean> list) {
        super(context, list);
        this.context=context;
    }

    @Override
    public void renderData(int position, ViewHolder holder, List<AnswerListBean> list) {
        AnswerListBean bean=list.get(position);
        holder.getView(TextView.class,R.id.answer_tab1_item_theme).setText(bean.getContent());
        holder.getView(TextView.class,R.id.answer_tab1_item_name).setText(bean.getUser_name());
        String ps=bean.getAnswer_count()+S+bean.getTime();
        holder.getView(TextView.class,R.id.answer_tab1_item_ps).setText(ps);


        ImageView head=holder.getView(ImageView.class,R.id.answer_tab1_item_head);
        Glide.with(context)
                .load(bean.getUser_avatar())
                .apply(new RequestOptions().circleCrop())
                .into(head);
    }

    @Override
    public ResInfo getResInfo() {
        ResInfo res=new ResInfo();

        res.layout= R.layout.answer_tab1_itme;
        res.initIds=new int[]{
                R.id.answer_tab1_item_head,
                R.id.answer_tab1_item_theme,
                R.id.answer_tab1_item_ps,
                R.id.answer_tab1_item_name,

        };
        return res;
    }
}
