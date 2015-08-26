
package com.yunji.oa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yunji.common.dao.IBaseDAO;
import com.yunji.oa.model.RecForm;

public interface IRecFormDAO extends IBaseDAO<RecForm>{

	public List<RecForm> queryUnfinished(@Param("map") Map condition);
	public List<RecForm> queryRemind(@Param("map") Map condition);
	public List<RecForm> findselect(@Param("recForm") RecForm recForm);
	public List<RecForm> queryExport(@Param("condition") Map<String, Object> condition);
	public List<RecForm> queryByCreateDate(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows);
	public void cancelDeadline(@Param("id")String id);
	public List<RecForm> findnoSearch(@Param("no")String no);
}
