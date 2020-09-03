// Generated code from Butter Knife. Do not modify!
package com.yfy.app.maintainnew;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MaintainNewAddActivity$$ViewBinder<T extends com.yfy.app.maintainnew.MaintainNewAddActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297095, "field 'add_mult'");
    target.add_mult = finder.castView(view, 2131297095, "field 'add_mult'");
    view = finder.findRequiredView(source, 2131297671, "field 'trouble_time'");
    target.trouble_time = finder.castView(view, 2131297671, "field 'trouble_time'");
    view = finder.findRequiredView(source, 2131297669, "field 'trouble_dep' and method 'setDep'");
    target.trouble_dep = finder.castView(view, 2131297669, "field 'trouble_dep'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setDep();
        }
      });
    view = finder.findRequiredView(source, 2131297670, "field 'trouble_place' and method 'setPlace'");
    target.trouble_place = finder.castView(view, 2131297670, "field 'trouble_place'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setPlace();
        }
      });
    view = finder.findRequiredView(source, 2131297668, "field 'trouble_content' and method 'setContent'");
    target.trouble_content = finder.castView(view, 2131297668, "field 'trouble_content'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setContent();
        }
      });
    view = finder.findRequiredView(source, 2131297063, "field 'tell'");
    target.tell = finder.castView(view, 2131297063, "field 'tell'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.add_mult = null;
    target.trouble_time = null;
    target.trouble_dep = null;
    target.trouble_place = null;
    target.trouble_content = null;
    target.tell = null;
  }
}
