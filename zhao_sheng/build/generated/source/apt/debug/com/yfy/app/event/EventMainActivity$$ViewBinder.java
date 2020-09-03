// Generated code from Butter Knife. Do not modify!
package com.yfy.app.event;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class EventMainActivity$$ViewBinder<T extends com.yfy.app.event.EventMainActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297293, "field 'del_view' and method 'setDel_view'");
    target.del_view = finder.castView(view, 2131297293, "field 'del_view'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setDel_view();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.del_view = null;
  }
}
