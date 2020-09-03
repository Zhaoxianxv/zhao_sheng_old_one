// Generated code from Butter Knife. Do not modify!
package com.yfy.app.seal;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SealDetailNewActivity$$ViewBinder<T extends com.yfy.app.seal.SealDetailNewActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297426, "field 'top_flow'");
    target.top_flow = finder.castView(view, 2131297426, "field 'top_flow'");
    view = finder.findRequiredView(source, 2131297415, "field 'item_flow'");
    target.item_flow = finder.castView(view, 2131297415, "field 'item_flow'");
    view = finder.findRequiredView(source, 2131297414, "field 'user_head'");
    target.user_head = finder.castView(view, 2131297414, "field 'user_head'");
    view = finder.findRequiredView(source, 2131297423, "field 'user_name'");
    target.user_name = finder.castView(view, 2131297423, "field 'user_name'");
    view = finder.findRequiredView(source, 2131297424, "field 'item_state'");
    target.item_state = finder.castView(view, 2131297424, "field 'item_state'");
    view = finder.findRequiredView(source, 2131297425, "field 'user_tell'");
    target.user_tell = finder.castView(view, 2131297425, "field 'user_tell'");
    view = finder.findRequiredView(source, 2131297412, "field 'button' and method 'setDo_type'");
    target.button = finder.castView(view, 2131297412, "field 'button'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setDo_type();
        }
      });
    view = finder.findRequiredView(source, 2131297427, "field 'multi'");
    target.multi = finder.castView(view, 2131297427, "field 'multi'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.top_flow = null;
    target.item_flow = null;
    target.user_head = null;
    target.user_name = null;
    target.item_state = null;
    target.user_tell = null;
    target.button = null;
    target.multi = null;
  }
}
