
package com.yunji.oa.service;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IFlowAdviceDAO;
import com.yunji.oa.model.FlowAdvice;
import com.yunji.oa.model.User;
public interface IFlowAdviceService extends IBaseService<IFlowAdviceDAO,FlowAdvice>,IPageService<IFlowAdviceDAO,FlowAdvice>{

	
	public void addAdvice(String docId,User user,String status,String advice);
	
	public List<FlowAdvice> findLimit(String property, Object value,@Param("orderBy") String orderBy, @Param("sortBy") String sortBy,@Param("limit") Integer limit);
}