// Generated code from Butter Knife. Do not modify!
package com.yfy.app.goods;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class GoodsAddGoodsActivity$$ViewBinder<T extends com.yfy.app.goods.GoodsAddGoodsActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296892, "field 'type_name' and method 'setChioceType'");
    target.type_name = finder.castView(view, 2131296892, "field 'type_name'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChioceType();
        }
      });
    view = finder.findRequiredView(source, 2131296879, "field 'check_text'");
    target.check_text = finder.castView(view, 2131296879, "field 'check_text'");
    view = finder.findRequiredView(source, 2131296878, "field 'check_icon' and method 'setCheckIcon'");
    target.check_icon = finder.castView(view, 2131296878, "field 'check_icon'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setCheckIcon();
        }
      });
    view = finder.findRequiredView(source, 2131296886, "field 'goods_name'");
    target.goods_name = finder.castView(view, 2131296886, "field 'goods_name'");
    view = finder.findRequiredView(source, 2131296889, "field 'goods_search'");
    target.goods_search = finder.castView(view, 2131296889, "field 'goods_search'");
    view = finder.findRequiredView(source, 2131296894, "field 'goods_unit'");
    target.goods_unit = finder.castView(view, 2131296894, "field 'goods_unit'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.type_name = null;
    target.check_text = null;
    target.check_icon = null;
    target.goods_name = null;
    target.goods_search = null;
    target.goods_unit = null;
  }
}
