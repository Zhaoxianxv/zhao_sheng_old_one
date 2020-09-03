package com.yfy.base;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import com.yfy.db.GreenDaoManager;
import com.yfy.final_tag.TagFinal;
import com.yfy.json.JsonParser;
import com.yfy.net.SoapAccessor;
import com.yfy.net.SoapAccessor.WcfConfiguration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class InitUtils {
	
	private final static String UPDATA_HEAD_PIC="update_head_pic";

	public static void init(Activity activity) {
		initWcfJson(activity);
		initWcf();
	}

	public static void initWcfJson(Activity activity) {
		if (!TextUtils.isEmpty(Variables.wcfInfo)) {
			return;
		}
		BufferedReader reader = null;
		try {
			StringBuilder sb = new StringBuilder();
			InputStream inputStream = activity.getAssets().open(TagFinal.WCF_TXT);

			reader = new BufferedReader(new InputStreamReader(inputStream));
			String s = null;
			while ((s = reader.readLine()) != null) {
				sb.append(s);
			}
			Variables.wcfInfo = sb.toString();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void initWcf() {
		SoapAccessor.getInstance().unInit();
		WcfConfiguration configuration = new WcfConfiguration(
				TagFinal.NAMESPACE,TagFinal.CHENGDU_SHIYAN, TagFinal.NET_SOAP_ACTION,
				TagFinal.TIME_OUT, Variables.wcfInfo);
		SoapAccessor.getInstance().init(configuration);
	}


}
