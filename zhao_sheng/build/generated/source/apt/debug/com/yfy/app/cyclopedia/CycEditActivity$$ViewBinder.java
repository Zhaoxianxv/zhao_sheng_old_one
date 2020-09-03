// Generated code from Butter Knife. Do not modify!
package com.yfy.app.cyclopedia;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class CycEditActivity$$ViewBinder<T extends com.yfy.app.cyclopedia.CycEditActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296546, "field 'add_mult'");
    target.add_mult = finder.castView(view, 2131296546, "field 'add_mult'");
    view = finder.findRequiredView(source, 2131296549, "field 'spinner'");
    target.spinner = finder.castView(view, 2131296549, "field 'spinner'");
    view = finder.findRequiredView(source, 2131297265, "field 'edit'");
    target.edit = finder.castView(view, 2131297265, "field 'edit'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.add_mult = null;
    target.spinner = null;
    target.edit = null;
  }
}
