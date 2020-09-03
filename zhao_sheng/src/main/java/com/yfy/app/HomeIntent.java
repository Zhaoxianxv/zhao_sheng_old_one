package com.yfy.app;

import android.content.Intent;

/**
 * Created by yfy1 on 2016/12/29.
 */

public class HomeIntent {
    private String name;
    private int drawableId;
    private int pushCount;
    private Intent intent;
    private boolean isChoice=true;//是否跳转页面(包含登录界面)
    private boolean isBase=false;//图标是否高亮
    private String admin="";//是否加载权限
    private String index;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    /**
     * @param name
     * @param drawableId
     */
    public HomeIntent(String name, int drawableId,Intent intent) {
        super();
        this.name = name;
        this.intent = intent;
        this.drawableId = drawableId;
    }

    /**
     * @param name
     * @param drawableId
     * @param pushCount
     */
    public HomeIntent(String name, int drawableId, Intent intent,int pushCount) {
        super();
        this.name = name;
        this.drawableId = drawableId;
        this.pushCount = pushCount;
        this.intent = intent;
    }

    public boolean isBase() {
        return isBase;
    }

    public void setBase(boolean base) {
        isBase = base;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public boolean isChoice() {
        return isChoice;
    }

    public void setChoice(boolean choice) {
        isChoice = choice;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public int getPushCount() {
        return pushCount;
    }

    public void setPushCount(int pushCount) {
        this.pushCount = pushCount;
    }
}
