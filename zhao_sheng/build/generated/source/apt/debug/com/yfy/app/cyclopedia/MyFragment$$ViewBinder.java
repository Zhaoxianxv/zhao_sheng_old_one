// Generated code from Butter Knife. Do not modify!
package com.yfy.app.cyclopedia;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MyFragment$$ViewBinder<T extends com.yfy.app.cyclopedia.MyFragment> extends com.yfy.base.fragment.BaseFragment$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296553, "field 'xlist'");
    target.xlist = finder.castView(view, 2131296553, "field 'xlist'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.xlist = null;
  }
}
