
package com.yunji.oa.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunji.common.service.impl.AbstractPageService;
import com.yunji.oa.dao.IAttachmentDAO;
import com.yunji.oa.model.Attachment;
import com.yunji.oa.service.IAttachmentService;

@SuppressWarnings("unchecked")
@Service("AttachmentServiceImpl")

public class AttachmentServiceImpl extends AbstractPageService<IAttachmentDAO,Attachment> implements IAttachmentService {

	@Autowired
	private IAttachmentDAO attachmentDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IAttachmentDAO getDao() {
		return attachmentDAO;
	}
}
