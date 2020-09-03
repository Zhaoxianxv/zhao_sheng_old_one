// Generated code from Butter Knife. Do not modify!
package com.yfy.app.goods;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class GoodsTagActivity$$ViewBinder<T extends com.yfy.app.goods.GoodsTagActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296502, "field 'edit'");
    target.edit = finder.castView(view, 2131296502, "field 'edit'");
    view = finder.findRequiredView(source, 2131296891, "field 'bottom' and method 'setChoice'");
    target.bottom = finder.castView(view, 2131296891, "field 'bottom'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChoice();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.edit = null;
    target.bottom = null;
  }
}
