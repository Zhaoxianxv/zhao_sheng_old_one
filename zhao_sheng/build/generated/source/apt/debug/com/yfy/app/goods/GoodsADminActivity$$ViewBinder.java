// Generated code from Butter Knife. Do not modify!
package com.yfy.app.goods;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class GoodsADminActivity$$ViewBinder<T extends com.yfy.app.goods.GoodsADminActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297289, "field 'topTv' and method 'setTag'");
    target.topTv = finder.castView(view, 2131297289, "field 'topTv'");
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

    target.topTv = null;
  }
}
