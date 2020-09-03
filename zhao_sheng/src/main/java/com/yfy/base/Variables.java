/**
 * 
 */
package com.yfy.base;

import android.content.Context;
import com.yfy.app.login.bean.UserAdmin;
import com.yfy.db.User;


/**
 * @author yfy
 * @date 2016-3-31
 * @version 1.0
 * @description Variables
 */
public class Variables {

	/*
	 * wcf json字符串
	 */
	public static String wcfInfo = "";
	/*
	 * 用户信息
	 */
	public static UserAdmin admin=null;
	public static User user = null;
	public static String isBoss = null;




	public static void clearAll(Context context) {
		user = null;
		isBoss = null;


	}





	public static String year="";
	public static String type="";
	public static String type_id="";
}

