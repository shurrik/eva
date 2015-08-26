
package com.yunji.oa.service;
import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IDictionaryDAO;
import com.yunji.oa.model.Dictionary;
public interface IDictionaryService extends IBaseService<IDictionaryDAO,Dictionary>,IPageService<IDictionaryDAO,Dictionary>{

}