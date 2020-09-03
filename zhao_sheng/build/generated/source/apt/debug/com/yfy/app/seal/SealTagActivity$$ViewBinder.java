// Generated code from Butter Knife. Do not modify!
package com.yfy.app.seal;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SealTagActivity$$ViewBinder<T extends com.yfy.app.seal.SealTagActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297405, "field 'top_txt' and method 'setTop_txt'");
    target.top_txt = finder.castView(view, 2131297405, "field 'top_txt'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setTop_txt();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.top_txt = null;
  }
}
