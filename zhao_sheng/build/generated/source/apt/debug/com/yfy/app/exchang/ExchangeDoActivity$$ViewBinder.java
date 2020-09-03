// Generated code from Butter Knife. Do not modify!
package com.yfy.app.exchang;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ExchangeDoActivity$$ViewBinder<T extends com.yfy.app.exchang.ExchangeDoActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296773, "field 'xlist'");
    target.xlist = finder.castView(view, 2131296773, "field 'xlist'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.xlist = null;
  }
}
