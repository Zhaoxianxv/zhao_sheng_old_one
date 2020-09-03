// Generated code from Butter Knife. Do not modify!
package com.yfy.app.appointment;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class OrderAddChangeActivity$$ViewBinder<T extends com.yfy.app.appointment.OrderAddChangeActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297197, "field 'apply_address' and method 'setAddress'");
    target.apply_address = finder.castView(view, 2131297197, "field 'apply_address'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setAddress();
        }
      });
    view = finder.findRequiredView(source, 2131297200, "field 'apply_date' and method 'settvCurrentMonth'");
    target.apply_date = finder.castView(view, 2131297200, "field 'apply_date'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.settvCurrentMonth();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.apply_address = null;
    target.apply_date = null;
  }
}
