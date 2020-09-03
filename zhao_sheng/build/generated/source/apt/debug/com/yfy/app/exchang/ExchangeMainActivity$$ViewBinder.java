// Generated code from Butter Knife. Do not modify!
package com.yfy.app.exchang;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ExchangeMainActivity$$ViewBinder<T extends com.yfy.app.exchang.ExchangeMainActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296770, "field 'my_timetable' and method 'setSchool'");
    target.my_timetable = finder.castView(view, 2131296770, "field 'my_timetable'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setSchool(finder.<com.yfy.view.button.BottomItem>castParam(p0, "doClick", 0, "setSchool", 0));
        }
      });
    view = finder.findRequiredView(source, 2131296771, "field 'my_exchange' and method 'setClass'");
    target.my_exchange = finder.castView(view, 2131296771, "field 'my_exchange'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setClass(finder.<com.yfy.view.button.BottomItem>castParam(p0, "doClick", 0, "setClass", 0));
        }
      });
    view = finder.findRequiredView(source, 2131296772, "field 'exchange_detail' and method 'setWork'");
    target.exchange_detail = finder.castView(view, 2131296772, "field 'exchange_detail'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setWork(finder.<com.yfy.view.button.BottomItem>castParam(p0, "doClick", 0, "setWork", 0));
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.my_timetable = null;
    target.my_exchange = null;
    target.exchange_detail = null;
  }
}
