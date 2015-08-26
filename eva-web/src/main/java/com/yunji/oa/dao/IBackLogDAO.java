
package com.yunji.oa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yunji.common.dao.IBaseDAO;
import com.yunji.oa.model.BackLog;

public interface IBackLogDAO extends IBaseDAO<BackLog>{

	public List<BackLog> queryFlowPage(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows);
	
	public int countFlow(@Param("condition") Map<String, Object> condition);
}
