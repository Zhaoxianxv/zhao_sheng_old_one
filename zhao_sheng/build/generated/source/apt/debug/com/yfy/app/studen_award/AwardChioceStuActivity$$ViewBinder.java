// Generated code from Butter Knife. Do not modify!
package com.yfy.app.studen_award;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AwardChioceStuActivity$$ViewBinder<T extends com.yfy.app.studen_award.AwardChioceStuActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296388, "field 'xlist'");
    target.xlist = finder.castView(view, 2131296388, "field 'xlist'");
    view = finder.findRequiredView(source, 2131296366, "field 'clear_et' and method 'setClear'");
    target.clear_et = finder.castView(view, 2131296366, "field 'clear_et'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setClear();
        }
      });
    view = finder.findRequiredView(source, 2131296422, "field 'layout'");
    target.layout = finder.castView(view, 2131296422, "field 'layout'");
    view = finder.findRequiredView(source, 2131296308, "method 'setAll'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setAll();
        }
      });
    view = finder.findRequiredView(source, 2131296810, "method 'setfirech'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setfirech();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.xlist = null;
    target.clear_et = null;
    target.layout = null;
  }
}
