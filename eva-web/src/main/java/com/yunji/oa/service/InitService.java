package com.yunji.oa.service;

import java.util.List;
import java.util.Map;

import com.yunji.oa.model.Dictionary;
import com.yunji.oa.model.Factaleader;
import com.yunji.oa.model.Processunit;

public interface InitService {
	/**
	 * 模板数据字典
	 * @return
	 */
	public Map<String, Object> getcConditions();
	/**
	 * 呈文领导关键字集合
	 * @return
	 */
	public List<Factaleader> leaderlist();
	/**
	 * 办文单位关键字集合
	 * @return
	 */
    public List<Processunit> unitlist();
}
