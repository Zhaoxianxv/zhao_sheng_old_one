package com.yfy.base.activity;


import com.yfy.exafunction.FunctionProx;
import com.yfy.exafunction.WcfFunction;
import com.yfy.net.loading.interf.WcfTask;
import com.yfy.net.manager.WcfManager.OnWcfTaskListener;

public abstract class WcfActivity extends BaseActivity implements
		OnWcfTaskListener {

	private WcfFunction wcfFunction;

	@Override
	protected void initAddFunction(FunctionProx functionProx) {
		super.initAddFunction(functionProx);
		wcfFunction = new WcfFunction(this);
		functionProx.addFunction(wcfFunction);
	}

	public void execute(WcfTask wcfTask) {
		wcfFunction.execute(wcfTask);
	}
}
