// Generated code from Butter Knife. Do not modify!
package com.yfy.app.delay_service;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DelayGetAdminToClassEventDetailActivity$$ViewBinder<T extends com.yfy.app.delay_service.DelayGetAdminToClassEventDetailActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297284, "field 'button_left' and method 'setButtonLeft'");
    target.button_left = finder.castView(view, 2131297284, "field 'button_left'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setButtonLeft();
        }
      });
    view = finder.findRequiredView(source, 2131297286, "field 'button_right' and method 'setButtonRight'");
    target.button_right = finder.castView(view, 2131297286, "field 'button_right'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setButtonRight();
        }
      });
    view = finder.findRequiredView(source, 2131297317, "field 'top_layout'");
    target.top_layout = view;
    view = finder.findRequiredView(source, 2131297320, "field 'parent_name'");
    target.parent_name = finder.castView(view, 2131297320, "field 'parent_name'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.button_left = null;
    target.button_right = null;
    target.top_layout = null;
    target.parent_name = null;
  }
}
