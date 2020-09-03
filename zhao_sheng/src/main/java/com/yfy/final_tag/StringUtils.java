package com.yfy.final_tag;



import android.content.Context;
import android.media.ExifInterface;
import android.media.MediaPlayer;
import android.net.Uri;

import com.yfy.app.notice.bean.ChildBean;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class StringUtils {


	
	public static String subNameStr(List<ChildBean> list) {
		StringBuilder sb = new StringBuilder();
		for (ChildBean contactMember : list) {
			sb.append(contactMember.getUsername()).append(",");
		}
		String result = sb.toString();
		if (result.length() > 0) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}

	public static String subIdStr(List<ChildBean> list) {
		StringBuilder sb = new StringBuilder();
		for (ChildBean contactMember : list) {
			sb.append(contactMember.getUserid()).append(",");
		}
		String result = sb.toString();
		if (result.length() > 0) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}

	public static String subStr(List<String> list,String tag) {
		StringBuilder sb = new StringBuilder();
		for (String name : list) {
			sb.append(name).append(tag);
		}
		String result = sb.toString();
		if (result.length() > 0) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}


	public static List<String> getListToString(String content,String tag){
		List<String> list = Arrays.asList(content.split(tag));
		return list;
	}
	public static String byteArrayToString(byte[] encrypt ){
		StringBuilder sb = new StringBuilder();
		for (byte name : encrypt) {
			sb.append(name);
		}
		String result = sb.toString();
		if (StringJudge.isEmpty(result))result="";
		return result;
	}


	public static String arraysToStringOne(List<String> list,String tag) {
		StringBuilder sb = new StringBuilder();
		for (String name : list) {
			sb.append(name).append(tag);
		}
		String result = sb.toString();
		if (result.length() > 0) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}

	public static String arraysToString(List<String> list, String tag) {
		StringBuilder sb = new StringBuilder();
		for (String name : list) {
			sb.append(name).append(tag);
		}
		String result = sb.toString();
		if (result.length() > 0) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}




	public static String listToString(List<String> datas) {
		StringBuilder sb=new StringBuilder();
		for (String h:datas){
			sb.append(h).append(",");
		}
		if (sb.length()>2){
			return sb.substring(0,sb.length()-1);
		}
		return "";
	}


	public static String[] StringToArrays(String content,String tag){
		List<String> list = Arrays.asList(content.split(tag));

		return arraysToList(list);
	}

	public static String[] arraysToList(List<String> list){
		String[] se=new String[list.size()];
		return list.toArray(se);
	}

	public static byte[] StringToArraysbyte(String content ){

		return content.getBytes();
	}
	public static String string2Json(String name) {
		name.replace("\"\"\"", "\"\"");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			switch (c) {
                case '\"':
                    sb.append("\\\"");
                    break;
//				case '\\':
//					sb.append("\\\\");
//					break;
				default:
					sb.append(c);
					break;

			}
		}
		return sb.toString();
	}
	public static String upJson(String name) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			switch (c) {
				case '\"':
					sb.append("\\\"");
					break;
				case '\n':
					sb.append("\\n");
					break;
				default:
					sb.append(c);
					break;

			}
		}
		return sb.toString();
	}

	public static String getParamsXml(List<String> list) {
		StringBuilder sb = new StringBuilder();
		for (String s :list) {
			sb.append("<arr:string>")
					.append(s)
					.append("</arr:string>");
		}
		String resut = sb.toString();
		return resut;
	}


	/**
	 * @return float 保留两位小数
	 */
	public static String getTwoTofloat(float f){
		DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
		String p=decimalFormat.format(f);//format 返回的是字符串
		return p;
	}



	//未读(%1$d)
	public static String getTextJoint(String type,Object... args){
		return String.format(type,args);
	}




//    public static String string2Json(String s) {
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < s.length(); i++) {
//
//            char c = s.charAt(i);
//            switch (c) {
//                case '\"':
//                    sb.append("\\\"");
//                    break;
//                case '\\':
//                    sb.append("\\\\");
//                    break;
//                case '/':
//                    sb.append("\\/");
//                    break;
//                case '\b':
//                    sb.append("\\b");
//                    break;
//                case '\f':
//                    sb.append("\\f");
//                    break;
//                case '\n':
//                    sb.append("\\n");
//                    break;
//                case '\r':
//                    sb.append("\\r");
//                    break;
//                case '\t':
//                    sb.append("\\t");
//                    break;
//                default:
//                    sb.append(c);
//            }
//        }
//        return sb.toString();
//    }



	/**
	 * 将子节数转换为Kb
	 */
	public static String convertBytesToOther(long byteSize) {
		String result = null;
		float size;

		DecimalFormat decimalFormat1 = new DecimalFormat(".0");
		DecimalFormat decimalFormat2 = new DecimalFormat(".00");

		if (byteSize < 1024) {
			result = byteSize + "B";
		} else {
			size = byteSize / 1024;
			if (size < 1024) {
				result = decimalFormat1.format(size) + "KB";
			} else {
				size = size / 1024;
				if (size < 1024) {
					result = decimalFormat2.format(size) + "M";
				} else {
					size = size / 1024;
					if (size < 1024) {
						result = decimalFormat2.format(size) + "G";
					}
				}
			}
		}
		return result;
	}

	public static int getBitmapDegree(String path) {
		int degree = 0;
		try {
			// 从指定路径下读取图片，并获取其EXIF信息
			ExifInterface exifInterface = new ExifInterface(path);
			// 获取图片的旋转信息
			int orientation = exifInterface.getAttributeInt(
					ExifInterface.TAG_ORIENTATION,
					ExifInterface.ORIENTATION_NORMAL);
			switch (orientation) {
				case ExifInterface.ORIENTATION_ROTATE_90:
					degree = 90;
					break;
				case ExifInterface.ORIENTATION_ROTATE_180:
					degree = 180;
					break;
				case ExifInterface.ORIENTATION_ROTATE_270:
					degree = 270;
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return degree;
	}

	public static int getRecordDuration(Context context, String path) {
		MediaPlayer mp = MediaPlayer.create(context, Uri.parse(path));
		int duration = mp.getDuration();
		mp.release();
		mp = null;
		return duration;
	}

	public static String getFileName(String path) {

		File file = new File(path);
		if (file.exists()) {
			return file.getName();
		}
		return "";
	}

	public static String getFileName2(String pathandname) {

		int start = pathandname.lastIndexOf("/");
		int end = pathandname.lastIndexOf(".");
		if (start != -1 && end != -1) {
			return pathandname.substring(start + 1, end);
		} else {
			return null;
		}

	}
	
}
