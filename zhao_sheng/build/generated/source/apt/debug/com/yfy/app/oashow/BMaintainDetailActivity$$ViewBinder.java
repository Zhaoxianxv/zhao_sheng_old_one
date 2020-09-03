// Generated code from Butter Knife. Do not modify!
package com.yfy.app.oashow;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class BMaintainDetailActivity$$ViewBinder<T extends com.yfy.app.oashow.BMaintainDetailActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297298, "field 'item_flow'");
    target.item_flow = finder.castView(view, 2131297298, "field 'item_flow'");
    view = finder.findRequiredView(source, 2131297295, "field 'bottom_button'");
    target.bottom_button = finder.castView(view, 2131297295, "field 'bottom_button'");
    view = finder.findRequiredView(source, 2131297296, "field 'user_head'");
    target.user_head = finder.castView(view, 2131297296, "field 'user_head'");
    view = finder.findRequiredView(source, 2131297304, "field 'user_name'");
    target.user_name = finder.castView(view, 2131297304, "field 'user_name'");
    view = finder.findRequiredView(source, 2131297306, "field 'user_state'");
    target.user_state = finder.castView(view, 2131297306, "field 'user_state'");
    view = finder.findRequiredView(source, 2131297307, "field 'user_tell'");
    target.user_tell = finder.castView(view, 2131297307, "field 'user_tell'");
    view = finder.findRequiredView(source, 2131297308, "field 'detail_tile'");
    target.detail_tile = finder.castView(view, 2131297308, "field 'detail_tile'");
    view = finder.findRequiredView(source, 2131297309, "field 'top_flow'");
    target.top_flow = finder.castView(view, 2131297309, "field 'top_flow'");
    view = finder.findRequiredView(source, 2131297310, "field 'top_multi'");
    target.top_multi = finder.castView(view, 2131297310, "field 'top_multi'");
    view = finder.findRequiredView(source, 2131297311, "field 'top_tag'");
    target.top_tag = finder.castView(view, 2131297311, "field 'top_tag'");
    view = finder.findRequiredView(source, 2131297305, "field 'scrool_layout'");
    target.scrool_layout = finder.castView(view, 2131297305, "field 'scrool_layout'");
    view = finder.findRequiredView(source, 2131297294, "field 'bgtext_view' and method 'setBg_Txt'");
    target.bgtext_view = finder.castView(view, 2131297294, "field 'bgtext_view'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setBg_Txt();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.item_flow = null;
    target.bottom_button = null;
    target.user_head = null;
    target.user_name = null;
    target.user_state = null;
    target.user_tell = null;
    target.detail_tile = null;
    target.top_flow = null;
    target.top_multi = null;
    target.top_tag = null;
    target.scrool_layout = null;
    target.bgtext_view = null;
  }
}
