// Generated code from Butter Knife. Do not modify!
package com.yfy.app.tea_evaluate;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ChartDetailActivity$$ViewBinder<T extends com.yfy.app.tea_evaluate.ChartDetailActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297293, "field 'delete' and method 'setDelete'");
    target.delete = finder.castView(view, 2131297293, "field 'delete'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setDelete();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.delete = null;
  }
}
