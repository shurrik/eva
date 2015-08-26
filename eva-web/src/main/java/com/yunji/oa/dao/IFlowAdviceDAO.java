
package com.yunji.oa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yunji.common.dao.IBaseDAO;
import com.yunji.oa.model.FlowAdvice;

public interface IFlowAdviceDAO extends IBaseDAO<FlowAdvice>{

	public List<FlowAdvice> findLimit(@Param("property")String property, @Param("value")Object value,@Param("orderBy") String orderBy, @Param("sortBy") String sortBy,@Param("limit") Integer limit);
}
