package com.yunji.oa.model;
import com.yunji.common.domain.BaseDomain;
import java.math.BigDecimal;
import java.util.Date;

public class SendForm extends BaseDomain{
	private String title; //标题
	private String no; //发文编号
	private String draftDepId; //拟文单位ID
	private String draftDep; //拟文单位
	private String draftorId; //拟文人ID
	private String draftorName; //拟文人
	private String mainDepId; //发送单位ID
	private String mainDep; //发送单位
	private String subDepId; //抄送单位ID
	private String subDep; //抄送单位
	private Integer printCount; //打印份数
	private String secretClass; //密级
	private String urgentClass; //紧急程度
	private Integer year; //年份
	private Integer month; //月份
	private Integer quarter; //季度
	private String status; //状态
	private Date createDate; //创建日期
	private Date updateDate; //更新日期
	private String comment; //备注
	private String type; //类型
	private String content; //发文内容
	private String remark; //相关情况
	private String chargeManId; //负责人ID
	private String chargeMan; //负责人
	private String contractorId; //承办人ID
	private String contractor; //承办人
	private String draftAdvice; //拟办意见
	private String submitAdvice; //呈办/阅意见
	private Date deadline; //期限
	private String docLegality; //规范性文件合法性检查
	private String attachment; //附件
	private String confidentialReview; //机要室复核
	private String leadInstructions; //厅领导批示
	private String signUnit; //会签单位
	private String issuerInstructions; //签发人批示
	private String creatorId; //创建人ID
	private Boolean logFlag; //已存待办
	private String nuclearDraft; //处室核稿
	private String officeNuclear; //办公室核稿
	private String mobile; //联系电话
	private String open; //公开情况

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getDraftDepId() {
		return draftDepId;
	}
	public void setDraftDepId(String draftDepId) {
		this.draftDepId = draftDepId;
	}
	public String getDraftDep() {
		return draftDep;
	}
	public void setDraftDep(String draftDep) {
		this.draftDep = draftDep;
	}
	public String getDraftorId() {
		return draftorId;
	}
	public void setDraftorId(String draftorId) {
		this.draftorId = draftorId;
	}
	public String getDraftorName() {
		return draftorName;
	}
	public void setDraftorName(String draftorName) {
		this.draftorName = draftorName;
	}
	public String getMainDepId() {
		return mainDepId;
	}
	public void setMainDepId(String mainDepId) {
		this.mainDepId = mainDepId;
	}
	public String getMainDep() {
		return mainDep;
	}
	public void setMainDep(String mainDep) {
		this.mainDep = mainDep;
	}
	public String getSubDepId() {
		return subDepId;
	}
	public void setSubDepId(String subDepId) {
		this.subDepId = subDepId;
	}
	public String getSubDep() {
		return subDep;
	}
	public void setSubDep(String subDep) {
		this.subDep = subDep;
	}
	public Integer getPrintCount() {
		return printCount;
	}
	public void setPrintCount(Integer printCount) {
		this.printCount = printCount;
	}
	public String getSecretClass() {
		return secretClass;
	}
	public void setSecretClass(String secretClass) {
		this.secretClass = secretClass;
	}
	public String getUrgentClass() {
		return urgentClass;
	}
	public void setUrgentClass(String urgentClass) {
		this.urgentClass = urgentClass;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getDocLegality() {
		return docLegality;
	}
	public void setDocLegality(String docLegality) {
		this.docLegality = docLegality;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getConfidentialReview() {
		return confidentialReview;
	}
	public void setConfidentialReview(String confidentialReview) {
		this.confidentialReview = confidentialReview;
	}
	public String getLeadInstructions() {
		return leadInstructions;
	}
	public void setLeadInstructions(String leadInstructions) {
		this.leadInstructions = leadInstructions;
	}
	public String getSignUnit() {
		return signUnit;
	}
	public void setSignUnit(String signUnit) {
		this.signUnit = signUnit;
	}
	public String getIssuerInstructions() {
		return issuerInstructions;
	}
	public void setIssuerInstructions(String issuerInstructions) {
		this.issuerInstructions = issuerInstructions;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public Boolean getLogFlag() {
		return logFlag;
	}
	public void setLogFlag(Boolean logFlag) {
		this.logFlag = logFlag;
	}
	public String getNuclearDraft() {
		return nuclearDraft;
	}
	public void setNuclearDraft(String nuclearDraft) {
		this.nuclearDraft = nuclearDraft;
	}
	public String getOfficeNuclear() {
		return officeNuclear;
	}
	public void setOfficeNuclear(String officeNuclear) {
		this.officeNuclear = officeNuclear;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	
}
