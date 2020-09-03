// Generated code from Butter Knife. Do not modify!
package com.yfy.app.duty;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DutyChangeActivity$$ViewBinder<T extends com.yfy.app.duty.DutyChangeActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296661, "field 'parent' and method 'setParent'");
    target.parent = finder.castView(view, 2131296661, "field 'parent'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setParent();
        }
      });
    view = finder.findRequiredView(source, 2131296664, "field 'duty_type' and method 'setDutyType'");
    target.duty_type = finder.castView(view, 2131296664, "field 'duty_type'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setDutyType();
        }
      });
    view = finder.findRequiredView(source, 2131296660, "field 'edit_content'");
    target.edit_content = finder.castView(view, 2131296660, "field 'edit_content'");
    view = finder.findRequiredView(source, 2131296662, "field 'flow_layout'");
    target.flow_layout = finder.castView(view, 2131296662, "field 'flow_layout'");
    view = finder.findRequiredView(source, 2131296663, "method 'setChoiceTime'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChoiceTime();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.parent = null;
    target.duty_type = null;
    target.edit_content = null;
    target.flow_layout = null;
  }
}
