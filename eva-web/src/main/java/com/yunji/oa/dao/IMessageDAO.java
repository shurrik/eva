
package com.yunji.oa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yunji.common.dao.IBaseDAO;
import com.yunji.oa.model.Message;

public interface IMessageDAO extends IBaseDAO<Message>{

	public List<Message> findNewMsgs(@Param("toId") String toId);
	
	public void readAll(@Param("toId") String toId);
}

