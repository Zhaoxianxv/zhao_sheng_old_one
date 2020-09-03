// Generated code from Butter Knife. Do not modify!
package com.yfy.app.maintainnew;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MaintainEditActivity$$ViewBinder<T extends com.yfy.app.maintainnew.MaintainEditActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296702, "field 'title' and method 'setTitle'");
    target.title = finder.castView(view, 2131296702, "field 'title'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setTitle();
        }
      });
    view = finder.findRequiredView(source, 2131296697, "field 'edit_content'");
    target.edit_content = finder.castView(view, 2131296697, "field 'edit_content'");
    view = finder.findRequiredView(source, 2131297084, "method 'setLayout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setLayout();
        }
      });
    view = finder.findRequiredView(source, 2131296693, "method 'setCancel'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setCancel();
        }
      });
    view = finder.findRequiredView(source, 2131296698, "method 'setOk'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOk();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.title = null;
    target.edit_content = null;
  }
}
