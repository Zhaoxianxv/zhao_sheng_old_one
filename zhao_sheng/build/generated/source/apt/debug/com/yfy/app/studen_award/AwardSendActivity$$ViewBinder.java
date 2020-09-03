// Generated code from Butter Knife. Do not modify!
package com.yfy.app.studen_award;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AwardSendActivity$$ViewBinder<T extends com.yfy.app.studen_award.AwardSendActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296384, "field 'term_Chioce' and method 'setChoiceTerm'");
    target.term_Chioce = finder.castView(view, 2131296384, "field 'term_Chioce'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChoiceTerm();
        }
      });
    view = finder.findRequiredView(source, 2131296385, "field 'type_Chioce' and method 'setChoiceType'");
    target.type_Chioce = finder.castView(view, 2131296385, "field 'type_Chioce'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setChoiceType();
        }
      });
    view = finder.findRequiredView(source, 2131296348, "field 'add_mult'");
    target.add_mult = finder.castView(view, 2131296348, "field 'add_mult'");
    view = finder.findRequiredView(source, 2131296367, "field 'content_et'");
    target.content_et = finder.castView(view, 2131296367, "field 'content_et'");
    view = finder.findRequiredView(source, 2131296382, "field 'layout'");
    target.layout = finder.castView(view, 2131296382, "field 'layout'");
    view = finder.findRequiredView(source, 2131297349, "field 'radioGroup'");
    target.radioGroup = finder.castView(view, 2131297349, "field 'radioGroup'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.term_Chioce = null;
    target.type_Chioce = null;
    target.add_mult = null;
    target.content_et = null;
    target.layout = null;
    target.radioGroup = null;
  }
}
