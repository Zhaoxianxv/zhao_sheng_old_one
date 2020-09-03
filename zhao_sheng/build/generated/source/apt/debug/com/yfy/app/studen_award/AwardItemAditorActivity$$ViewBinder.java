// Generated code from Butter Knife. Do not modify!
package com.yfy.app.studen_award;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AwardItemAditorActivity$$ViewBinder<T extends com.yfy.app.studen_award.AwardItemAditorActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296351, "field 'name'");
    target.name = finder.castView(view, 2131296351, "field 'name'");
    view = finder.findRequiredView(source, 2131296350, "field 'grade'");
    target.grade = finder.castView(view, 2131296350, "field 'grade'");
    view = finder.findRequiredView(source, 2131296349, "field 'content'");
    target.content = finder.castView(view, 2131296349, "field 'content'");
    view = finder.findRequiredView(source, 2131296355, "field 'time'");
    target.time = finder.castView(view, 2131296355, "field 'time'");
    view = finder.findRequiredView(source, 2131296356, "field 'type'");
    target.type = finder.castView(view, 2131296356, "field 'type'");
    view = finder.findRequiredView(source, 2131296354, "field 'rating'");
    target.rating = finder.castView(view, 2131296354, "field 'rating'");
    view = finder.findRequiredView(source, 2131296373, "field 'gallery'");
    target.gallery = finder.castView(view, 2131296373, "field 'gallery'");
    view = finder.findRequiredView(source, 2131296353, "method 'setOk'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOk();
        }
      });
    view = finder.findRequiredView(source, 2131296352, "method 'setNo'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setNo();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.name = null;
    target.grade = null;
    target.content = null;
    target.time = null;
    target.type = null;
    target.rating = null;
    target.gallery = null;
  }
}
