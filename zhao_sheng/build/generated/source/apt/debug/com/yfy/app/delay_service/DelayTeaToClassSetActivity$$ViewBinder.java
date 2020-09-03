// Generated code from Butter Knife. Do not modify!
package com.yfy.app.delay_service;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DelayTeaToClassSetActivity$$ViewBinder<T extends com.yfy.app.delay_service.DelayTeaToClassSetActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296608, "field 'multi'");
    target.multi = finder.castView(view, 2131296608, "field 'multi'");
    view = finder.findRequiredView(source, 2131296607, "field 'date_show'");
    target.date_show = finder.castView(view, 2131296607, "field 'date_show'");
    view = finder.findRequiredView(source, 2131296609, "field 'class_name'");
    target.class_name = finder.castView(view, 2131296609, "field 'class_name'");
    view = finder.findRequiredView(source, 2131296611, "field 'content_edit'");
    target.content_edit = finder.castView(view, 2131296611, "field 'content_edit'");
    view = finder.findRequiredView(source, 2131296610, "field 'num_edit'");
    target.num_edit = finder.castView(view, 2131296610, "field 'num_edit'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.multi = null;
    target.date_show = null;
    target.class_name = null;
    target.content_edit = null;
    target.num_edit = null;
  }
}
