// Generated code from Butter Knife. Do not modify!
package com.yfy.app.check;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class CheckTjActivity$$ViewBinder<T extends com.yfy.app.check.CheckTjActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296484, "field 'flowLayout'");
    target.flowLayout = finder.castView(view, 2131296484, "field 'flowLayout'");
    view = finder.findRequiredView(source, 2131296485, "field 'name' and method 'setTag'");
    target.name = finder.castView(view, 2131296485, "field 'name'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setTag();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.flowLayout = null;
    target.name = null;
  }
}
