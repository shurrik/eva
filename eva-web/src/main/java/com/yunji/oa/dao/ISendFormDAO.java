
package com.yunji.oa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yunji.common.dao.IBaseDAO;
import com.yunji.oa.model.SendForm;

public interface ISendFormDAO extends IBaseDAO<SendForm>{

	public List<SendForm> queryRecordPage(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows);	
}
