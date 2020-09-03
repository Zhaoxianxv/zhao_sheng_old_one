// Generated code from Butter Knife. Do not modify!
package com.yfy.app.album;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AlbumOneActivity$$ViewBinder<T extends com.yfy.app.album.AlbumOneActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297242, "field 'pic_gridview'");
    target.pic_gridview = finder.castView(view, 2131297242, "field 'pic_gridview'");
    view = finder.findRequiredView(source, 2131297243, "field 'pic_total_size'");
    target.pic_total_size = finder.castView(view, 2131297243, "field 'pic_total_size'");
    view = finder.findRequiredView(source, 2131297182, "field 'ok_tv' and method 'setok'");
    target.ok_tv = finder.castView(view, 2131297182, "field 'ok_tv'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setok();
        }
      });
    view = finder.findRequiredView(source, 2131296303, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131296303, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131296503, "method 'setclear'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setclear();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.pic_gridview = null;
    target.pic_total_size = null;
    target.ok_tv = null;
    target.toolbar = null;
  }
}
