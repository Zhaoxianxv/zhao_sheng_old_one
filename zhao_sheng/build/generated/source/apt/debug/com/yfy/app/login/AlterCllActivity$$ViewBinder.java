// Generated code from Butter Knife. Do not modify!
package com.yfy.app.login;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AlterCllActivity$$ViewBinder<T extends com.yfy.app.login.AlterCllActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296427, "field 'first'");
    target.first = finder.castView(view, 2131296427, "field 'first'");
    view = finder.findRequiredView(source, 2131296426, "field 'again'");
    target.again = finder.castView(view, 2131296426, "field 'again'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.first = null;
    target.again = null;
  }
}
