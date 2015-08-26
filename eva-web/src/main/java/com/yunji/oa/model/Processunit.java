package com.yunji.oa.model;
import com.yunji.common.domain.BaseDomain;
import java.math.BigDecimal;
import java.util.Date;

public class Processunit extends BaseDomain{
	private String unitname; //单位名称
	private Date createDate; //创建日期
	private Date updateDate; //更新日期

	public String getUnitname() {
		return unitname;
	}
	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
