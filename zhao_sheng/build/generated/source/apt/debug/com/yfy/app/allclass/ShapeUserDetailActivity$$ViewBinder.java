// Generated code from Butter Knife. Do not modify!
package com.yfy.app.allclass;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ShapeUserDetailActivity$$ViewBinder<T extends com.yfy.app.allclass.ShapeUserDetailActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297498, "field 'hradertypy' and method 'setHeader'");
    target.hradertypy = finder.castView(view, 2131297498, "field 'hradertypy'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setHeader();
        }
      });
    view = finder.findRequiredView(source, 2131297488, "field 'recyclerView'");
    target.recyclerView = finder.castView(view, 2131297488, "field 'recyclerView'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.hradertypy = null;
    target.recyclerView = null;
  }
}
