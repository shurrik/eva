
package com.yunji.oa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yunji.common.dao.IBaseDAO;
import com.yunji.oa.model.RecForm;

public interface IRecFormDAO extends IBaseDAO<RecForm>{

	public List<RecForm> queryUnfinished(@Param("map") Map condition);
	public List<RecForm> queryRemind(@Param("map") Map condition);
}
