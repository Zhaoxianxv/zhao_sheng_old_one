// Generated code from Butter Knife. Do not modify!
package com.yfy.app.studen_award;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AwardDialogActivity$$ViewBinder<T extends com.yfy.app.studen_award.AwardDialogActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296369, "field 'grade_grid'");
    target.grade_grid = finder.castView(view, 2131296369, "field 'grade_grid'");
    view = finder.findRequiredView(source, 2131296371, "field 'type_grid'");
    target.type_grid = finder.castView(view, 2131296371, "field 'type_grid'");
    view = finder.findRequiredView(source, 2131296387, "method 'setDialogBg'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setDialogBg();
        }
      });
    view = finder.findRequiredView(source, 2131296374, "method 'setLayout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setLayout();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.grade_grid = null;
    target.type_grid = null;
  }
}
