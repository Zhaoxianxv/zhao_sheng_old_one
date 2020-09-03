// Generated code from Butter Knife. Do not modify!
package com.yfy.app.login;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AlterPassActivity$$ViewBinder<T extends com.yfy.app.login.AlterPassActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296312, "field 'old'");
    target.old = finder.castView(view, 2131296312, "field 'old'");
    view = finder.findRequiredView(source, 2131296311, "field 'first'");
    target.first = finder.castView(view, 2131296311, "field 'first'");
    view = finder.findRequiredView(source, 2131296310, "field 'again'");
    target.again = finder.castView(view, 2131296310, "field 'again'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.old = null;
    target.first = null;
    target.again = null;
  }
}
