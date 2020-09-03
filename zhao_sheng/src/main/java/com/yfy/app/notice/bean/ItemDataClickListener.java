package com.yfy.app.notice.bean;


import com.yfy.app.notice.bean.ChildBean;

/**
 * @Author Zheng Haibo
 * @PersonalWebsite http://www.mobctrl.net
 * @Description
 */
public interface ItemDataClickListener {

	public void onExpandChildren(ChildBean itemData);

	public void onHideChildren(ChildBean itemData);

}
