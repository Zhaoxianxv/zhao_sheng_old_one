// Generated code from Butter Knife. Do not modify!
package com.yfy.app.maintainnew;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MaintainNewDetailAdminActivity$$ViewBinder<T extends com.yfy.app.maintainnew.MaintainNewDetailAdminActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297093, "field 'listView'");
    target.listView = finder.castView(view, 2131297093, "field 'listView'");
    view = finder.findRequiredView(source, 2131297092, "field 'layout'");
    target.layout = finder.castView(view, 2131297092, "field 'layout'");
    view = finder.findRequiredView(source, 2131296625, "method 'setChicoe'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChicoe();
        }
      });
    view = finder.findRequiredView(source, 2131296633, "method 'setDo'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setDo();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.listView = null;
    target.layout = null;
  }
}
