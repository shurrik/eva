
package com.yunji.oa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yunji.common.dao.IBaseDAO;
import com.yunji.oa.model.Flow;
import com.yunji.oa.model.FlowStep;

public interface IFlowDAO extends IBaseDAO<Flow>{

	public void updateTableStatus(@Param("tableName") String tableName, @Param("status") String status, @Param("id") String id);
}
