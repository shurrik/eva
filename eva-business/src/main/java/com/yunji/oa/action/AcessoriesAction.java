package com.yunji.oa.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunji.common.domain.view.BizData4Page;
import com.yunji.oa.model.Acessories;
import com.yunji.oa.model.OpLog;
import com.yunji.oa.model.User;
import com.yunji.oa.service.IAcessoriesService;
import com.yunji.oa.service.IOpLogService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.IdGenerator;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.PageParam;
import com.yunji.oa.util.myProgressListener;

@Controller
public class AcessoriesAction extends
		AbstractAdminController<IAcessoriesService> {

	@Autowired
	private IAcessoriesService acessoriesService;
	@Autowired
	private IOpLogService opLogService;

	@RequestMapping(value = "/acessories/list")
	public String list(Acessories acessories, ModelMap model,
			PageParam pageParam, HttpServletRequest request,
			HttpServletResponse response) {

		// 获取参数
		Map<String, Object> conditions = getQueryMap(acessories);
		BizData4Page<Acessories> pageCtx = doPage(model, conditions, pageParam);
		model.addAttribute("acessories", acessories);
		return "/module/acessories/list";
	}

	@RequestMapping(value = "/acessories/add")
	public String add(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("acessories", new Acessories());
		return "module/acessories/edit";
	}

	@RequestMapping(value = "/acessories/edit")
	public String edit(String id, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		Acessories acessories = acessoriesService.fetch(id);
		model.addAttribute("acessories", acessories);
		return "module/acessories/edit";
	}

	@RequestMapping(value = "/acessories/save")
	@ResponseBody
	public String save(HttpServletRequest request, Acessories acessories) {
		boolean isAddNew = StringUtils.isBlank(acessories.getId()) ? true
				: false;
		if (isAddNew) {
			acessories.setId(IdGenerator.createNewId());
			acessoriesService.add(acessories);

		} else {
			acessoriesService.update(acessories);

		}
		opLogService.createNew("上传附件", acessories.getFileName(), getCurrentUser());
		return JsonResult.saveSuccessClose(getMainObjName()).toString();
	}

	@RequestMapping(value = "/acessories/delete")
	@ResponseBody
	public String delete(String ids, HttpServletRequest request) {
		opLogService.createNew("删除附件", "附件ID"+ids, getCurrentUser());
		acessoriesService.deleteByIds(ids);
		return JsonResult.DELETE_SUCCESS.toString();
	}

	protected Map getQueryMap(Acessories acessories) {
		Map<String, Object> conditions = new HashMap();

		conditions.put("fileType", acessories.getFileType());
		conditions.put("fileId", acessories.getFileId());
		conditions.put("fileUrl", acessories.getFileUrl());
		conditions.put("fileName", acessories.getFileName());
		conditions.put("createDate", acessories.getCreateDate());
		conditions.put("updateDate", acessories.getUpdateDate());
		return conditions;
	}

	@RequestMapping(value = "/acessories/upload")
	@ResponseBody
	public String uploadit(HttpServletRequest req, HttpServletResponse resp,
			String upload) throws ServletException, IOException {
		User user = getCurrentUser();
		String username = null;
		String filetype = null;
		String fileName = null;
		username = user.getUserName();// 声明一个新user
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// setSizeThreshold设置是否将上传文件已临时文件的形式保存在磁盘的临界值（以字节为单位的int值），
		// 如果从没有调用该方法设置此临界值，将会采用系统默认值10KB。对应的getSizeThreshold() 方法用来获取此临界值。
		factory.setSizeThreshold(2048 * 1024);
		myProgressListener getBarListener = new myProgressListener(req);
		ServletFileUpload upload_ = new ServletFileUpload(factory);
		upload_.setProgressListener(getBarListener);
		try {
			@SuppressWarnings("rawtypes")
			List formList = upload_.parseRequest(req);
			@SuppressWarnings("unchecked")
			Iterator<Object> formItem = formList.iterator();
			// 将进度监听器加载进去
			while (formItem.hasNext()) {
				FileItem item = (FileItem) formItem.next();
				if (item.isFormField()) {
					System.out.println("Field Name:" + item.getFieldName());
				} else {
					fileName = item.getName().substring(
							item.getName().lastIndexOf("\\") + 1);
					filetype = fileName
							.substring(fileName.lastIndexOf(".") + 1)
							.toUpperCase();
					try {
						if (!(new File("D:/temp/" + username + "/")
								.isDirectory())) {
							new File("D:/temp/" + username + "/").mkdir();
						}
					} catch (SecurityException e) {
						e.printStackTrace();
					}

					File file = new File("d:\\temp" + "\\" + username + "\\"
							+ fileName);
					OutputStream out = item.getOutputStream();
					InputStream in = item.getInputStream();
					req.getSession().setAttribute("outPutStream", out);
					req.getSession().setAttribute("inPutStream", in);
					item.write(file);
					// 上传成功后存储到数据库中
					Acessories acessories = new Acessories();
					acessories.setFileName(fileName);
					acessories.setFileType(filetype);
					// acessories.setFileUrl("http://www."+username+"."+filetype+"."+fileName);
					acessories.setFileUrl(username);
					acessories.setFileId(IdGenerator.createNewId());
					SimpleDateFormat df = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");// 设置日期格式
					acessories.setCreateDate(df.parse(df.format(new Date())));
					save(req, acessories);
				}
			}
		} catch (FileUploadException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return JsonResult.saveSuccessClose(Constants.MAIN_TAB).toString();
	}

	@RequestMapping(value = "/acessories/download")
	@ResponseBody
	public HttpServletResponse wnloadit(String name, String partpath,
			HttpServletResponse response) {
		String username = partpath;
		String filename = null;
		try {
			String path = "D:/temp/" + username + "/" + name;
			response.addHeader("Content-Type", "text/html; charset=utf-8");
			File file = new File(path);
			// 取得文件名。
			filename = file.getName();
			// 取得文件的后缀名。
			String ext = filename.substring(filename.lastIndexOf(".") + 1)
					.toUpperCase();
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(filename.getBytes("gb2312"), "ISO8859-1"));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			response.setContentType("application/octet-stream");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		opLogService.createNew("下载附件", filename, getCurrentUser());
		return null;
	}

	@Override
	protected IAcessoriesService getMainService() {
		return acessoriesService;
	}

	@Override
	protected String getMainObjName() {
		return "acessories";
	}

	@Override
	protected String getViewTitle() {
		return "acessories";
	}
}
