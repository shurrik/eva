
package com.yunji.oa.service;
import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IDocFormDAO;
import com.yunji.oa.model.DocForm;
public interface IDocFormService extends IBaseService<IDocFormDAO,DocForm>,IPageService<IDocFormDAO,DocForm>{

}