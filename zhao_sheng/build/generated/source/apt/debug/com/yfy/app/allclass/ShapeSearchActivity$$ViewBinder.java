// Generated code from Butter Knife. Do not modify!
package com.yfy.app.allclass;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ShapeSearchActivity$$ViewBinder<T extends com.yfy.app.allclass.ShapeSearchActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297489, "field 'recyclerView'");
    target.recyclerView = finder.castView(view, 2131297489, "field 'recyclerView'");
    view = finder.findRequiredView(source, 2131297473, "field 'clear_et'");
    target.clear_et = finder.castView(view, 2131297473, "field 'clear_et'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.recyclerView = null;
    target.clear_et = null;
  }
}
