/**
 * 
 */
package com.yfy.dialog;

import java.util.HashMap;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author yfy1
 * @version 1.0
 * @Desprition
 */
public abstract class AbstractDialog extends Dialog {

	protected HashMap<Integer, View> map = new HashMap<Integer, View>();
	protected OnCustomDialogListener listener = null;

	public AbstractDialog(Context context) {
		super(context);
	}

	public void showAtTop(int offY) {
		Window dialogWindow = getWindow();
		dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
		WindowManager.LayoutParams params = dialogWindow.getAttributes();
		params.y = offY;
		dialogWindow.setAttributes(params);
		show();
	}

	public void showAtBottom() {
		Window dialogWindow = getWindow();
		dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
		show();
	}

	public void showAtCenter() {
		Window dialogWindow = getWindow();
		dialogWindow.setGravity(Gravity.CENTER);
		show();
	}

	public View getView(int key) {
		return map.get(key);
	}

	@SuppressWarnings("unchecked")
	public <T> T getView(Class<T> clazz, int key) {
		return (T) map.get(key);
	}

	public void setOnCustomDialogListener(OnCustomDialogListener listener) {
		this.listener = listener;
	}

	public static abstract class OnCustomDialogListener {
		public abstract void onClick(View v, AbstractDialog myDialog);

		public void init(AbstractDialog myDialog) {

		}
	}

	protected android.view.View.OnClickListener onClickListener = new android.view.View.OnClickListener() {
		@Override
		public void onClick(View v) {
			if (listener != null) {
				listener.onClick(v, AbstractDialog.this);
			}
		}
	};

}
