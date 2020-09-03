// Generated code from Butter Knife. Do not modify!
package com.yfy.app.vote;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class VoteDetailActicity$$ViewBinder<T extends com.yfy.app.vote.VoteDetailActicity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296962, "field 'layout'");
    target.layout = finder.castView(view, 2131296962, "field 'layout'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.layout = null;
  }
}
