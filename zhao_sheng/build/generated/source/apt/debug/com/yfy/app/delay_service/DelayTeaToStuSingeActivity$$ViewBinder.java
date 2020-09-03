// Generated code from Butter Knife. Do not modify!
package com.yfy.app.delay_service;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DelayTeaToStuSingeActivity$$ViewBinder<T extends com.yfy.app.delay_service.DelayTeaToStuSingeActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296613, "field 'multi'");
    target.multi = finder.castView(view, 2131296613, "field 'multi'");
    view = finder.findRequiredView(source, 2131296612, "field 'date_show'");
    target.date_show = finder.castView(view, 2131296612, "field 'date_show'");
    view = finder.findRequiredView(source, 2131296616, "field 'user_name'");
    target.user_name = finder.castView(view, 2131296616, "field 'user_name'");
    view = finder.findRequiredView(source, 2131296615, "field 'delay_type' and method 'setOval'");
    target.delay_type = finder.castView(view, 2131296615, "field 'delay_type'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOval();
        }
      });
    view = finder.findRequiredView(source, 2131296614, "field 'reason_edit'");
    target.reason_edit = finder.castView(view, 2131296614, "field 'reason_edit'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.multi = null;
    target.date_show = null;
    target.user_name = null;
    target.delay_type = null;
    target.reason_edit = null;
  }
}
