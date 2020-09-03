// Generated code from Butter Knife. Do not modify!
package com.yfy.app.goods;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class GoodsSchoolAddActivity$$ViewBinder<T extends com.yfy.app.goods.GoodsSchoolAddActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296850, "field 'type' and method 'setChioceType'");
    target.type = finder.castView(view, 2131296850, "field 'type'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChioceType();
        }
      });
    view = finder.findRequiredView(source, 2131296887, "field 'add_value'");
    target.add_value = finder.castView(view, 2131296887, "field 'add_value'");
    view = finder.findRequiredView(source, 2131296849, "field 'num_edit'");
    target.num_edit = finder.castView(view, 2131296849, "field 'num_edit'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.type = null;
    target.add_value = null;
    target.num_edit = null;
  }
}
