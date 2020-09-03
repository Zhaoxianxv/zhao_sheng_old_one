// Generated code from Butter Knife. Do not modify!
package com.yfy.app.school;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class NewsPagerFragment$$ViewBinder<T extends com.yfy.app.school.NewsPagerFragment> extends com.yfy.base.fragment.BaseFragment$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297360, "field 'refresh_lv'");
    target.refresh_lv = finder.castView(view, 2131297360, "field 'refresh_lv'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.refresh_lv = null;
  }
}
