// Generated code from Butter Knife. Do not modify!
package com.yfy.app.integral.subjcet;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SubjcetDoActivity$$ViewBinder<T extends com.yfy.app.integral.subjcet.SubjcetDoActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297547, "field 'xlist'");
    target.xlist = finder.castView(view, 2131297547, "field 'xlist'");
    view = finder.findRequiredView(source, 2131297546, "method 'setDel'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setDel();
        }
      });
    view = finder.findRequiredView(source, 2131297545, "method 'setAdd'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setAdd();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.xlist = null;
  }
}
