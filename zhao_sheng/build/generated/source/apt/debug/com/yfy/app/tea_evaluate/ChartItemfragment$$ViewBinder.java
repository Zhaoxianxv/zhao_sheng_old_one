// Generated code from Butter Knife. Do not modify!
package com.yfy.app.tea_evaluate;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ChartItemfragment$$ViewBinder<T extends com.yfy.app.tea_evaluate.ChartItemfragment> extends com.yfy.base.fragment.BaseFragment$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131297125, "field 'flowLayout'");
    target.flowLayout = finder.castView(view, 2131297125, "field 'flowLayout'");
    view = finder.findRequiredView(source, 2131297002, "field 'chart'");
    target.chart = finder.castView(view, 2131297002, "field 'chart'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.flowLayout = null;
    target.chart = null;
  }
}
