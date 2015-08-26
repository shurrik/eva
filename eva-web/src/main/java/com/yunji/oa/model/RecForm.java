package com.yunji.oa.model;
import java.util.Date;

import com.yunji.common.domain.BaseDomain;

public class RecForm extends BaseDomain{
	private String depId; //来文单位ID
	private String depName; //来文单位
	private String no; //来文编号
	private String docNo; //收文编号
	private String title; //来文标题
	private String content; //来文内容
	private String remark; //相关情况
	private String chargeManId; //负责人ID
	private String chargeMan; //负责人
	private String contractorId; //承办人ID
	private String contractor; //承办人
	private String draftAdvice; //拟办意见
	private String submitAdvice; //呈办/阅意见
	private Integer year; //年份
	private Integer month; //月份
	private Integer quarter; //季度
	private String progress; //办理情况
	private String status; //状态
	private String secretClass; //密级
	private Date deadline; //时限
	private String receiverId; //收文人ID
	private String receiver; //收文人
	private String recType; //收文类型(阅文/办文)
	private Date createDate; //创建日期
	private Date updateDate; //更新日期
	private String creatorId; //创建人ID
	private Boolean pressHandle; //是否督办
	private Integer recCount; //来文份数
	private Boolean logFlag; //已存待办
	private Date doTime; //办文时间
	private String doStatus; //办文状态
	private String reportLeader; //呈文领导
	private String doDepartment; //办文单位

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
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getChargeManId() {
		return chargeManId;
	}
	public void setChargeManId(String chargeManId) {
		this.chargeManId = chargeManId;
	}
	public String getChargeMan() {
		return chargeMan;
	}
	public void setChargeMan(String chargeMan) {
		this.chargeMan = chargeMan;
	}
	public String getContractorId() {
		return contractorId;
	}
	public void setContractorId(String contractorId) {
		this.contractorId = contractorId;
	}
	public String getContractor() {
		return contractor;
	}
	public void setContractor(String contractor) {
		this.contractor = contractor;
	}
	public String getDraftAdvice() {
		return draftAdvice;
	}
	public void setDraftAdvice(String draftAdvice) {
		this.draftAdvice = draftAdvice;
	}
	public String getSubmitAdvice() {
		return submitAdvice;
	}
	public void setSubmitAdvice(String submitAdvice) {
		this.submitAdvice = submitAdvice;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getQuarter() {
		return quarter;
	}
	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSecretClass() {
		return secretClass;
	}
	public void setSecretClass(String secretClass) {
		this.secretClass = secretClass;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getRecType() {
		return recType;
	}
	public void setRecType(String recType) {
		this.recType = recType;
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
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public Boolean getPressHandle() {
		return pressHandle;
	}
	public void setPressHandle(Boolean pressHandle) {
		this.pressHandle = pressHandle;
	}
	public Integer getRecCount() {
		return recCount;
	}
	public void setRecCount(Integer recCount) {
		this.recCount = recCount;
	}
	public Boolean getLogFlag() {
		return logFlag;
	}
	public void setLogFlag(Boolean logFlag) {
		this.logFlag = logFlag;
	}
	public Date getDoTime() {
		return doTime;
	}
	public void setDoTime(Date doTime) {
		this.doTime = doTime;
	}
	public String getDoStatus() {
		return doStatus;
	}
	public void setDoStatus(String doStatus) {
		this.doStatus = doStatus;
	}
	public String getReportLeader() {
		return reportLeader;
	}
	public void setReportLeader(String reportLeader) {
		this.reportLeader = reportLeader;
	}
	public String getDoDepartment() {
		return doDepartment;
	}
	public void setDoDepartment(String doDepartment) {
		this.doDepartment = doDepartment;
	}
	
}
