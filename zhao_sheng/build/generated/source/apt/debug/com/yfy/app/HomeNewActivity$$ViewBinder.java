// Generated code from Butter Knife. Do not modify!
package com.yfy.app;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class HomeNewActivity$$ViewBinder<T extends com.yfy.app.HomeNewActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296919, "field 'login_tv' and method 'setHead'");
    target.login_tv = finder.castView(view, 2131296919, "field 'login_tv'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setHead();
        }
      });
    view = finder.findRequiredView(source, 2131297065, "field 'bottom_layout'");
    target.bottom_layout = finder.castView(view, 2131297065, "field 'bottom_layout'");
    view = finder.findRequiredView(source, 2131297067, "field 'main_edit'");
    target.main_edit = finder.castView(view, 2131297067, "field 'main_edit'");
    view = finder.findRequiredView(source, 2131297071, "field 'set_point' and method 'setSet'");
    target.set_point = finder.castView(view, 2131297071, "field 'set_point'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setSet();
        }
      });
    view = finder.findRequiredView(source, 2131297068, "field 'main_contetn'");
    target.main_contetn = finder.castView(view, 2131297068, "field 'main_contetn'");
    view = finder.findRequiredView(source, 2131297064, "field 'clear_all' and method 'setClearAll'");
    target.clear_all = finder.castView(view, 2131297064, "field 'clear_all'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setClearAll();
        }
      });
    view = finder.findRequiredView(source, 2131296924, "field 'recyclerView'");
    target.recyclerView = finder.castView(view, 2131296924, "field 'recyclerView'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.login_tv = null;
    target.bottom_layout = null;
    target.main_edit = null;
    target.set_point = null;
    target.main_contetn = null;
    target.clear_all = null;
    target.recyclerView = null;
  }
}
