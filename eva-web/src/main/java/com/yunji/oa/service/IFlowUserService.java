
package com.yunji.oa.service;
import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IFlowUserDAO;
import com.yunji.oa.model.FlowUser;
public interface IFlowUserService extends IBaseService<IFlowUserDAO,FlowUser>,IPageService<IFlowUserDAO,FlowUser>{

}