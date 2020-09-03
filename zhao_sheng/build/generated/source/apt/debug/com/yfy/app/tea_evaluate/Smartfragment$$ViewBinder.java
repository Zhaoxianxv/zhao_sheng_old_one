// Generated code from Butter Knife. Do not modify!
package com.yfy.app.tea_evaluate;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class Smartfragment$$ViewBinder<T extends com.yfy.app.tea_evaluate.Smartfragment> extends com.yfy.base.fragment.BaseFragment$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297568, "field 'table'");
    target.table = finder.castView(view, 2131297568, "field 'table'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.table = null;
  }
}
