// Generated code from Butter Knife. Do not modify!
package com.yfy.app.allclass;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ShapeDynamicActivity$$ViewBinder<T extends com.yfy.app.allclass.ShapeDynamicActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297471, "field 'tepy_tag' and method 'setChioce'");
    target.tepy_tag = finder.castView(view, 2131297471, "field 'tepy_tag'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChioce();
        }
      });
    view = finder.findRequiredView(source, 2131297472, "field 'add_mult'");
    target.add_mult = finder.castView(view, 2131297472, "field 'add_mult'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.tepy_tag = null;
    target.add_mult = null;
  }
}
