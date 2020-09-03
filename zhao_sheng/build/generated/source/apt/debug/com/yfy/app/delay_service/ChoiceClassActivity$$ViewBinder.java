// Generated code from Butter Knife. Do not modify!
package com.yfy.app.delay_service;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ChoiceClassActivity$$ViewBinder<T extends com.yfy.app.delay_service.ChoiceClassActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297284, "field 'bottom' and method 'setButton'");
    target.bottom = finder.castView(view, 2131297284, "field 'bottom'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setButton();
        }
      });
    view = finder.findRequiredView(source, 2131297285, "field 'bottomone' and method 'setOne'");
    target.bottomone = finder.castView(view, 2131297285, "field 'bottomone'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOne();
        }
      });
    view = finder.findRequiredView(source, 2131296747, "field 'listview'");
    target.listview = finder.castView(view, 2131296747, "field 'listview'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.bottom = null;
    target.bottomone = null;
    target.listview = null;
  }
}
