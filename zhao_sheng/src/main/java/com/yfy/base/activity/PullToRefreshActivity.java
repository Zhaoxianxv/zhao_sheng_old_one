package com.yfy.base.activity;


import com.yfy.exafunction.PullToRefreshFunction;
import com.yfy.exafunction.PullToRefreshFunction.PullToRefreshInfo;

public abstract class PullToRefreshActivity extends WcfActivity {

	private PullToRefreshFunction pullToRefreshFunction;

	@Override
	public void onStart() {
		super.onStart();
		if (pullToRefreshFunction == null) {
			pullToRefreshFunction = new PullToRefreshFunction(this,
					getPullToRefreshInfo());
			functionProx.addFunction(pullToRefreshFunction);
		}
		pullToRefreshFunction.onStart();
	}

	protected abstract PullToRefreshInfo getPullToRefreshInfo();

	public void updateRefreshTime() {
		pullToRefreshFunction.saveLastRefreshTime(System.currentTimeMillis());
		pullToRefreshFunction.initRefreshTime();
	}
}
