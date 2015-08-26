package com.yunji.oa.model;
import com.yunji.common.domain.BaseDomain;
import java.math.BigDecimal;
import java.util.Date;

public class DocForm extends BaseDomain{
	private String title; //标题
	private String sendDepId; //发文单位ID
	private String sendDep; //发文单位
	private String no; //发文编号
	private String content; //发文内容
	private String remark; //相关情况
	private String chargeManId; //负责人ID
	private String chargeMan; //负责人
	private String contractorId; //承办人ID
	private String contractor; //承办人
	private Integer year; //年份
	private Integer month; //月份
	private Integer quarter; //季度
	private String progress; //办理情况
	private String status; //状态
	private Date createDate; //创建日期
	private Date updateDate; //更新日期
	private Date publishDate; //发文日期

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSendDepId() {
		return sendDepId;
	}
	public void setSendDepId(String sendDepId) {
		this.sendDepId = sendDepId;
	}
	public String getSendDep() {
		return sendDep;
	}
	public void setSendDep(String sendDep) {
		this.sendDep = sendDep;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
}
