// Generated code from Butter Knife. Do not modify!
package com.yfy.app.login;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class PhoneCodectivity$$ViewBinder<T extends com.yfy.app.login.PhoneCodectivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297369, "field 'edit_phone'");
    target.edit_phone = finder.castView(view, 2131297369, "field 'edit_phone'");
    view = finder.findRequiredView(source, 2131297367, "field 'edit_code'");
    target.edit_code = finder.castView(view, 2131297367, "field 'edit_code'");
    view = finder.findRequiredView(source, 2131297468, "field 'send_code' and method 'setSendcode'");
    target.send_code = finder.castView(view, 2131297468, "field 'send_code'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setSendcode();
        }
      });
    view = finder.findRequiredView(source, 2131297368, "field 'edit_new_pass'");
    target.edit_new_pass = finder.castView(view, 2131297368, "field 'edit_new_pass'");
    view = finder.findRequiredView(source, 2131297365, "field 'alter_edit_pass'");
    target.alter_edit_pass = finder.castView(view, 2131297365, "field 'alter_edit_pass'");
    view = finder.findRequiredView(source, 2131296829, "method 'setBtn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setBtn();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.edit_phone = null;
    target.edit_code = null;
    target.send_code = null;
    target.edit_new_pass = null;
    target.alter_edit_pass = null;
  }
}
