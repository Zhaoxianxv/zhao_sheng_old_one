// Generated code from Butter Knife. Do not modify!
package com.yfy.app.appointment;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AdminDoScroeActivity$$ViewBinder<T extends com.yfy.app.appointment.AdminDoScroeActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297397, "field 'rating_edit'");
    target.rating_edit = finder.castView(view, 2131297397, "field 'rating_edit'");
    view = finder.findRequiredView(source, 2131297396, "field 'ratingbar'");
    target.ratingbar = finder.castView(view, 2131297396, "field 'ratingbar'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.rating_edit = null;
    target.ratingbar = null;
  }
}
