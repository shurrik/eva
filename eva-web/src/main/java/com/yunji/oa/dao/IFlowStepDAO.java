
package com.yunji.oa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yunji.common.dao.IBaseDAO;
import com.yunji.oa.model.FlowStep;

public interface IFlowStepDAO extends IBaseDAO<FlowStep>{

	public List<FlowStep> findStepsByBeforeStatus(@Param("flowId") String flowId, @Param("userId") String userId, @Param("beforeStatus") String beforeStatus);
}
