
package com.yunji.oa.service;
import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.ISendFormDAO;
import com.yunji.oa.model.SendForm;
public interface ISendFormService extends IBaseService<ISendFormDAO,SendForm>,IPageService<ISendFormDAO,SendForm>,IBackLogCallback{

}