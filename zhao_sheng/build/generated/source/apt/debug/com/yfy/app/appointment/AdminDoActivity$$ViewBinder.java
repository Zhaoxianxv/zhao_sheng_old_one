// Generated code from Butter Knife. Do not modify!
package com.yfy.app.appointment;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AdminDoActivity$$ViewBinder<T extends com.yfy.app.appointment.AdminDoActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296697, "field 'edit_content'");
    target.edit_content = finder.castView(view, 2131296697, "field 'edit_content'");
    view = finder.findRequiredView(source, 2131297100, "field 'add_mult'");
    target.add_mult = finder.castView(view, 2131297100, "field 'add_mult'");
    view = finder.findRequiredView(source, 2131296570, "field 'state_list'");
    target.state_list = finder.castView(view, 2131296570, "field 'state_list'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.edit_content = null;
    target.add_mult = null;
    target.state_list = null;
  }
}
