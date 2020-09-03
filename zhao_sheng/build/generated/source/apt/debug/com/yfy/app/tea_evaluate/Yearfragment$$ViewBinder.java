// Generated code from Butter Knife. Do not modify!
package com.yfy.app.tea_evaluate;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class Yearfragment$$ViewBinder<T extends com.yfy.app.tea_evaluate.Yearfragment> extends com.yfy.base.fragment.BaseFragment$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296294, "field 'swipeRefreshLayout'");
    target.swipeRefreshLayout = finder.castView(view, 2131296294, "field 'swipeRefreshLayout'");
    view = finder.findRequiredView(source, 2131297618, "field 'recyclerView'");
    target.recyclerView = finder.castView(view, 2131297618, "field 'recyclerView'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.swipeRefreshLayout = null;
    target.recyclerView = null;
  }
}
