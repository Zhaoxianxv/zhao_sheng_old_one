// Generated code from Butter Knife. Do not modify!
package com.yfy.app.delay_service;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DelayAdminToTeaEventActivity$$ViewBinder<T extends com.yfy.app.delay_service.DelayAdminToTeaEventActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296578, "field 'multi'");
    target.multi = finder.castView(view, 2131296578, "field 'multi'");
    view = finder.findRequiredView(source, 2131296577, "field 'date_show'");
    target.date_show = finder.castView(view, 2131296577, "field 'date_show'");
    view = finder.findRequiredView(source, 2131296583, "field 'event_site'");
    target.event_site = finder.castView(view, 2131296583, "field 'event_site'");
    view = finder.findRequiredView(source, 2131296584, "field 'tea_name' and method 'setChoiceTea'");
    target.tea_name = finder.castView(view, 2131296584, "field 'tea_name'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChoiceTea();
        }
      });
    view = finder.findRequiredView(source, 2131296582, "field 'repleace_layout'");
    target.repleace_layout = finder.castView(view, 2131296582, "field 'repleace_layout'");
    view = finder.findRequiredView(source, 2131296581, "field 'replace_tea' and method 'setChoiceReplaceTea'");
    target.replace_tea = finder.castView(view, 2131296581, "field 'replace_tea'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChoiceReplaceTea();
        }
      });
    view = finder.findRequiredView(source, 2131296576, "field 'class_name'");
    target.class_name = finder.castView(view, 2131296576, "field 'class_name'");
    view = finder.findRequiredView(source, 2131296580, "field 'content_edit'");
    target.content_edit = finder.castView(view, 2131296580, "field 'content_edit'");
    view = finder.findRequiredView(source, 2131296579, "field 'num_edit'");
    target.num_edit = finder.castView(view, 2131296579, "field 'num_edit'");
    view = finder.findRequiredView(source, 2131296585, "field 'type_layout'");
    target.type_layout = finder.castView(view, 2131296585, "field 'type_layout'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.multi = null;
    target.date_show = null;
    target.event_site = null;
    target.tea_name = null;
    target.repleace_layout = null;
    target.replace_tea = null;
    target.class_name = null;
    target.content_edit = null;
    target.num_edit = null;
    target.type_layout = null;
  }
}
