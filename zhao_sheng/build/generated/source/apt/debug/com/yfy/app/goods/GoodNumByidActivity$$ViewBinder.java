// Generated code from Butter Knife. Do not modify!
package com.yfy.app.goods;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class GoodNumByidActivity$$ViewBinder<T extends com.yfy.app.goods.GoodNumByidActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296838, "field 'head'");
    target.head = finder.castView(view, 2131296838, "field 'head'");
    view = finder.findRequiredView(source, 2131296839, "field 'user_name'");
    target.user_name = finder.castView(view, 2131296839, "field 'user_name'");
    view = finder.findRequiredView(source, 2131296841, "field 'user_time'");
    target.user_time = finder.castView(view, 2131296841, "field 'user_time'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.head = null;
    target.user_name = null;
    target.user_time = null;
  }
}
