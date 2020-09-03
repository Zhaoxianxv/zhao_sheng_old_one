// Generated code from Butter Knife. Do not modify!
package com.yfy.app;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class NewsDetailActivity$$ViewBinder<T extends com.yfy.app.NewsDetailActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296508, "method 'setCollect_frala'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setCollect_frala();
        }
      });
    view = finder.findRequiredView(source, 2131297741, "method 'setWrite_comment_iv'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setWrite_comment_iv();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

  }
}
