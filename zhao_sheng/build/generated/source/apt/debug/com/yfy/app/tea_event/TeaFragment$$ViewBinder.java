// Generated code from Butter Knife. Do not modify!
package com.yfy.app.tea_event;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class TeaFragment$$ViewBinder<T extends com.yfy.app.tea_event.TeaFragment> extends com.yfy.base.fragment.BaseFragment$$ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    super.bind(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131296498, "field 'mRecyclerView'");
    target.mRecyclerView = finder.castView(view, 2131296498, "field 'mRecyclerView'");
    view = finder.findRequiredView(source, 2131296499, "field 'swip'");
    target.swip = finder.castView(view, 2131296499, "field 'swip'");
    view = finder.findRequiredView(source, 2131297293, "field 'del'");
    target.del = finder.castView(view, 2131297293, "field 'del'");
  }

  @Override public void unbind(T target) {
    super.unbind(target);

    target.mRecyclerView = null;
    target.swip = null;
    target.del = null;
  }
}
