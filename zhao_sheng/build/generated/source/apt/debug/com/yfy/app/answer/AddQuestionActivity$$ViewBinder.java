// Generated code from Butter Knife. Do not modify!
package com.yfy.app.answer;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AddQuestionActivity$$ViewBinder<T extends com.yfy.app.answer.AddQuestionActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297347, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131297347, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131297345, "field 'add_question'");
    target.add_question = finder.castView(view, 2131297345, "field 'add_question'");
    view = finder.findRequiredView(source, 2131297346, "field 'add_pic' and method 'setAddPic'");
    target.add_pic = finder.castView(view, 2131297346, "field 'add_pic'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setAddPic();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.toolbar = null;
    target.add_question = null;
    target.add_pic = null;
  }
}
