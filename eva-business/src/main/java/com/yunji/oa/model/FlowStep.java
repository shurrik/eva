package com.yunji.oa.model;
import com.yunji.common.domain.BaseDomain;
import java.math.BigDecimal;
import java.util.Date;

public class FlowStep extends BaseDomain{
	private String flowId; //流程ID
	private String flowName; //流程名称
	private String name; //步骤名称
	private String beforeStatus; //处理前状态
	private String afterStatus; //处理后状态
	private Integer stepOrder; //步骤顺序
	private Date createDate; //创建日期
	private Date updateDate; //更新日期

	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getFlowName() {
		return flowName;
	}
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeforeStatus() {
		return beforeStatus;
	}
	public void setBeforeStatus(String beforeStatus) {
		this.beforeStatus = beforeStatus;
	}
	public String getAfterStatus() {
		return afterStatus;
	}
	public void setAfterStatus(String afterStatus) {
		this.afterStatus = afterStatus;
	}
	public Integer getStepOrder() {
		return stepOrder;
	}
	public void setStepOrder(Integer stepOrder) {
		this.stepOrder = stepOrder;
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
