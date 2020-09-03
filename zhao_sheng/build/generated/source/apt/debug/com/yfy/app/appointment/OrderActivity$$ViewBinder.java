// Generated code from Butter Knife. Do not modify!
package com.yfy.app.appointment;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class OrderActivity$$ViewBinder<T extends com.yfy.app.appointment.OrderActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297209, "field 'count'");
    target.count = finder.castView(view, 2131297209, "field 'count'");
    view = finder.findRequiredView(source, 2131297186, "field 'admin_layout' and method 'setAudit'");
    target.admin_layout = finder.castView(view, 2131297186, "field 'admin_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setAudit();
        }
      });
    view = finder.findRequiredView(source, 2131297215, "field 'maintain_layout' and method 'setMaintainDo'");
    target.maintain_layout = finder.castView(view, 2131297215, "field 'maintain_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setMaintainDo();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.count = null;
    target.admin_layout = null;
    target.maintain_layout = null;
  }
}
