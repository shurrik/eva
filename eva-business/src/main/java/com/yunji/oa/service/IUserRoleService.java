
package com.yunji.oa.service;
import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IUserRoleDAO;
import com.yunji.oa.model.UserRole;
public interface IUserRoleService extends IBaseService<IUserRoleDAO,UserRole>,IPageService<IUserRoleDAO,UserRole>{

}