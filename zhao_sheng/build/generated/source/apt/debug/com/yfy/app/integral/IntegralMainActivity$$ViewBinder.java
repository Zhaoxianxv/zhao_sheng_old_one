// Generated code from Butter Knife. Do not modify!
package com.yfy.app.integral;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class IntegralMainActivity$$ViewBinder<T extends com.yfy.app.integral.IntegralMainActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296986, "field 'list'");
    target.list = finder.castView(view, 2131296986, "field 'list'");
    view = finder.findRequiredView(source, 2131296993, "method 'setBack'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setBack();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.list = null;
  }
}
