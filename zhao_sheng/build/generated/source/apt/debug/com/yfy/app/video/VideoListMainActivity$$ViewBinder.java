// Generated code from Butter Knife. Do not modify!
package com.yfy.app.video;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class VideoListMainActivity$$ViewBinder<T extends com.yfy.app.video.VideoListMainActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297717, "field 'xList'");
    target.xList = finder.castView(view, 2131297717, "field 'xList'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.xList = null;
  }
}
