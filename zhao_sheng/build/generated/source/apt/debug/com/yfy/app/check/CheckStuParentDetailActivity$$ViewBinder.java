// Generated code from Butter Knife. Do not modify!
package com.yfy.app.check;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class CheckStuParentDetailActivity$$ViewBinder<T extends com.yfy.app.check.CheckStuParentDetailActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297313, "field 'del_button' and method 'setDel'");
    target.del_button = finder.castView(view, 2131297313, "field 'del_button'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setDel();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.del_button = null;
  }
}
