// Generated code from Butter Knife. Do not modify!
package com.yfy.app.oashow;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class BossMainActivity$$ViewBinder<T extends com.yfy.app.oashow.BossMainActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296399, "method 'setOne'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOne();
        }
      });
    view = finder.findRequiredView(source, 2131296401, "method 'setTwo'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setTwo();
        }
      });
    view = finder.findRequiredView(source, 2131296400, "method 'setThree'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setThree();
        }
      });
    view = finder.findRequiredView(source, 2131296398, "method 'setFour'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setFour();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

  }
}
