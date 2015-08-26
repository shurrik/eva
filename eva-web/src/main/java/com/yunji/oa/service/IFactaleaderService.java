
package com.yunji.oa.service;

import org.apache.ibatis.annotations.Param;

import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IFactaleaderDAO;
import com.yunji.oa.model.Factaleader;
public interface IFactaleaderService extends IBaseService<IFactaleaderDAO,Factaleader>,
IPageService<IFactaleaderDAO,Factaleader>{
	
	public int checkByname(@Param("factaleader") Factaleader factaleader);
	
}