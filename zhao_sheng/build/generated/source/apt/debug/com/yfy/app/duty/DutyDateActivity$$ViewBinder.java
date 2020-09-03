// Generated code from Butter Knife. Do not modify!
package com.yfy.app.duty;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DutyDateActivity$$ViewBinder<T extends com.yfy.app.duty.DutyDateActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297658, "field 'top_layout'");
    target.top_layout = view;
    view = finder.findRequiredView(source, 2131297289, "field 'parent_name'");
    target.parent_name = finder.castView(view, 2131297289, "field 'parent_name'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.top_layout = null;
    target.parent_name = null;
  }
}
