// Generated code from Butter Knife. Do not modify!
package com.yfy.app.allclass;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class EditReplyActivity$$ViewBinder<T extends com.yfy.app.allclass.EditReplyActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296694, "field 'con'");
    target.con = finder.castView(view, 2131296694, "field 'con'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.con = null;
  }
}
