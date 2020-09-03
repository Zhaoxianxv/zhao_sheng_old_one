// Generated code from Butter Knife. Do not modify!
package com.yfy.app.seal;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SealEditResetApplyActivity$$ViewBinder<T extends com.yfy.app.seal.SealEditResetApplyActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297313, "field 'button' and method 'setTag'");
    target.button = finder.castView(view, 2131297313, "field 'button'");
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

    target.button = null;
  }
}
