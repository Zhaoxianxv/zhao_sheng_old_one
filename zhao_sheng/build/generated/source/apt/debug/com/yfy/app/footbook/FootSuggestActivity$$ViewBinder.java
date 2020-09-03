// Generated code from Butter Knife. Do not modify!
package com.yfy.app.footbook;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class FootSuggestActivity$$ViewBinder<T extends com.yfy.app.footbook.FootSuggestActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296826, "field 'suggest_edit'");
    target.suggest_edit = finder.castView(view, 2131296826, "field 'suggest_edit'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.suggest_edit = null;
  }
}
