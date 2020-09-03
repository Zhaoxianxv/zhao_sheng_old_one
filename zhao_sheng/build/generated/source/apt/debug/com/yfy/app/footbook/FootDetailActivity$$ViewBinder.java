// Generated code from Butter Knife. Do not modify!
package com.yfy.app.footbook;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class FootDetailActivity$$ViewBinder<T extends com.yfy.app.footbook.FootDetailActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296820, "field 'image'");
    target.image = finder.castView(view, 2131296820, "field 'image'");
    view = finder.findRequiredView(source, 2131296819, "field 'text_conten'");
    target.text_conten = finder.castView(view, 2131296819, "field 'text_conten'");
    view = finder.findRequiredView(source, 2131296816, "field 'reting_icon' and method 'setImage'");
    target.reting_icon = finder.castView(view, 2131296816, "field 'reting_icon'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setImage();
        }
      });
    view = finder.findRequiredView(source, 2131296815, "field 'reting_button'");
    target.reting_button = finder.castView(view, 2131296815, "field 'reting_button'");
    view = finder.findRequiredView(source, 2131296817, "method 'setAddSuggest'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setAddSuggest();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.image = null;
    target.text_conten = null;
    target.reting_icon = null;
    target.reting_button = null;
  }
}
