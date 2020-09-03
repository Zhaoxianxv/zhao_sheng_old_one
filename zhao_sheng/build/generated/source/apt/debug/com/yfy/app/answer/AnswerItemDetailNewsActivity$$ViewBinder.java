// Generated code from Butter Knife. Do not modify!
package com.yfy.app.answer;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AnswerItemDetailNewsActivity$$ViewBinder<T extends com.yfy.app.answer.AnswerItemDetailNewsActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296326, "method 'setFab'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setFab();
        }
      });
    view = finder.findRequiredView(source, 2131296329, "method 'setShow'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setShow();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

  }
}
