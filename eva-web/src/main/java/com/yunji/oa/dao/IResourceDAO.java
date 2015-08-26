
package com.yunji.oa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yunji.common.dao.IBaseDAO;
import com.yunji.oa.model.Resource;

public interface IResourceDAO extends IBaseDAO<Resource>{
	public List<Resource> findMenuByUserIdAndPid(@Param("userId") String userId, @Param("pid") String pid);
}
