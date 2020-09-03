// Generated code from Butter Knife. Do not modify!
package com.yfy.app.integral;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class IntegralEditActivity$$ViewBinder<T extends com.yfy.app.integral.IntegralEditActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296969, "field 'edit'");
    target.edit = finder.castView(view, 2131296969, "field 'edit'");
    view = finder.findRequiredView(source, 2131296968, "field 'list'");
    target.list = finder.castView(view, 2131296968, "field 'list'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.edit = null;
    target.list = null;
  }
}
