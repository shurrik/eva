package com.yunji.oa.service;

import com.yunji.oa.model.BackLog;
import com.yunji.oa.model.Flow;

public interface IBackLogCallback {

	public void callback(BackLog backLog,Flow flow);
}
