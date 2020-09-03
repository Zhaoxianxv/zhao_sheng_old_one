// Generated code from Butter Knife. Do not modify!
package com.yfy.app.delay_service;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DelayServiceMasterMainActivity$$ViewBinder<T extends com.yfy.app.delay_service.DelayServiceMasterMainActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297284, "field 'week_num' and method 'setDateBean'");
    target.week_num = finder.castView(view, 2131297284, "field 'week_num'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setDateBean();
        }
      });
    view = finder.findRequiredView(source, 2131297286, "field 'date_button' and method 'setDelayDetail'");
    target.date_button = finder.castView(view, 2131297286, "field 'date_button'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setDelayDetail();
        }
      });
    view = finder.findRequiredView(source, 2131297317, "field 'top_layout'");
    target.top_layout = view;
    view = finder.findRequiredView(source, 2131297320, "field 'parent_name'");
    target.parent_name = finder.castView(view, 2131297320, "field 'parent_name'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.week_num = null;
    target.date_button = null;
    target.top_layout = null;
    target.parent_name = null;
  }
}
