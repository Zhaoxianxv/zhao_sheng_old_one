// Generated code from Butter Knife. Do not modify!
package com.yfy.app.seal;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SealAdminDoActivity$$ViewBinder<T extends com.yfy.app.seal.SealAdminDoActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297435, "field 'state_flow'");
    target.state_flow = finder.castView(view, 2131297435, "field 'state_flow'");
    view = finder.findRequiredView(source, 2131297433, "field 'reason_edit'");
    target.reason_edit = finder.castView(view, 2131297433, "field 'reason_edit'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.state_flow = null;
    target.reason_edit = null;
  }
}
