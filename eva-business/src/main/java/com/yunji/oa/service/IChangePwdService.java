package com.yunji.oa.service;

import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IChangePwdDAO;
import com.yunji.oa.model.UserMsgCount;

public interface IChangePwdService extends  IBaseService<IChangePwdDAO,UserMsgCount>,IPageService<IChangePwdDAO,UserMsgCount>{


}