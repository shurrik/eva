
package com.yunji.oa.service;
import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IFlowDAO;
import com.yunji.oa.model.Flow;
public interface IFlowService extends IBaseService<IFlowDAO,Flow>,IPageService<IFlowDAO,Flow>{

	public void updateTableStatus(Flow flow,String id,String status);
}