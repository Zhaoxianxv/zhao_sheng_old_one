// Generated code from Butter Knife. Do not modify!
package com.yfy.app.goods;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class GoodsAdminDetailActivity$$ViewBinder<T extends com.yfy.app.goods.GoodsAdminDetailActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296851, "field 'bottom' and method 'setAdmin'");
    target.bottom = finder.castView(view, 2131296851, "field 'bottom'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setAdmin();
        }
      });
    view = finder.findRequiredView(source, 2131296852, "field 'layout'");
    target.layout = finder.castView(view, 2131296852, "field 'layout'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.bottom = null;
    target.layout = null;
  }
}
