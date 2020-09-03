// Generated code from Butter Knife. Do not modify!
package com.yfy.app.appointment;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class CalendarActivity$$ViewBinder<T extends com.yfy.app.appointment.CalendarActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296424, "method 'setPreMonth'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setPreMonth();
        }
      });
    view = finder.findRequiredView(source, 2131296423, "method 'setNextMonth'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setNextMonth();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

  }
}
