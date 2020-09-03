// Generated code from Butter Knife. Do not modify!
package com.yfy.app.exchang;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ExchangeAcceptActivity$$ViewBinder<T extends com.yfy.app.exchang.ExchangeAcceptActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296777, "field 'submit1'");
    target.submit1 = finder.castView(view, 2131296777, "field 'submit1'");
    view = finder.findRequiredView(source, 2131296778, "field 'submit2'");
    target.submit2 = finder.castView(view, 2131296778, "field 'submit2'");
    view = finder.findRequiredView(source, 2131296779, "field 'submit3'");
    target.submit3 = finder.castView(view, 2131296779, "field 'submit3'");
    view = finder.findRequiredView(source, 2131296780, "field 'submit4'");
    target.submit4 = finder.castView(view, 2131296780, "field 'submit4'");
    view = finder.findRequiredView(source, 2131296776, "field 'project_title'");
    target.project_title = finder.castView(view, 2131296776, "field 'project_title'");
    view = finder.findRequiredView(source, 2131296775, "field 'content'");
    target.content = finder.castView(view, 2131296775, "field 'content'");
    view = finder.findRequiredView(source, 2131296793, "field 'edit'");
    target.edit = finder.castView(view, 2131296793, "field 'edit'");
    view = finder.findRequiredView(source, 2131296407, "field 'layout'");
    target.layout = finder.castView(view, 2131296407, "field 'layout'");
    view = finder.findRequiredView(source, 2131296796, "method 'setOk'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOk();
        }
      });
    view = finder.findRequiredView(source, 2131296795, "method 'setNotOk'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setNotOk();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.submit1 = null;
    target.submit2 = null;
    target.submit3 = null;
    target.submit4 = null;
    target.project_title = null;
    target.content = null;
    target.edit = null;
    target.layout = null;
  }
}
