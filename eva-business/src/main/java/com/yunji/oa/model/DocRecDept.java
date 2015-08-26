package com.yunji.oa.model;
import com.yunji.common.domain.BaseDomain;
import java.math.BigDecimal;
import java.util.Date;

public class DocRecDept extends BaseDomain{
	private String depId; //部门ID
	private String depName; //部门名称
	private String formId; //公文单ID
	private Boolean readFlag; //已阅
	private Date createDate; //创建日期
	private Date updateDate; //更新日期

	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public Boolean getReadFlag() {
		return readFlag;
	}
	public void setReadFlag(Boolean readFlag) {
		this.readFlag = readFlag;
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
