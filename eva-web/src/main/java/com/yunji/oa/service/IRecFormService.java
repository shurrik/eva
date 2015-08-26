
package com.yunji.oa.service;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yunji.common.domain.view.BizData4Page;
import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IRecFormDAO;
import com.yunji.oa.model.RecForm;
public interface IRecFormService extends IBaseService<IRecFormDAO,RecForm>,IPageService<IRecFormDAO,RecForm>,IBackLogCallback{

	public List<RecForm> queryUnfinished(@Param("map") Map condition);
	public List<RecForm> queryRemind();
	public List<RecForm> queryExport(@Param("condition") Map<String, Object> condition);
	public BizData4Page queryByCreateDate(Map<String, Object> conditions, int curPage, int offset, int rows);
	public void cancelDeadline(String id);
	public List<RecForm> findnoSearch(String no);
}