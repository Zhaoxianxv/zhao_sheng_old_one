// Generated code from Butter Knife. Do not modify!
package com.yfy.base.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class BaseActivity$$ViewBinder<T extends com.yfy.base.activity.BaseActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findOptionalView(source, 2131297527, null);
    target.toolbar = finder.castView(view, 2131297527, "field 'toolbar'");
  }

  @Override public void unbind(T target) {
    target.toolbar = null;
  }
}