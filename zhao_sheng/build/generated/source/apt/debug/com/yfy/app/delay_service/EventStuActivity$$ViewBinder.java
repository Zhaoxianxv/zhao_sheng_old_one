// Generated code from Butter Knife. Do not modify!
package com.yfy.app.delay_service;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class EventStuActivity$$ViewBinder<T extends com.yfy.app.delay_service.EventStuActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297284, "field 'bottom_b' and method 'setbutton'");
    target.bottom_b = finder.castView(view, 2131297284, "field 'bottom_b'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setbutton();
        }
      });
    view = finder.findRequiredView(source, 2131297283, "field 'bottom_c' and method 'setB'");
    target.bottom_c = finder.castView(view, 2131297283, "field 'bottom_c'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setB();
        }
      });
    view = finder.findRequiredView(source, 2131297287, "field 'button_layout'");
    target.button_layout = finder.castView(view, 2131297287, "field 'button_layout'");
    view = finder.findRequiredView(source, 2131297654, "field 'button_one' and method 'setOne'");
    target.button_one = finder.castView(view, 2131297654, "field 'button_one'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOne();
        }
      });
    view = finder.findRequiredView(source, 2131297656, "field 'button_two' and method 'setTop_two'");
    target.button_two = finder.castView(view, 2131297656, "field 'button_two'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setTop_two();
        }
      });
    view = finder.findRequiredView(source, 2131297655, "field 'button_three' and method 'setThree'");
    target.button_three = finder.castView(view, 2131297655, "field 'button_three'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setThree();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.bottom_b = null;
    target.bottom_c = null;
    target.button_layout = null;
    target.button_one = null;
    target.button_two = null;
    target.button_three = null;
  }
}
