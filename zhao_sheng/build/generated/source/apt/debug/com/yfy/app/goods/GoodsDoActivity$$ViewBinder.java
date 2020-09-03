// Generated code from Butter Knife. Do not modify!
package com.yfy.app.goods;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class GoodsDoActivity$$ViewBinder<T extends com.yfy.app.goods.GoodsDoActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296854, "field 'edit'");
    target.edit = finder.castView(view, 2131296854, "field 'edit'");
    view = finder.findRequiredView(source, 2131296869, "field 'add_mult'");
    target.add_mult = finder.castView(view, 2131296869, "field 'add_mult'");
    view = finder.findRequiredView(source, 2131296871, "field 'one'");
    target.one = finder.castView(view, 2131296871, "field 'one'");
    view = finder.findRequiredView(source, 2131296876, "field 'two'");
    target.two = finder.castView(view, 2131296876, "field 'two'");
    view = finder.findRequiredView(source, 2131296877, "field 'two_'");
    target.two_ = finder.castView(view, 2131296877, "field 'two_'");
    view = finder.findRequiredView(source, 2131296873, "field 'three'");
    target.three = finder.castView(view, 2131296873, "field 'three'");
    view = finder.findRequiredView(source, 2131296868, "field 'four'");
    target.four = finder.castView(view, 2131296868, "field 'four'");
    view = finder.findRequiredView(source, 2131296866, "field 'fiv'");
    target.fiv = finder.castView(view, 2131296866, "field 'fiv'");
    view = finder.findRequiredView(source, 2131296870, "field 'one_layout' and method 'setOne'");
    target.one_layout = finder.castView(view, 2131296870, "field 'one_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOne();
        }
      });
    view = finder.findRequiredView(source, 2131296874, "field 'two_layout' and method 'setTwo_layout'");
    target.two_layout = finder.castView(view, 2131296874, "field 'two_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setTwo_layout();
        }
      });
    view = finder.findRequiredView(source, 2131296875, "field 'twoo_layout' and method 'setTw_layout'");
    target.twoo_layout = finder.castView(view, 2131296875, "field 'twoo_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setTw_layout();
        }
      });
    view = finder.findRequiredView(source, 2131296872, "field 'three_layout' and method 'setthree'");
    target.three_layout = finder.castView(view, 2131296872, "field 'three_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setthree();
        }
      });
    view = finder.findRequiredView(source, 2131296867, "field 'four_layout' and method 'setfuor'");
    target.four_layout = finder.castView(view, 2131296867, "field 'four_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setfuor();
        }
      });
    view = finder.findRequiredView(source, 2131296865, "field 'fiv_layout' and method 'setFiv'");
    target.fiv_layout = finder.castView(view, 2131296865, "field 'fiv_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setFiv();
        }
      });
    view = finder.findRequiredView(source, 2131296843, "field 'box_layout' and method 'setChange'");
    target.box_layout = finder.castView(view, 2131296843, "field 'box_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChange();
        }
      });
    view = finder.findRequiredView(source, 2131296844, "field 'box_icon'");
    target.box_icon = finder.castView(view, 2131296844, "field 'box_icon'");
    view = finder.findRequiredView(source, 2131296845, "field 'box_name'");
    target.box_name = finder.castView(view, 2131296845, "field 'box_name'");
    view = finder.findRequiredView(source, 2131296856, "method 'setChioce'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChioce();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.edit = null;
    target.add_mult = null;
    target.one = null;
    target.two = null;
    target.two_ = null;
    target.three = null;
    target.four = null;
    target.fiv = null;
    target.one_layout = null;
    target.two_layout = null;
    target.twoo_layout = null;
    target.three_layout = null;
    target.four_layout = null;
    target.fiv_layout = null;
    target.box_layout = null;
    target.box_icon = null;
    target.box_name = null;
  }
}
