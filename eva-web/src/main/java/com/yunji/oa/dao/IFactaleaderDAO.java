
package com.yunji.oa.dao;


import org.apache.ibatis.annotations.Param;

import com.yunji.common.dao.IBaseDAO;
import com.yunji.oa.model.Factaleader;

public interface IFactaleaderDAO extends IBaseDAO<Factaleader>{

	public int checkByname(@Param("factaleader") Factaleader factaleader);

}
