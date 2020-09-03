// Generated code from Butter Knife. Do not modify!
package com.yfy.app.footbook;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class Foot1Fragment$$ViewBinder<T extends com.yfy.app.footbook.Foot1Fragment> extends com.yfy.base.fragment.BaseFragment$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296821, "field 'xlist'");
    target.xlist = finder.castView(view, 2131296821, "field 'xlist'");
    view = finder.findRequiredView(source, 2131297659, "field 'float_view'");
    target.float_view = finder.castView(view, 2131297659, "field 'float_view'");
    view = finder.findRequiredView(source, 2131296824, "field 'group_tv'");
    target.group_tv = finder.castView(view, 2131296824, "field 'group_tv'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.xlist = null;
    target.float_view = null;
    target.group_tv = null;
  }
}
