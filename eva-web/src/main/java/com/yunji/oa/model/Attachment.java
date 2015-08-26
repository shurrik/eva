package com.yunji.oa.model;
import com.yunji.common.domain.BaseDomain;
import java.util.Date;

public class Attachment extends BaseDomain{
	private String attachType; //附件类型
	private String docId; //文档ID
	private String attachUrl; //附件地址
	private Date createDate; //创建日期
	private Date updateDate; //更新日期

	public String getAttachType() {
		return attachType;
	}
	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getAttachUrl() {
		return attachUrl;
	}
	public void setAttachUrl(String attachUrl) {
		this.attachUrl = attachUrl;
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
