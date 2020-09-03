// Generated code from Butter Knife. Do not modify!
package com.yfy.app.answer;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AnswerItemDetailActivity$$ViewBinder<T extends com.yfy.app.answer.AnswerItemDetailActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296325, "field 'xlist'");
    target.xlist = finder.castView(view, 2131296325, "field 'xlist'");
    view = finder.findRequiredView(source, 2131296328, "field 'head'");
    target.head = finder.castView(view, 2131296328, "field 'head'");
    view = finder.findRequiredView(source, 2131296327, "field 'bg'");
    target.bg = finder.castView(view, 2131296327, "field 'bg'");
    view = finder.findRequiredView(source, 2131296329, "field 'content' and method 'setShow'");
    target.content = finder.castView(view, 2131296329, "field 'content'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setShow();
        }
      });
    view = finder.findRequiredView(source, 2131296330, "field 'time'");
    target.time = finder.castView(view, 2131296330, "field 'time'");
    view = finder.findRequiredView(source, 2131296326, "field 'fab' and method 'setFab'");
    target.fab = finder.castView(view, 2131296326, "field 'fab'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setFab();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.xlist = null;
    target.head = null;
    target.bg = null;
    target.content = null;
    target.time = null;
    target.fab = null;
  }
}
