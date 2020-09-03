// Generated code from Butter Knife. Do not modify!
package com.yfy.app;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class VsionDetailActivity$$ViewBinder<T extends com.yfy.app.VsionDetailActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297708, "field 'version'");
    target.version = finder.castView(view, 2131297708, "field 'version'");
    view = finder.findRequiredView(source, 2131297715, "field 'version_weiht'");
    target.version_weiht = finder.castView(view, 2131297715, "field 'version_weiht'");
    view = finder.findRequiredView(source, 2131297712, "field 'version_name'");
    target.version_name = finder.castView(view, 2131297712, "field 'version_name'");
    view = finder.findRequiredView(source, 2131297713, "field 'version_site'");
    target.version_site = finder.castView(view, 2131297713, "field 'version_site'");
    view = finder.findRequiredView(source, 2131297714, "field 'version_tell'");
    target.version_tell = finder.castView(view, 2131297714, "field 'version_tell'");
    view = finder.findRequiredView(source, 2131297709, "field 'version_admin'");
    target.version_admin = finder.castView(view, 2131297709, "field 'version_admin'");
    view = finder.findRequiredView(source, 2131297711, "method 'setPrivate'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setPrivate();
        }
      });
    view = finder.findRequiredView(source, 2131297710, "method 'setAgreement'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setAgreement();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.version = null;
    target.version_weiht = null;
    target.version_name = null;
    target.version_site = null;
    target.version_tell = null;
    target.version_admin = null;
  }
}
