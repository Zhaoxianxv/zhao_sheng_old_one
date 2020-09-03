// Generated code from Butter Knife. Do not modify!
package com.yfy.app.maintainnew;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MaintainDoingActivity$$ViewBinder<T extends com.yfy.app.maintainnew.MaintainDoingActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296697, "field 'edit_content'");
    target.edit_content = finder.castView(view, 2131296697, "field 'edit_content'");
    view = finder.findRequiredView(source, 2131297100, "field 'add_mult'");
    target.add_mult = finder.castView(view, 2131297100, "field 'add_mult'");
    view = finder.findRequiredView(source, 2131297098, "field 'do_ing' and method 'setDoing'");
    target.do_ing = finder.castView(view, 2131297098, "field 'do_ing'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setDoing();
        }
      });
    view = finder.findRequiredView(source, 2131297101, "field 'do_ok' and method 'setOk'");
    target.do_ok = finder.castView(view, 2131297101, "field 'do_ok'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOk();
        }
      });
    view = finder.findRequiredView(source, 2131297096, "field 'do_cancle' and method 'setCancel'");
    target.do_cancle = finder.castView(view, 2131297096, "field 'do_cancle'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setCancel();
        }
      });
    view = finder.findRequiredView(source, 2131297099, "field 'icon_ing'");
    target.icon_ing = finder.castView(view, 2131297099, "field 'icon_ing'");
    view = finder.findRequiredView(source, 2131297102, "field 'icon_ok'");
    target.icon_ok = finder.castView(view, 2131297102, "field 'icon_ok'");
    view = finder.findRequiredView(source, 2131297097, "field 'icon_cancle'");
    target.icon_cancle = finder.castView(view, 2131297097, "field 'icon_cancle'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.edit_content = null;
    target.add_mult = null;
    target.do_ing = null;
    target.do_ok = null;
    target.do_cancle = null;
    target.icon_ing = null;
    target.icon_ok = null;
    target.icon_cancle = null;
  }
}
