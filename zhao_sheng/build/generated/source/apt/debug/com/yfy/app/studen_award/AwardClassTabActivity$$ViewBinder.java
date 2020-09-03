// Generated code from Butter Knife. Do not modify!
package com.yfy.app.studen_award;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AwardClassTabActivity$$ViewBinder<T extends com.yfy.app.studen_award.AwardClassTabActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296388, "field 'xlist'");
    target.xlist = finder.castView(view, 2131296388, "field 'xlist'");
    view = finder.findRequiredView(source, 2131296366, "field 'clear_et'");
    target.clear_et = finder.castView(view, 2131296366, "field 'clear_et'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.xlist = null;
    target.clear_et = null;
  }
}
