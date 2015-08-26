package com.yunji.oa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunji.oa.util.Constants;

@SuppressWarnings("unchecked")
@Service("BackLogCallbackStrategy")
public class BackLogCallbackStrategy {

    @Autowired
    private IRecFormService recFormService;
    @Autowired
    private ISendFormService sendFormService;
    
	public IBackLogCallback getCallBack(String flowName)
	{
		IBackLogCallback callback = null;
		if(flowName.equals(Constants.FLOW_NAME_REC))
		{
			callback = (IBackLogCallback) recFormService;
		}
		else
		{
			callback = (IBackLogCallback) sendFormService;
		}
		return callback;
	}
}
