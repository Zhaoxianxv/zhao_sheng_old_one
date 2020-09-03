package com.yfy.app.tea_evaluate.adpter;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zhao_sheng.R;
import com.yfy.app.album.SingePicShowActivity;
import com.yfy.app.tea_evaluate.bean.AddPararem;
import com.yfy.app.tea_evaluate.bean.GradeBean;
import com.yfy.dialog.DialogTools;
import com.yfy.final_tag.ColorRgbUtil;
import com.yfy.final_tag.DateUtils;
import com.yfy.final_tag.TagFinal;
import com.yfy.jpush.Logger;
import com.yfy.tool_textwatcher.EmptyTextWatcher;
import com.yfy.view.multi.MultiPictureView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yfy1 on 2016/10/17.
 */
public class AddListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {




    private List<AddPararem> dataList;
    private Context mContext;

    public void setDataList(List<AddPararem> dataList) {
        this.dataList = dataList;
//        getRandomHeights(dataList);
    }

    public List<AddPararem> getDataList() {
        return dataList;
    }

    // 普通布局
    private final int TYPE_DATE = 1;
    // 脚布局
    private final int TYPE_TEXT = 2;
    private final int TYPE_PIC = 3;
    private final int TYPE_SELECTED = 4;
    private final int TYPE_BASE = 5;
    private final int TYPE_NUM = 6;


    // 当前加载状态，默认为加载完成
    private int loadState = 2;
    // 正在加载
    public final int LOADING = 1;
    // 加载完成
    public final int LOADING_COMPLETE = 2;
    // 加载到底
    public final int LOADING_END = 3;






    public AddListAdapter(Context mContext, List<AddPararem> dataList){

        this.mContext=mContext;
        this.dataList = dataList;
    }











    @Override
    public int getItemViewType(int position) {
        // 最后一个item设置为FooterView

        switch (dataList.get(position).getType()){
            case "date":
                return TYPE_DATE;
            case "text":
                return TYPE_TEXT;
            case "select":
                return TYPE_SELECTED;
            case "multifile":
                return TYPE_PIC;
            case "base":
                return TYPE_BASE;
            case "int":
                return TYPE_TEXT;
            default:
                return TYPE_PIC;

        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //进行判断显示类型，来创建返回不同的View
        switch (viewType){
            case TYPE_DATE:
                View view_date = LayoutInflater.from(parent.getContext()).inflate(R.layout.tea_item_date, parent, false);
                return new RecyclerDateHolder(view_date);
            case TYPE_TEXT:
                View view_text = LayoutInflater.from(parent.getContext()).inflate(R.layout.tea_item_text, parent, false);
                return new RecyclerTextHolder(view_text);
            case TYPE_SELECTED:
                View view_selecte = LayoutInflater.from(parent.getContext()).inflate(R.layout.tea_item_selecte, parent, false);
                return new RecyclerSelecteHolder(view_selecte);
            case TYPE_PIC:
                View view_pic = LayoutInflater.from(parent.getContext()).inflate(R.layout.tea_item_pic, parent, false);
                return new RecyclerPicHolder(view_pic);
            case TYPE_BASE:
                View view_base = LayoutInflater.from(parent.getContext()).inflate(R.layout.tea_item_base, parent, false);
                return new BaseHolder(view_base);

        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof RecyclerDateHolder) {
            RecyclerDateHolder reHolder = (RecyclerDateHolder) holder;
            reHolder.bean=dataList.get(position);
            reHolder.name.setText(reHolder.bean.getName());


        } else if (holder instanceof RecyclerSelecteHolder) {
            RecyclerSelecteHolder re_selecte = (RecyclerSelecteHolder) holder;
            re_selecte.bean=dataList.get(position);
            re_selecte.name.setText(re_selecte.bean.getName());

        } else if (holder instanceof RecyclerTextHolder) {
            RecyclerTextHolder re_text = (RecyclerTextHolder) holder;
            re_text.bean=dataList.get(position);
            re_text.name.setText(re_text.bean.getName());
            re_text.content.setHint("点击输入"+re_text.bean.getName());

            if (re_text.bean.getType().equals("int")){
                re_text.content.setInputType(InputType.TYPE_CLASS_NUMBER);
            }else{
                re_text.content.setInputType(InputType.TYPE_CLASS_TEXT);
            }

        } else if (holder instanceof RecyclerPicHolder) {
            RecyclerPicHolder re_pic = (RecyclerPicHolder) holder;
            re_pic.bean=dataList.get(position);
            re_pic.name.setText(re_pic.bean.getName());
            re_pic.remark.setVisibility(View.GONE);
        }else if (holder instanceof BaseHolder) {
            BaseHolder baseHolder = (BaseHolder) holder;
            baseHolder.bean=dataList.get(position);
            baseHolder.name.setText(baseHolder.bean.getTitle());
            baseHolder.content.setText(baseHolder.bean.getName());

        }
    }

    @Override
    public int getItemCount() {
        return dataList.size() ;
    }

    private class RecyclerDateHolder extends RecyclerView.ViewHolder {
        TextView date;
        TextView name;
        AddPararem bean;
        RecyclerDateHolder(View itemView) {
            super(itemView);
            date= (TextView) itemView.findViewById(R.id.tea_chioce_date);
            name= (TextView) itemView.findViewById(R.id.tea_chioce_naem);
            date.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogTools
                            .getInstance()
                            .showDatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                                    String date2 = DateUtils.getDate2(year, month, dayOfMonth);

//                                    trophy_date = DateUtils.getDate(year, month, dayOfMonth);
                                    date.setText(date2);
                                    bean.setTitle(DateUtils.getDate(year, month, dayOfMonth));
                                }
                            });
                }
            });
        }
    }

    private class RecyclerTextHolder extends RecyclerView.ViewHolder {
        TextView name;
        EditText content;
        AddPararem bean;
        RecyclerTextHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.tea_add_name);
            content=  itemView.findViewById(R.id.edit_people);
            content.addTextChangedListener(new EmptyTextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {
                    super.afterTextChanged(s);

                    bean.setTitle(s.toString());
                }
            });

        }
    }

    private class RecyclerSelecteHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView grade;
        AddPararem bean;
        RecyclerSelecteHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.tea_chioce_name );
            grade= (TextView) itemView.findViewById(R.id.tea_chioce_grade );
             grade.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     AlertDialog.Builder  listDialog;

                     List<GradeBean> list= bean.getInfo();

                     List<String> s=new ArrayList<>();
                     for (GradeBean grade:list){
                         s.add(grade.getValue());
                     }
                     final String[] strArr = new String[s.size()];
                     s.toArray(strArr);
                     listDialog = new AlertDialog.Builder(mContext);
//		builder.setIcon(R.drawable.ic_launcher);
                     listDialog.setTitle("请选择");
                     //    设置一个单项选择下拉框
                     /**
                      * 第一个参数指定我们要显示的一组下拉单选框的数据集合
                      * 第二个参数代表索引，指定默认哪一个单选框被勾选上，1表示默认'女' 会被勾选上
                      * 第三个参数给每一个单选项绑定一个监听器
                      */
                     listDialog.setSingleChoiceItems(strArr, -1, new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             grade.setText(bean.getInfo().get(which).getValue());
                             grade.setTextColor(ColorRgbUtil.getBaseText());
                             bean.setTitle(bean.getInfo().get(which).getValue());
                             dialog.dismiss();
                         }
                     });
                     listDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             dialog.dismiss();
                         }
                     });
                     listDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             dialog.dismiss();
                         }
                     });

                     listDialog.show();
                 }
             });

        }
    }

    private class BaseHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView content;
        AddPararem bean;
        BaseHolder(View itemView) {
            super(itemView);
            name=  itemView.findViewById(R.id.tea_base_name );
            content=  itemView.findViewById(R.id.tea_base_content );

        }
    }


    private class RecyclerPicHolder extends RecyclerView.ViewHolder {
        TextView name;
        AppCompatTextView remark;
        MultiPictureView multi;
        AddPararem bean;
        RecyclerPicHolder(View itemView) {
            super(itemView);
            multi=  itemView.findViewById(R.id.tea_add_mult );
            name=  itemView.findViewById(R.id.tea_icon_name );
            remark=  itemView.findViewById(R.id.tea_icon_remark );
            initAbsListView(multi);

        }
    }
    private void initAbsListView(final MultiPictureView add_mult) {
        add_mult.setAddClickCallback(new MultiPictureView.AddClickCallback() {
            @Override
            public void onAddClick(View view) {
                Logger.e("zxx", "onAddClick: ");
//                typeDialog.showAtBottom();
                if (pic!=null){
                    pic.add(add_mult);
                }
            }
        });

        add_mult.setClickable(false);

        add_mult.setDeleteClickCallback(new MultiPictureView.DeleteClickCallback() {
            @Override
            public void onDeleted(@NotNull View view, int index) {
                add_mult.removeItem(index,true);
            }
        });
        add_mult.setItemClickCallback(new MultiPictureView.ItemClickCallback() {
            @Override
            public void onItemClicked(@NotNull View view, int index, @NotNull ArrayList<String> uris) {
                Logger.e( "onItemClicked: "+index );
                Intent intent=new Intent(mContext, SingePicShowActivity.class);
                Bundle b=new Bundle();
                b.putString(TagFinal.ALBUM_SINGE_URI,uris.get(index));
                intent.putExtras(b);
                mContext.startActivity(intent);
            }
        });

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

    public Pic pic;

    public void setPic(Pic pic) {
        this.pic = pic;
    }

    public interface Pic{

        void add(MultiPictureView add_mult);
    }

    private void showDialog(){

    }




}
