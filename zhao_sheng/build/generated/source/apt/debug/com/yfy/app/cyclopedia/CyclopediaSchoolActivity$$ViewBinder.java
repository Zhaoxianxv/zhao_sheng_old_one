// Generated code from Butter Knife. Do not modify!
package com.yfy.app.cyclopedia;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class CyclopediaSchoolActivity$$ViewBinder<T extends com.yfy.app.cyclopedia.CyclopediaSchoolActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296916, "field 'bottomschool' and method 'setSchool'");
    target.bottomschool = finder.castView(view, 2131296916, "field 'bottomschool'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setSchool(finder.<com.yfy.view.button.BottomItem>castParam(p0, "doClick", 0, "setSchool", 0));
        }
      });
    view = finder.findRequiredView(source, 2131296915, "field 'bottomclass' and method 'setClass'");
    target.bottomclass = finder.castView(view, 2131296915, "field 'bottomclass'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setClass(finder.<com.yfy.view.button.BottomItem>castParam(p0, "doClick", 0, "setClass", 0));
        }
      });
    view = finder.findRequiredView(source, 2131296917, "field 'bottomwork' and method 'setWork'");
    target.bottomwork = finder.castView(view, 2131296917, "field 'bottomwork'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setWork(finder.<com.yfy.view.button.BottomItem>castParam(p0, "doClick", 0, "setWork", 0));
        }
      });
    view = finder.findRequiredView(source, 2131296552, "field 'item'");
    target.item = finder.castView(view, 2131296552, "field 'item'");
    view = finder.findRequiredView(source, 2131296547, "field 'call'");
    target.call = finder.castView(view, 2131296547, "field 'call'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.bottomschool = null;
    target.bottomclass = null;
    target.bottomwork = null;
    target.item = null;
    target.call = null;
  }
}
