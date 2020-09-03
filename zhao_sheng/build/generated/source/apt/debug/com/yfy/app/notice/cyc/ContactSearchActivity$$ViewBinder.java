// Generated code from Butter Knife. Do not modify!
package com.yfy.app.notice.cyc;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ContactSearchActivity$$ViewBinder<T extends com.yfy.app.notice.cyc.ContactSearchActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296502, "field 'clear_et'");
    target.clear_et = finder.castView(view, 2131296502, "field 'clear_et'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.clear_et = null;
  }
}
