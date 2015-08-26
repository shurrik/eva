
package com.yunji.oa.service;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IFlowStepDAO;
import com.yunji.oa.model.FlowStep;
public interface IFlowStepService extends IBaseService<IFlowStepDAO,FlowStep>,IPageService<IFlowStepDAO,FlowStep>{

	public List<FlowStep> findListByBeforeStatus(String flowId,String beforeStatus);
	
	public List<FlowStep> findStepsByBeforeStatus(@Param("flowId") String flowId, @Param("userId") String userId, @Param("beforeStatus") String beforeStatus);

}