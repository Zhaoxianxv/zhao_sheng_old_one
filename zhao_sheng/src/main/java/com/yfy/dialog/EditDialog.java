/**
 * 
 */
package com.yfy.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zhao_sheng.R;
import com.yfy.dialog.AbstractDialog.OnCustomDialogListener;


/**
 * @author yfy1
 * @version 1.0
 * @Desprition
 */
public class EditDialog {

	private Context mContext;

	private int b3_gray;
	private ColorStateList colorStateList;

	private MyDialog dialog;
	private EditText popu_edit;
	private TextView popu_ok;

	public EditDialog(Context context) {
		mContext = context;
		dialog = new MyDialog(context, R.layout.dialog_edittext_popu,
				new int[] { R.id.popu_cancel, R.id.popu_title, R.id.popu_ok,
						R.id.popu_edit }, new int[] { R.id.popu_cancel,
						R.id.popu_ok });
		dialog.setOnCustomDialogListener(onCustomDialogListener);
		dialog.setOnDismissListener(onDismissListener);
	}

	private OnDismissListener onDismissListener = new OnDismissListener() {

		@Override
		public void onDismiss(DialogInterface dialog) {
			popu_edit.getText().clear();
		}
	};

	private OnCustomDialogListener onCustomDialogListener = new OnCustomDialogListener() {

		@Override
		public void onClick(View v, AbstractDialog dialog) {
			switch (v.getId()) {
			case R.id.popu_cancel:
				dialog.dismiss();
				break;
			case R.id.popu_ok:
				if (listener != null) {
					listener.OnClick(v);
				}
				break;
			}
		}

		@SuppressWarnings("ResourceType")
		@Override
		public void init(AbstractDialog dialog) {

			b3_gray = mContext.getResources().getColor(R.color.b3_gray);
			try {
				XmlResourceParser xrp = mContext.getResources().getXml(R.color.selector_text_click4);
				colorStateList = ColorStateList.createFromXml(
						mContext.getResources(), xrp);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			popu_edit = dialog.getView(EditText.class, R.id.popu_edit);
			popu_ok = dialog.getView(TextView.class, R.id.popu_ok);
			popu_edit.addTextChangedListener(watcher);
		}
	};

	public void showAtBottom() {
		dialog.showAtBottom();
	}

	public void dismiss() {
		dialog.dismiss();
	}

	private OnEditDialogListener listener;

	public void setOnEditDialogListener(OnEditDialogListener listener) {
		this.listener = listener;
	}

	public static interface OnEditDialogListener {
		void OnClick(View v);
	}

	public String getEditContent() {
		return popu_edit.getText().toString();
	}

	private TextWatcher watcher = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			if (TextUtils.isEmpty(s)) {
				popu_ok.setTextColor(b3_gray);
				popu_ok.setClickable(false);
			} else {
				popu_ok.setTextColor(colorStateList);
				popu_ok.setClickable(true);
			}
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {

		}

		@Override
		public void afterTextChanged(Editable s) {

		}
	};

}
