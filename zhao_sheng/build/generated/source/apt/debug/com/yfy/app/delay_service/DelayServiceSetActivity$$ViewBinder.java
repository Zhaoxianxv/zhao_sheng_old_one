// Generated code from Butter Knife. Do not modify!
package com.yfy.app.delay_service;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DelayServiceSetActivity$$ViewBinder<T extends com.yfy.app.delay_service.DelayServiceSetActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296575, "field 'choice_date' and method 'setChoice'");
    target.choice_date = finder.castView(view, 2131296575, "field 'choice_date'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChoice();
        }
      });
    view = finder.findRequiredView(source, 2131296590, "field 'end_reason'");
    target.end_reason = finder.castView(view, 2131296590, "field 'end_reason'");
    view = finder.findRequiredView(source, 2131296606, "field 'service_reason'");
    target.service_reason = finder.castView(view, 2131296606, "field 'service_reason'");
    view = finder.findRequiredView(source, 2131296605, "field 'add_multi'");
    target.add_multi = finder.castView(view, 2131296605, "field 'add_multi'");
    view = finder.findRequiredView(source, 2131296589, "field 'end_multi'");
    target.end_multi = finder.castView(view, 2131296589, "field 'end_multi'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.choice_date = null;
    target.end_reason = null;
    target.service_reason = null;
    target.add_multi = null;
    target.end_multi = null;
  }
}
