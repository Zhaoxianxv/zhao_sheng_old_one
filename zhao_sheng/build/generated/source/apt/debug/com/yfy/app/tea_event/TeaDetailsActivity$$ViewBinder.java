// Generated code from Butter Knife. Do not modify!
package com.yfy.app.tea_event;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class TeaDetailsActivity$$ViewBinder<T extends com.yfy.app.tea_event.TeaDetailsActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297293, "field 'del' and method 'setAdd'");
    target.del = finder.castView(view, 2131297293, "field 'del'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setAdd();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.del = null;
  }
}
