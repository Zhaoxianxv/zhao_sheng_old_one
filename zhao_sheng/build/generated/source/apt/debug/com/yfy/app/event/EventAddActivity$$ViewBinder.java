// Generated code from Butter Knife. Do not modify!
package com.yfy.app.event;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class EventAddActivity$$ViewBinder<T extends com.yfy.app.event.EventAddActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296717, "field 'time_view' and method 'setTime'");
    target.time_view = finder.castView(view, 2131296717, "field 'time_view'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setTime();
        }
      });
    view = finder.findRequiredView(source, 2131296740, "field 'user_edeit'");
    target.user_edeit = finder.castView(view, 2131296740, "field 'user_edeit'");
    view = finder.findRequiredView(source, 2131296713, "field 'dep_view' and method 'setPro'");
    target.dep_view = finder.castView(view, 2131296713, "field 'dep_view'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setPro();
        }
      });
    view = finder.findRequiredView(source, 2131296716, "field 'site_edit'");
    target.site_edit = finder.castView(view, 2131296716, "field 'site_edit'");
    view = finder.findRequiredView(source, 2131296711, "field 'content_edit'");
    target.content_edit = finder.castView(view, 2131296711, "field 'content_edit'");
    view = finder.findRequiredView(source, 2131296714, "field 'add_mult'");
    target.add_mult = finder.castView(view, 2131296714, "field 'add_mult'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.time_view = null;
    target.user_edeit = null;
    target.dep_view = null;
    target.site_edit = null;
    target.content_edit = null;
    target.add_mult = null;
  }
}
