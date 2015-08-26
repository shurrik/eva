
package com.yunji.oa.service;
import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IRoleDAO;
import com.yunji.oa.model.Role;
public interface IRoleService extends IBaseService<IRoleDAO,Role>,IPageService<IRoleDAO,Role>{

}