// Generated code from Butter Knife. Do not modify!
package com.yfy.app.integral.subjcet;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SubjcetTeaSetActivity$$ViewBinder<T extends com.yfy.app.integral.subjcet.SubjcetTeaSetActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297544, "field 'listView'");
    target.listView = finder.castView(view, 2131297544, "field 'listView'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.listView = null;
  }
}
