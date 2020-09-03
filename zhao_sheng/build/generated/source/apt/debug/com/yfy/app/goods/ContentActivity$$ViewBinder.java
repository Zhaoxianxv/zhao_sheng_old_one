// Generated code from Butter Knife. Do not modify!
package com.yfy.app.goods;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ContentActivity$$ViewBinder<T extends com.yfy.app.goods.ContentActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296502, "field 'edit'");
    target.edit = finder.castView(view, 2131296502, "field 'edit'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.edit = null;
  }
}
