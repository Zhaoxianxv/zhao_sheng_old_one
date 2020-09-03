// Generated code from Butter Knife. Do not modify!
package com.yfy.app.notice.cyc;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class NoticeDetailsActivity$$ViewBinder<T extends com.yfy.app.notice.cyc.NoticeDetailsActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297352, "field 'state_tag'");
    target.state_tag = finder.castView(view, 2131297352, "field 'state_tag'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.state_tag = null;
  }
}
