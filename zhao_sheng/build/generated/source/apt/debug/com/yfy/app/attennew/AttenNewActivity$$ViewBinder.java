// Generated code from Butter Knife. Do not modify!
package com.yfy.app.attennew;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AttenNewActivity$$ViewBinder<T extends com.yfy.app.attennew.AttenNewActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297692, "field 'two_count'");
    target.two_count = finder.castView(view, 2131297692, "field 'two_count'");
    view = finder.findRequiredView(source, 2131296530, "field 'coor_count'");
    target.coor_count = finder.castView(view, 2131296530, "field 'coor_count'");
    view = finder.findRequiredView(source, 2131296533, "method 'setOneLayout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOneLayout();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.two_count = null;
    target.coor_count = null;
  }
}
