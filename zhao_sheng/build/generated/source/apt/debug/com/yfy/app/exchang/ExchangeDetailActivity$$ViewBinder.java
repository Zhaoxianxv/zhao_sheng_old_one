// Generated code from Butter Knife. Do not modify!
package com.yfy.app.exchang;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ExchangeDetailActivity$$ViewBinder<T extends com.yfy.app.exchang.ExchangeDetailActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
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
    view = finder.findRequiredView(source, 2131296774, "field 'call'");
    target.call = finder.castView(view, 2131296774, "field 'call'");
    view = finder.findRequiredView(source, 2131296792, "field 'tag_red'");
    target.tag_red = finder.castView(view, 2131296792, "field 'tag_red'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.submit1 = null;
    target.submit2 = null;
    target.submit3 = null;
    target.submit4 = null;
    target.project_title = null;
    target.content = null;
    target.call = null;
    target.tag_red = null;
  }
}
