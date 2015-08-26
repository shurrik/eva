
package com.yunji.oa.service;
import java.util.Map;

import com.yunji.common.domain.view.BizData4Page;
import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.ISendFormDAO;
import com.yunji.oa.model.SendForm;
public interface ISendFormService extends IBaseService<ISendFormDAO,SendForm>,IPageService<ISendFormDAO,SendForm>,IBackLogCallback{

	public BizData4Page queryRecordPage(Map<String, Object> conditions, int curPage, int offset, int rows);
}