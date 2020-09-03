// Generated code from Butter Knife. Do not modify!
package com.yfy.app.integral;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AddHonorActivity$$ViewBinder<T extends com.yfy.app.integral.AddHonorActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296975, "field 'add_mult'");
    target.add_mult = finder.castView(view, 2131296975, "field 'add_mult'");
    view = finder.findRequiredView(source, 2131296926, "field 'chioce_rank' and method 'setRank'");
    target.chioce_rank = finder.castView(view, 2131296926, "field 'chioce_rank'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setRank();
        }
      });
    view = finder.findRequiredView(source, 2131296927, "field 'chioce_type' and method 'setType'");
    target.chioce_type = finder.castView(view, 2131296927, "field 'chioce_type'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setType();
        }
      });
    view = finder.findRequiredView(source, 2131296928, "field 'get_date' and method 'setDate'");
    target.get_date = finder.castView(view, 2131296928, "field 'get_date'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setDate();
        }
      });
    view = finder.findRequiredView(source, 2131296974, "field 'add_content'");
    target.add_content = finder.castView(view, 2131296974, "field 'add_content'");
    view = finder.findRequiredView(source, 2131296946, "field 'honorUtil' and method 'setHonorUtil'");
    target.honorUtil = finder.castView(view, 2131296946, "field 'honorUtil'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setHonorUtil();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.add_mult = null;
    target.chioce_rank = null;
    target.chioce_type = null;
    target.get_date = null;
    target.add_content = null;
    target.honorUtil = null;
  }
}
