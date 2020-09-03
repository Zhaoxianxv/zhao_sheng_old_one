// Generated code from Butter Knife. Do not modify!
package com.yfy.app.goods;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class GoodsMainActivity$$ViewBinder<T extends com.yfy.app.goods.GoodsMainActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296530, "field 'count'");
    target.count = finder.castView(view, 2131296530, "field 'count'");
    view = finder.findRequiredView(source, 2131297692, "field 'count_two'");
    target.count_two = finder.castView(view, 2131297692, "field 'count_two'");
    view = finder.findRequiredView(source, 2131296533, "method 'setOneLayout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOneLayout();
        }
      });
    view = finder.findRequiredView(source, 2131296538, "method 'setTwoLayout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setTwoLayout();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.count = null;
    target.count_two = null;
  }
}
