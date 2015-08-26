package com.yunji.oa.model;
import com.yunji.common.domain.BaseDomain;
import java.math.BigDecimal;
import java.util.Date;

public class Dictionary extends BaseDomain{
	private String propertkey; //属性名称
	private String propertvalue; //属性值
	private Date createDate; //创建日期
	private Date updateDate; //更新日期

	public String getPropertkey() {
		return propertkey;
	}
	public void setPropertkey(String propertkey) {
		this.propertkey = propertkey;
	}
	public String getPropertvalue() {
		return propertvalue;
	}
	public void setPropertvalue(String propertvalue) {
		this.propertvalue = propertvalue;
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
