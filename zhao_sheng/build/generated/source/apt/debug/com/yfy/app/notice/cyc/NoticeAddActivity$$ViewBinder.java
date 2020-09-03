// Generated code from Butter Knife. Do not modify!
package com.yfy.app.notice.cyc;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class NoticeAddActivity$$ViewBinder<T extends com.yfy.app.notice.cyc.NoticeAddActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296703, "field 'title_et'");
    target.title_et = finder.castView(view, 2131296703, "field 'title_et'");
    view = finder.findRequiredView(source, 2131296696, "field 'content_et'");
    target.content_et = finder.castView(view, 2131296696, "field 'content_et'");
    view = finder.findRequiredView(source, 2131296701, "field 'selected_num'");
    target.selected_num = finder.castView(view, 2131296701, "field 'selected_num'");
    view = finder.findRequiredView(source, 2131297143, "field 'add_mult'");
    target.add_mult = finder.castView(view, 2131297143, "field 'add_mult'");
    view = finder.findRequiredView(source, 2131296695, "method 'setchooes'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setchooes();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.title_et = null;
    target.content_et = null;
    target.selected_num = null;
    target.add_mult = null;
  }
}
