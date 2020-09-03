// Generated code from Butter Knife. Do not modify!
package com.yfy.app.check;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class CheckGetStuToIllActivity$$ViewBinder<T extends com.yfy.app.check.CheckGetStuToIllActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297293, "field 'delete_button'");
    target.delete_button = finder.castView(view, 2131297293, "field 'delete_button'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.delete_button = null;
  }
}
