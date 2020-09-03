// Generated code from Butter Knife. Do not modify!
package com.yfy.app.login;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class LoginActivity$$ViewBinder<T extends com.yfy.app.login.LoginActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297057, "field 'account'");
    target.account = finder.castView(view, 2131297057, "field 'account'");
    view = finder.findRequiredView(source, 2131297056, "field 'password'");
    target.password = finder.castView(view, 2131297056, "field 'password'");
    view = finder.findRequiredView(source, 2131297052, "field 'code'");
    target.code = finder.castView(view, 2131297052, "field 'code'");
    view = finder.findRequiredView(source, 2131297053, "field 'code_icon' and method 'setImage'");
    target.code_icon = finder.castView(view, 2131297053, "field 'code_icon'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setImage();
        }
      });
    view = finder.findRequiredView(source, 2131296307, "field 'rootView'");
    target.rootView = finder.castView(view, 2131296307, "field 'rootView'");
    view = finder.findRequiredView(source, 2131297563, "field 'scrollView'");
    target.scrollView = finder.castView(view, 2131297563, "field 'scrollView'");
    view = finder.findRequiredView(source, 2131297051, "method 'setlogin'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setlogin();
        }
      });
    view = finder.findRequiredView(source, 2131297055, "method 'setForget'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setForget();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.account = null;
    target.password = null;
    target.code = null;
    target.code_icon = null;
    target.rootView = null;
    target.scrollView = null;
  }
}
