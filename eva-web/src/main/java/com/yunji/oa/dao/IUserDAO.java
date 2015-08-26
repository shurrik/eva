
package com.yunji.oa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yunji.common.dao.IBaseDAO;
import com.yunji.oa.model.User;

public interface IUserDAO extends IBaseDAO<User>{

	public	List<User> findRoleUser();

}
