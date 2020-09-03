// Generated code from Butter Knife. Do not modify!
package com.yfy.app.delay_service;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DelayMasterAdminListActivity$$ViewBinder<T extends com.yfy.app.delay_service.DelayMasterAdminListActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297293, "field 'del_bottom' and method 'setDelay'");
    target.del_bottom = finder.castView(view, 2131297293, "field 'del_bottom'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setDelay();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.del_bottom = null;
  }
}
