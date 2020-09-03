/**
 * 
 */
package com.yfy.tool_textwatcher;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * @version 1.0
 * @Desprition
 */
public abstract class EmptyTextWatcher implements TextWatcher {

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {

	}

	@Override
	public void afterTextChanged(Editable s) {

	}

}
