// Generated code from Butter Knife. Do not modify!
package com.yfy.app.school;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SchoolNewsActivity$$ViewBinder<T extends com.yfy.app.school.SchoolNewsActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297567, "field 'tabLayout'");
    target.tabLayout = finder.castView(view, 2131297567, "field 'tabLayout'");
    view = finder.findRequiredView(source, 2131297230, "field 'viewPager'");
    target.viewPager = finder.castView(view, 2131297230, "field 'viewPager'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.tabLayout = null;
    target.viewPager = null;
  }
}
