// Generated code from Butter Knife. Do not modify!
package com.yfy.app.goods;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class GoodsAddActivity$$ViewBinder<T extends com.yfy.app.goods.GoodsAddActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296850, "field 'type' and method 'setChioceType'");
    target.type = finder.castView(view, 2131296850, "field 'type'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChioceType();
        }
      });
    view = finder.findRequiredView(source, 2131296842, "field 'contacts' and method 'setChioceContacts'");
    target.contacts = finder.castView(view, 2131296842, "field 'contacts'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChioceContacts();
        }
      });
    view = finder.findRequiredView(source, 2131296888, "field 'num_layout'");
    target.num_layout = finder.castView(view, 2131296888, "field 'num_layout'");
    view = finder.findRequiredView(source, 2131296853, "field 'contact_layout'");
    target.contact_layout = finder.castView(view, 2131296853, "field 'contact_layout'");
    view = finder.findRequiredView(source, 2131296893, "field 'type_layout'");
    target.type_layout = finder.castView(view, 2131296893, "field 'type_layout'");
    view = finder.findRequiredView(source, 2131296855, "field 'content_layout'");
    target.content_layout = finder.castView(view, 2131296855, "field 'content_layout'");
    view = finder.findRequiredView(source, 2131296849, "field 'num_edit'");
    target.num_edit = finder.castView(view, 2131296849, "field 'num_edit'");
    view = finder.findRequiredView(source, 2131296854, "field 'content_edit'");
    target.content_edit = finder.castView(view, 2131296854, "field 'content_edit'");
    view = finder.findRequiredView(source, 2131296848, "field 'add_mult'");
    target.add_mult = finder.castView(view, 2131296848, "field 'add_mult'");
    view = finder.findRequiredView(source, 2131296847, "field 'box'");
    target.box = finder.castView(view, 2131296847, "field 'box'");
    view = finder.findRequiredView(source, 2131296846, "method 'change'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.change();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.type = null;
    target.contacts = null;
    target.num_layout = null;
    target.contact_layout = null;
    target.type_layout = null;
    target.content_layout = null;
    target.num_edit = null;
    target.content_edit = null;
    target.add_mult = null;
    target.box = null;
  }
}
