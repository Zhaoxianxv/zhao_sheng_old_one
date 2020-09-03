// Generated code from Butter Knife. Do not modify!
package com.yfy.app.goods;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class GoodsIndexctivity$$ViewBinder<T extends com.yfy.app.goods.GoodsIndexctivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297170, "field 'one_tag'");
    target.one_tag = finder.castView(view, 2131297170, "field 'one_tag'");
    view = finder.findRequiredView(source, 2131297166, "field 'five_tag'");
    target.five_tag = finder.castView(view, 2131297166, "field 'five_tag'");
    view = finder.findRequiredView(source, 2131297173, "field 'six_tag'");
    target.six_tag = finder.castView(view, 2131297173, "field 'six_tag'");
    view = finder.findRequiredView(source, 2131297175, "field 'ten_tag'");
    target.ten_tag = finder.castView(view, 2131297175, "field 'ten_tag'");
    view = finder.findRequiredView(source, 2131297177, "method 'setTwo'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setTwo();
        }
      });
    view = finder.findRequiredView(source, 2131297169, "method 'setOne'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOne();
        }
      });
    view = finder.findRequiredView(source, 2131297176, "method 'setThree'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setThree();
        }
      });
    view = finder.findRequiredView(source, 2131297172, "method 'setSix'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setSix();
        }
      });
    view = finder.findRequiredView(source, 2131297167, "method 'setFour'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setFour();
        }
      });
    view = finder.findRequiredView(source, 2131297165, "method 'setFive'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setFive();
        }
      });
    view = finder.findRequiredView(source, 2131297164, "method 'setEight'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setEight();
        }
      });
    view = finder.findRequiredView(source, 2131297168, "method 'setNine'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setNine();
        }
      });
    view = finder.findRequiredView(source, 2131297174, "method 'setTen'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setTen();
        }
      });
    view = finder.findRequiredView(source, 2131297178, "method 'setTag'");
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

    target.one_tag = null;
    target.five_tag = null;
    target.six_tag = null;
    target.ten_tag = null;
  }
}
