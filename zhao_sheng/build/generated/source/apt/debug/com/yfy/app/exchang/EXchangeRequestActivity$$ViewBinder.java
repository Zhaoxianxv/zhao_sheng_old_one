// Generated code from Butter Knife. Do not modify!
package com.yfy.app.exchang;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class EXchangeRequestActivity$$ViewBinder<T extends com.yfy.app.exchang.EXchangeRequestActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296776, "field 'title'");
    target.title = finder.castView(view, 2131296776, "field 'title'");
    view = finder.findRequiredView(source, 2131296777, "field 'submit_1'");
    target.submit_1 = finder.castView(view, 2131296777, "field 'submit_1'");
    view = finder.findRequiredView(source, 2131296778, "field 'submit_2'");
    target.submit_2 = finder.castView(view, 2131296778, "field 'submit_2'");
    view = finder.findRequiredView(source, 2131296779, "field 'submit_3'");
    target.submit_3 = finder.castView(view, 2131296779, "field 'submit_3'");
    view = finder.findRequiredView(source, 2131296780, "field 'submit_4'");
    target.submit_4 = finder.castView(view, 2131296780, "field 'submit_4'");
    view = finder.findRequiredView(source, 2131296794, "field 'edit'");
    target.edit = finder.castView(view, 2131296794, "field 'edit'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.title = null;
    target.submit_1 = null;
    target.submit_2 = null;
    target.submit_3 = null;
    target.submit_4 = null;
    target.edit = null;
  }
}
