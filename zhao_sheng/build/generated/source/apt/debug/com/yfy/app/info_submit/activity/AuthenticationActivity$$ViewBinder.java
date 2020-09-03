// Generated code from Butter Knife. Do not modify!
package com.yfy.app.info_submit.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AuthenticationActivity$$ViewBinder<T extends com.yfy.app.info_submit.activity.AuthenticationActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296394, "field 'baobao_et'");
    target.baobao_et = finder.castView(view, 2131296394, "field 'baobao_et'");
    view = finder.findRequiredView(source, 2131297115, "field 'mishi_et'");
    target.mishi_et = finder.castView(view, 2131297115, "field 'mishi_et'");
    view = finder.findRequiredView(source, 2131297246, "method 'setWeb'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setWeb();
        }
      });
    view = finder.findRequiredView(source, 2131296346, "method 'setSubmit'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setSubmit();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.baobao_et = null;
    target.mishi_et = null;
  }
}
