// Generated code from Butter Knife. Do not modify!
package com.yfy.app.duty;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DutyMainActivity$$ViewBinder<T extends com.yfy.app.duty.DutyMainActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296674, "field 'chioce_time' and method 'setChoice'");
    target.chioce_time = finder.castView(view, 2131296674, "field 'chioce_time'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChoice();
        }
      });
    view = finder.findRequiredView(source, 2131296687, "field 'one_duty' and method 'setOne_duty'");
    target.one_duty = finder.castView(view, 2131296687, "field 'one_duty'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOne_duty();
        }
      });
    view = finder.findRequiredView(source, 2131296688, "field 'two_duty' and method 'setTwo_duty'");
    target.two_duty = finder.castView(view, 2131296688, "field 'two_duty'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setTwo_duty();
        }
      });
    view = finder.findRequiredView(source, 2131297658, "field 'top_layout'");
    target.top_layout = view;
    view = finder.findRequiredView(source, 2131297319, "field 'parent_name'");
    target.parent_name = finder.castView(view, 2131297319, "field 'parent_name'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.chioce_time = null;
    target.one_duty = null;
    target.two_duty = null;
    target.top_layout = null;
    target.parent_name = null;
  }
}
