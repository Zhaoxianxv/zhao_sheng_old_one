// Generated code from Butter Knife. Do not modify!
package com.yfy.app.delay_service;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DelayAbsClassDetailActivity$$ViewBinder<T extends com.yfy.app.delay_service.DelayAbsClassDetailActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297286, "field 'button_two' and method 'setTea'");
    target.button_two = finder.castView(view, 2131297286, "field 'button_two'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setTea();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.button_two = null;
  }
}
