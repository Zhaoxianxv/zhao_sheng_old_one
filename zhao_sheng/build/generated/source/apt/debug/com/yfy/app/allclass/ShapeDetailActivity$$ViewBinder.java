// Generated code from Butter Knife. Do not modify!
package com.yfy.app.allclass;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ShapeDetailActivity$$ViewBinder<T extends com.yfy.app.allclass.ShapeDetailActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297500, "field 'xlist'");
    target.xlist = finder.castView(view, 2131297500, "field 'xlist'");
    view = finder.findRequiredView(source, 2131297499, "method 'setComment'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setComment();
        }
      });
    view = finder.findRequiredView(source, 2131297501, "method 'setPraise'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setPraise();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.xlist = null;
  }
}
