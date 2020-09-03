package com.yfy.base.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhao_sheng.R;
import com.yfy.base.Variables;
import com.yfy.base.activity.BaseActivity;
import com.yfy.db.UserPreferences;
import com.yfy.exafunction.FunctionProx;
import com.yfy.view.SQToolBar;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Daniel on 2016/3/8.
 * <p/>
 * 重写了一个抽象的 onCreateView(Bundle savedInstanceState);
 */
public abstract class BaseFragment extends Fragment {

    protected final static int FIRST_PAGE = 10;//常量：一页条数
    protected ProgressDialog dialog = null;
    protected View contentView = null;

    protected LayoutInflater inflater = null;
    protected ViewGroup container = null;
    protected BaseActivity mActivity;
    private SparseArray<View> viewMaps = new SparseArray<View>();
    protected FunctionProx functionProx;

    protected void initAddFunction(FunctionProx functionProx) {
    }


    @Nullable
    @Bind(R.id.sq_toolbar)
    protected SQToolBar toolbar;

    /**
     * 重写onCreate，从新定义Activity的初始时的生命周期
     * <p/>
     * 包括：初始化变量-> 初始化控件-> 加载数据
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.inflater = inflater;
        this.container = container;
        this.mActivity =(BaseActivity) getActivity();

        onCreateView(savedInstanceState);
        if (isLegal()) {
            functionProx.onCreateView(inflater, container, savedInstanceState);
        }

        if (Variables.admin==null){
            Variables.admin= UserPreferences.getInstance().getUserAdmin();
        }
        return contentView;
    }

    public abstract void onCreateView(Bundle savedInstanceState);

    /**
     * 显示一个ProgressDialog
     */
    protected void showProgressDialog(String title, String message) {
        if (dialog == null) {
            dialog = new ProgressDialog(getActivity());
        }
        dialog.setCancelable(false);
        if (title != null && !title.equals("")) {
            dialog.setTitle(title);
        }
        if (message != null && !message.equals("")) {
            dialog.setMessage(message);
        }
        dialog.show();
    }

    protected void showProgressDialog(String message) {
        showProgressDialog(null, message);
    }

    /**
     * 隐藏一个ProgressDialog
     */
    protected void dismissProgressDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void setContentView(@LayoutRes int layoutResID) {
        contentView = inflater.from(getActivity()).inflate(layoutResID, container, false);
        //初始化 ButterKnife
        ButterKnife.bind(this, contentView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (isLegal()) {
            functionProx.onDestroyView();
        }
        ButterKnife.unbind(this);

    }

    /**
     * 全局Toast
     */
    Toast toast;
    protected void toast(String text) {
        toastShow(text);
    }

    protected void toast(@StringRes int resId) {
        toastShow(resId);
    }


    protected int getFlag() {
        return this.hashCode();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        functionProx = new FunctionProx();
        initAddFunction(functionProx);
        if (isLegal()) {
            functionProx.onAttach(activity);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isLegal()) {
            functionProx.onCreate(savedInstanceState);
        }
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (isLegal()) {
            functionProx.onActivityCreate(savedInstanceState);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (isLegal()) {
            functionProx.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isLegal()) {
            functionProx.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (isLegal()) {
            functionProx.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (isLegal()) {
            functionProx.onStop();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isLegal()) {
            functionProx.onDestroy();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (isLegal()) {
            functionProx.onDetach();
        }
    }

    private boolean isLegal() {
        return functionProx != null && functionProx.isLeagal();
    }

    public void toastShow(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }

    public void toastShow(int textId) {
        Toast.makeText(getActivity(), textId, Toast.LENGTH_SHORT).show();
    }






    protected View setTextViewText(int resId, View container, String text) {
        View view = viewMaps.get(resId);
        if (view == null) {
            view = container.findViewById(resId);
            if (view != null) {
                viewMaps.put(resId, view);
            }
        }
        try {
            ((TextView) view).setText(text);
            if (view.getVisibility() != View.VISIBLE) {
                view.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
        }
        return view;
    }

    protected View setTextViewText(int resId, View container, int textId) {
        View view = viewMaps.get(resId);
        if (view == null) {
            view = container.findViewById(resId);
            if (view != null) {
                viewMaps.put(resId, view);
            }
        }
        try {
            ((TextView) view).setText(textId);
            if (view.getVisibility() != View.VISIBLE) {
                view.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
        }
        return view;
    }

    protected View setViewVisibility(int resId, View container, int visiblity) {
        View view = viewMaps.get(resId);
        if (view == null) {
            view = container.findViewById(resId);
            if (view != null) {
                viewMaps.put(resId, view);
                view.setVisibility(visiblity);
            }
        }
        return view;
    }

    protected String getStringFromBundle(Bundle b, String key) {
        if (b.containsKey(key)) {
            return b.getString(key);
        }
        return "";
    }

    protected int getIntFromBundle(Bundle b, String key) {
        if (b.containsKey(key)) {
            return b.getInt(key);
        }
        return 0;
    }

    protected boolean getBooleanFromBundle(Bundle b, String key) {
        if (b.containsKey(key)) {
            return b.getBoolean(key);
        }
        return false;
    }
}


