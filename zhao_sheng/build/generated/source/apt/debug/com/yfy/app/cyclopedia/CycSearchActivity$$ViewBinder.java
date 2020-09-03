// Generated code from Butter Knife. Do not modify!
package com.yfy.app.cyclopedia;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class CycSearchActivity$$ViewBinder<T extends com.yfy.app.cyclopedia.CycSearchActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296556, "field 'clear_et' and method 'setClear_et'");
    target.clear_et = finder.castView(view, 2131296556, "field 'clear_et'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setClear_et();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.clear_et = null;
  }
}
