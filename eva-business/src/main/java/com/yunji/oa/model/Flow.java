package com.yunji.oa.model;
import java.util.Date;

import com.yunji.common.domain.BaseDomain;

public class Flow extends BaseDomain{
	private String name; //流程名称
	private String tableName; //数据表
	private String startStatus; //开始状态
	private String endStatus; //结束状态
	private String modifyStatus; //修改状态
	private Boolean modifyFlag; //可以修改
	private Date createDate; //创建日期
	private Date updateDate; //更新日期
	private String nameSpace; //命名空间

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getStartStatus() {
		return startStatus;
	}
	public void setStartStatus(String startStatus) {
		this.startStatus = startStatus;
	}
	public Boolean getModifyFlag() {
		return modifyFlag;
	}
	public void setModifyFlag(Boolean modifyFlag) {
		this.modifyFlag = modifyFlag;
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
	public String getEndStatus() {
		return endStatus;
	}
	public void setEndStatus(String endStatus) {
		this.endStatus = endStatus;
	}
	public String getModifyStatus() {
		return modifyStatus;
	}
	public void setModifyStatus(String modifyStatus) {
		this.modifyStatus = modifyStatus;
	}
	public String getNameSpace() {
		return nameSpace;
	}
	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}
}
