// Generated code from Butter Knife. Do not modify!
package com.yfy.app.delay_service;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class EventDetailActivity$$ViewBinder<T extends com.yfy.app.delay_service.EventDetailActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296733, "field 'head'");
    target.head = finder.castView(view, 2131296733, "field 'head'");
    view = finder.findRequiredView(source, 2131296737, "field 'stu_name'");
    target.stu_name = finder.castView(view, 2131296737, "field 'stu_name'");
    view = finder.findRequiredView(source, 2131296738, "field 'stu_phone' and method 'setTea'");
    target.stu_phone = finder.castView(view, 2131296738, "field 'stu_phone'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setTea();
        }
      });
    view = finder.findRequiredView(source, 2131296739, "field 'type_tag'");
    target.type_tag = finder.castView(view, 2131296739, "field 'type_tag'");
    view = finder.findRequiredView(source, 2131296728, "field 'class_name'");
    target.class_name = finder.castView(view, 2131296728, "field 'class_name'");
    view = finder.findRequiredView(source, 2131296723, "field 'check_one'");
    target.check_one = finder.castView(view, 2131296723, "field 'check_one'");
    view = finder.findRequiredView(source, 2131296725, "field 'check_two'");
    target.check_two = finder.castView(view, 2131296725, "field 'check_two'");
    view = finder.findRequiredView(source, 2131296724, "field 'check_three' and method 'setStuPhone'");
    target.check_three = finder.castView(view, 2131296724, "field 'check_three'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setStuPhone();
        }
      });
    view = finder.findRequiredView(source, 2131296722, "field 'check_four'");
    target.check_four = finder.castView(view, 2131296722, "field 'check_four'");
    view = finder.findRequiredView(source, 2131296736, "field 'multi'");
    target.multi = finder.castView(view, 2131296736, "field 'multi'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.head = null;
    target.stu_name = null;
    target.stu_phone = null;
    target.type_tag = null;
    target.class_name = null;
    target.check_one = null;
    target.check_two = null;
    target.check_three = null;
    target.check_four = null;
    target.multi = null;
  }
}
