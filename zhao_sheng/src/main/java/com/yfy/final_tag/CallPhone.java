package com.yfy.final_tag;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import com.yfy.base.App;
import com.yfy.jpush.Logger;

import java.io.File;

public class CallPhone {

//    打电话（权限）危险权限
    public static void callDirectly(Context mContext,String mobile){
        Intent intent = new Intent();
        intent.setAction("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:" + mobile));
        mContext.startActivity(intent);
    }

    public static void rating(Activity activity) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=" + AppLess.$appname()));
            activity.startActivity(intent);
        } catch (Throwable t) {
            //toast("您的手机上没有安装Android应用市场");
        }
    }
    public static Intent getWordFileIntent(String param) {
        Intent intent = null;
        try {
            intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Uri uri;
            Logger.e("zxx","   "+param);
            File file=new File(param);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                uri= FileProvider.getUriForFile(App.getApp().getApplicationContext(), TagFinal.AUTHORITY, file);
            } else {
                uri = Uri.fromFile(file);
            }
            intent.setDataAndType(uri, "application/msword");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return intent;
    }

}
