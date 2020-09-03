package com.yfy.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.zhao_sheng.R;


/**
 * ImageView创建工厂
 */
public class ViewFactory {

	/**
	 * 获取ImageView视图的同时加载显示url
	 * @return
	 */
	private static RequestOptions options=new RequestOptions().centerCrop().placeholder(R.drawable.cyc_logo);


	public static ImageView getImageView(Context context, String url) {
		ImageView imageView = (ImageView)LayoutInflater.from(context).inflate(
				R.layout.view_banner, null);
		Glide.with(context).load(url)
				.apply(options)
				.into(imageView);
		return imageView;
	}
	public static ImageView getImageViewToR(Context context,int id) {
		ImageView imageView = (ImageView)LayoutInflater.from(context).inflate(
				R.layout.view_banner, null);
		Glide.with(context).load(id)
				.apply(options)
				.into(imageView);
		return imageView;
	}
}
