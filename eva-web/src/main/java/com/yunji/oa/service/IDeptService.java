
package com.yunji.oa.service;
import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IDeptDAO;
import com.yunji.oa.model.Dept;
public interface IDeptService extends IBaseService<IDeptDAO,Dept>,IPageService<IDeptDAO,Dept>{

}