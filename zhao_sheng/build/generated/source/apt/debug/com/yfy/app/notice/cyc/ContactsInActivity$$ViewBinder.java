// Generated code from Butter Knife. Do not modify!
package com.yfy.app.notice.cyc;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ContactsInActivity$$ViewBinder<T extends com.yfy.app.notice.cyc.ContactsInActivity> extends com.yfy.base.activity.BaseActivity$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297157, "field 'teacher_num'");
    target.teacher_num = finder.castView(view, 2131297157, "field 'teacher_num'");
    view = finder.findRequiredView(source, 2131297156, "field 'student_num'");
    target.student_num = finder.castView(view, 2131297156, "field 'student_num'");
    view = finder.findRequiredView(source, 2131297160, "method 'setteacher'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setteacher();
        }
      });
    view = finder.findRequiredView(source, 2131297159, "method 'setstudent'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setstudent();
        }
      });
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.teacher_num = null;
    target.student_num = null;
  }
}
