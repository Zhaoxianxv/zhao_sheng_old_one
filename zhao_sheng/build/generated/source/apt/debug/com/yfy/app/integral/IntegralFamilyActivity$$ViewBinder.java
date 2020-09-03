// Generated code from Butter Knife. Do not modify!
package com.yfy.app.integral;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class IntegralFamilyActivity$$ViewBinder<T extends com.yfy.app.integral.IntegralFamilyActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296973, "field 'xListView'");
    target.xListView = finder.castView(view, 2131296973, "field 'xListView'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.xListView = null;
  }
}
