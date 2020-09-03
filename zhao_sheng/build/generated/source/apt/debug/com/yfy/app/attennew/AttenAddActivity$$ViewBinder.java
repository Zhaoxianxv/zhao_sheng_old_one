// Generated code from Butter Knife. Do not modify!
package com.yfy.app.attennew;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AttenAddActivity$$ViewBinder<T extends com.yfy.app.attennew.AttenAddActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296342, "field 'admin_name'");
    target.admin_name = finder.castView(view, 2131296342, "field 'admin_name'");
    view = finder.findRequiredView(source, 2131297029, "field 'leave_date' and method 'setChoiceTime'");
    target.leave_date = finder.castView(view, 2131297029, "field 'leave_date'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChoiceTime();
        }
      });
    view = finder.findRequiredView(source, 2131296344, "field 'atten_type'");
    target.atten_type = finder.castView(view, 2131296344, "field 'atten_type'");
    view = finder.findRequiredView(source, 2131297030, "field 'leave_duration'");
    target.leave_duration = finder.castView(view, 2131297030, "field 'leave_duration'");
    view = finder.findRequiredView(source, 2131297031, "field 'leave_reason'");
    target.leave_reason = finder.castView(view, 2131297031, "field 'leave_reason'");
    view = finder.findRequiredView(source, 2131296341, "field 'add_mult'");
    target.add_mult = finder.castView(view, 2131296341, "field 'add_mult'");
    view = finder.findRequiredView(source, 2131296343, "method 'setChoiceAdmin'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChoiceAdmin();
        }
      });
    view = finder.findRequiredView(source, 2131296345, "method 'setChoiceType'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChoiceType();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.admin_name = null;
    target.leave_date = null;
    target.atten_type = null;
    target.leave_duration = null;
    target.leave_reason = null;
    target.add_mult = null;
  }
}
