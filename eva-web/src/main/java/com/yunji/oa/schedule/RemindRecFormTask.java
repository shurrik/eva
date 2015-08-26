package com.yunji.oa.schedule;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunji.oa.model.RecForm;
import com.yunji.oa.model.User;
import com.yunji.oa.service.IMessageService;
import com.yunji.oa.service.IRecFormService;
import com.yunji.oa.service.IUserService;
import com.yunji.oa.util.Constants;

@Service
public class RemindRecFormTask extends BaseTask {

	@Autowired
	private IMessageService messageService;
	@Autowired
	private IRecFormService recFormService;
	@Autowired
	private IUserService userService;

	public void execute() throws Exception {
		logInfo("RemindRecFormTask任务开始");
		List<RecForm> list = recFormService.queryRemind();
		for (RecForm recForm : list) {
			if (StringUtils.isNotBlank(recForm.getCreatorId())) {
				List<User> to = getRoleUser(recForm);
				for (User users: to)
				{
					if ( recForm.getPressHandle()==true) {
						User user=userService.findOne("id", users.getId());
						messageService.createSysMsg(user, getTitle(recForm),getContent(recForm),Constants.REMIND_REC_UNFINISHED_URL);
					}
				}
			}
		}
		logInfo("RemindRecFormTask任务结束");
	}

	private List<User> getRoleUser(RecForm recForm) {
		List<User> to = userService.findRoleUser();
		return to;
	}

	private String getTitle(RecForm recForm) {
		String title = "一条收文任务限办时间即将到期，请抓紧时间办理";
		return title;
	}

	private String getContent(RecForm recForm) {
		String content = "收文任务《" + recForm.getTitle() + "》限办时间即将到期，请抓紧时间办理";
		return content;
	}
}
