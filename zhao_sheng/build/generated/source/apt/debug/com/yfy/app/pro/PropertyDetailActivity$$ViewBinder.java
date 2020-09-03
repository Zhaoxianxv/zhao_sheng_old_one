// Generated code from Butter Knife. Do not modify!
package com.yfy.app.pro;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class PropertyDetailActivity$$ViewBinder<T extends com.yfy.app.pro.PropertyDetailActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297143, "field 'add_mult'");
    target.add_mult = finder.castView(view, 2131297143, "field 'add_mult'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.add_mult = null;
  }
}
