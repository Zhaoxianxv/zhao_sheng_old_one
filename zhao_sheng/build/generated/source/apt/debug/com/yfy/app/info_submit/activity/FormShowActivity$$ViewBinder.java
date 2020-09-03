// Generated code from Butter Knife. Do not modify!
package com.yfy.app.info_submit.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class FormShowActivity$$ViewBinder<T extends com.yfy.app.info_submit.activity.FormShowActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297555, "method 'setSub'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setSub();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

  }
}
