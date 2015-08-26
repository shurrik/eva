
package com.yunji.oa.service;
import com.yunji.common.service.IBaseService;
import com.yunji.common.service.IPageService;
import com.yunji.oa.dao.IAttachmentDAO;
import com.yunji.oa.model.Attachment;
public interface IAttachmentService extends IBaseService<IAttachmentDAO,Attachment>,IPageService<IAttachmentDAO,Attachment>{

}