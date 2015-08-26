
package com.yunji.oa.service;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IResourceDAO;
import com.yunji.oa.model.Resource;
public interface IResourceService extends IBaseService<IResourceDAO,Resource>,IPageService<IResourceDAO,Resource>{

	public List<Resource> findMenuByUserIdAndPid(@Param("userId") String userId, @Param("pid") String pid);
}