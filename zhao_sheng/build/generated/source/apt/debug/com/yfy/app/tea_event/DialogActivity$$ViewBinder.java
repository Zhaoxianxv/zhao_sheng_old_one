// Generated code from Butter Knife. Do not modify!
package com.yfy.app.tea_event;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DialogActivity$$ViewBinder<T extends com.yfy.app.tea_event.DialogActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296640, "field 'ok' and method 'setOk'");
    target.ok = finder.castView(view, 2131296640, "field 'ok'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOk();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.ok = null;
  }
}
