// Generated code from Butter Knife. Do not modify!
package com.yfy.app.appointment;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class OrderApplicationActivity$$ViewBinder<T extends com.yfy.app.appointment.OrderApplicationActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297218, "field 'chioce_room'");
    target.chioce_room = finder.castView(view, 2131297218, "field 'chioce_room'");
    view = finder.findRequiredView(source, 2131297199, "field 'chioce_date'");
    target.chioce_date = finder.castView(view, 2131297199, "field 'chioce_date'");
    view = finder.findRequiredView(source, 2131297203, "field 'chioce_time'");
    target.chioce_time = finder.castView(view, 2131297203, "field 'chioce_time'");
    view = finder.findRequiredView(source, 2131297210, "field 'chioce_grade' and method 'setChioceGrade'");
    target.chioce_grade = finder.castView(view, 2131297210, "field 'chioce_grade'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChioceGrade();
        }
      });
    view = finder.findRequiredView(source, 2131297207, "field 'box1_layout'");
    target.box1_layout = finder.castView(view, 2131297207, "field 'box1_layout'");
    view = finder.findRequiredView(source, 2131297208, "field 'box2_layout'");
    target.box2_layout = finder.castView(view, 2131297208, "field 'box2_layout'");
    view = finder.findRequiredView(source, 2131297211, "field 'is_logis' and method 'setBox1'");
    target.is_logis = finder.castView(view, 2131297211, "field 'is_logis'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setBox1();
        }
      });
    view = finder.findRequiredView(source, 2131297212, "field 'is_maintain' and method 'setBox2'");
    target.is_maintain = finder.castView(view, 2131297212, "field 'is_maintain'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setBox2();
        }
      });
    view = finder.findRequiredView(source, 2131297196, "field 'orderContent'");
    target.orderContent = finder.castView(view, 2131297196, "field 'orderContent'");
    view = finder.findRequiredView(source, 2131297194, "field 'deiver_edit'");
    target.deiver_edit = finder.castView(view, 2131297194, "field 'deiver_edit'");
    view = finder.findRequiredView(source, 2131297195, "field 'maintain_edit'");
    target.maintain_edit = finder.castView(view, 2131297195, "field 'maintain_edit'");
    view = finder.findRequiredView(source, 2131297223, "method 'setChioce'");
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

    target.chioce_room = null;
    target.chioce_date = null;
    target.chioce_time = null;
    target.chioce_grade = null;
    target.box1_layout = null;
    target.box2_layout = null;
    target.is_logis = null;
    target.is_maintain = null;
    target.orderContent = null;
    target.deiver_edit = null;
    target.maintain_edit = null;
  }
}
