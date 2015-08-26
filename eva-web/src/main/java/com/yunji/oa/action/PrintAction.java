package com.yunji.oa.action;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.ant.types.resources.selectors.Date;
import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yunji.install.util.StringUtil;
import com.yunji.oa.model.RecForm;
import com.yunji.oa.model.SendForm;
import com.yunji.oa.service.IBackLogService;
import com.yunji.oa.service.IRecFormService;
import com.yunji.oa.service.ISendFormService;
import com.yunji.oa.service.InitService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.ContentUtils;
import com.yunji.oa.util.HtmlRegexpUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Controller
public class PrintAction extends BaseAction {
	private Configuration configuration = null;
	@Autowired
	private IRecFormService recFormService;
	@Autowired
	private ISendFormService sendFormService;
	@Autowired
	private IBackLogService backLogService;
	@Autowired
	private InitService initService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/print/recform")
	public String printRecform(String id, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		RecForm recForm = recFormService.fetch(id);
		Map<String, Object> map = initService.getcConditions();
		model.addAttribute("redForm", map);
		model.addAttribute("recForm", recForm);
		if (null != recForm.getRecType()
				&& recForm.getRecType().equals(Constants.TYPE_RECFORM_HANDLE)) {
			return "/module/print/recform/handle";
		} else {
			return "/module/print/recform/read";
		}
	}

	/*
	 * @RequestMapping(value="/print/recform/handle") public String
	 * recformHandle(ModelMap model,HttpServletRequest
	 * request,HttpServletResponse response){
	 * 
	 * return "/print/recform/handle"; }
	 */
	@RequestMapping(value = "/print/sendform")
	public String printSendform(String id, String docId, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		SendForm sendForm = null;
		sendForm = sendFormService.fetch(id);
		Map<String, Object> map = initService.getcConditions();
		model.addAttribute("redForm", map);
		model.addAttribute("sendForm", sendForm);
		if (null != sendForm.getType()
				&& sendForm.getType().equals(Constants.TYPE_SENDFORM_SINGLE)) {
			return "/module/print/sendform/single";
		} else {
			return "/module/print/sendform/collect";
		}
	}

	/**
	 * 收文word下载
	 * @throws Docx4JException 
	 */
	@RequestMapping(value = "print/precform")
	public void precform(String id, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws IOException, TemplateException, Docx4JException {
		RecForm recForm = recFormService.fetch(id);
		recForm = this.processRecform(recForm);
		configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		Map<String, Object> map = initService.getcConditions();
		model.addAttribute("redForm", map);
		model.addAttribute("recForm", recForm);
		model.addAttribute("wordCut", this.wordCut(recForm.getContent()));
		model.addAttribute("wordCutRemark", this.wordCutRemark(recForm.getRemark()));
		model.addAttribute("depone", this.worddep(recForm.getDepName()));
		model.addAttribute("deptwo", this.worddeptwo(recForm.getDepName()));
//		Integer contentLength = HtmlRegexpUtil.filterHtml(recForm.getContent()+recForm.getRemark()).length();

		String fileName = recForm.getNo() + ".docx";
		configuration.setClassForTemplateLoading(this.getClass(),
				"/com/yunji/oa/template");
		Template t = null;

		try {
			if (null == recForm.getRecType()
					|| recForm.getRecType().equals(
							Constants.TYPE_RECFORM_HANDLE)) {
				t = configuration.getTemplate("handle.ftl");
//				Integer contentLength = HtmlRegexpUtil.filterHtml(recForm.getContent()+recForm.getRemark()).length();
				Integer contentLength = HtmlRegexpUtil.filterHtml(recForm.getContent()).length();
				Integer remarkLength = HtmlRegexpUtil.filterHtml(recForm.getRemark()).length();
				Integer titleLength = HtmlRegexpUtil.filterHtml(recForm.getTitle()).length();
				Integer totalLength = contentLength + titleLength;
				model.addAttribute("contentLength", contentLength);
				model.addAttribute("remarkLength", remarkLength);
				model.addAttribute("titleLength", titleLength);
				model.addAttribute("totalLength", totalLength);
			} else {
				t = configuration.getTemplate("read.ftl");
/*				Integer contentLength = HtmlRegexpUtil.filterHtml(recForm.getTitle()).length();
				model.addAttribute("contentLength", contentLength);	*/	
				Integer titleLength = HtmlRegexpUtil.filterHtml(recForm.getTitle()).length();
				model.addAttribute("titleLength", titleLength);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		createDoc(model, fileName, t, response);
	}

	private String[] wordCut(String input) {
		// 郑则表达式替换字符 保留<strong> 适用于自封闭标签
		// String regexstr = input.replaceAll("<(?!strong).*?>", "");
		// System.out.println(regexstr);
		// 替换strong标签为特殊字符
		String newinput = input.replace("<strong>", "щ");// 替换粗体标签
		String inputexChange = newinput.replace("</strong>", "Ψ");// 替换粗体标签
		String inputNorm = inputexChange.replace("щ", "Ψщ");// 规范特殊字符
		// 清除html所有标签
		String inputhtml = inputNorm.replaceAll("<[^>]*>", "");
		String[] inputs = inputhtml.split("Ψ");
		return inputs;
	}

	
	private String[] wordCutRemark(String input) {
		// 郑则表达式替换字符 保留<strong> 适用于自封闭标签
		// String regexstr = input.replaceAll("<(?!strong).*?>", "");
		// System.out.println(regexstr);
		// 替换strong标签为特殊字符
		String newinput = input.replace("<strong>", "щ");// 替换粗体标签
		String inputexChange = newinput.replace("</strong>", "Ψ");// 替换粗体标签
		String inputNorm = inputexChange.replace("щ", "Ψщ");// 规范特殊字符
		// 清除html所有标签
		String inputhtml = inputNorm.replaceAll("<[^>]*>", "");
		String[] inputRemark = inputhtml.split("Ψ");
		return inputRemark;
	}
	
	private String worddep(String dep) {
		String depone = "";
		if (dep.length() < 4) {
			depone = dep;
		} else {
			int deplength = dep.length();
			depone = dep.substring(0, deplength / 2);
		}
		return depone;
	}

	private String worddeptwo(String dep) {
		String deptwo = "";
		if (dep.length() < 4) {
			deptwo = "";
		} else {
			int deplength = dep.length();
			deptwo = dep.substring(deplength / 2, deplength);
		}
		return deptwo;
	}

	/**
	 * 发文word下载
	 * @throws Docx4JException 
	 */
	@RequestMapping(value = "print/psendform")
	public void psendform(String id, ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, TemplateException, Docx4JException {
		SendForm sendForm = sendFormService.fetch(id);
		configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		model.addAttribute("sendForm", sendForm);
		String fileName = "D:/" + sendForm.getNo() + ".docx";
		configuration.setClassForTemplateLoading(this.getClass(),
				"/com/yunji/oa/template");
		Template t = null;
		try {
			if (null == sendForm.getType()
					|| sendForm.getType()
							.equals(Constants.TYPE_SENDFORM_SINGLE)) {
				t = configuration.getTemplate("single.ftl");
			} else {
				t = configuration.getTemplate("collect.ftl");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		createDoc(model, fileName, t, response);
	}

	/**
	 * word下载方法
	 * @throws Docx4JException 
	 */
	
	public void createDoc(ModelMap model, String fileName, Template t,
			HttpServletResponse response) throws IOException, TemplateException, Docx4JException {
		
 		String content = FreeMarkerTemplateUtils.processTemplateIntoString(t,
				model);
		InputStream   is   =   new   ByteArrayInputStream(content.getBytes());
		String filePath = this.createDoc(content);
		File file = new File(filePath);
		
		WordprocessingMLPackage wmp = WordprocessingMLPackage.load(file);
		response.setContentType("application/msword");
		response.addHeader("Content-Disposition", "attachment; filename="
				+ java.net.URLEncoder.encode(fileName, "UTF-8"));
		OutputStream o = response.getOutputStream();
		
		Docx4J.save(wmp, o, 1);
		o.close();
	}	
	
	private String createDoc(String content) throws IOException
	{
		Date now = new Date();
		String filePath =StringUtil.getRootPath("tmpdoc")+File.separator+"tmp.docx";
		File file = new File(filePath);
		if (!file.exists()) {
			file.createNewFile();
		}		
		OutputStream os = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write(content);
		bw.close();		
		return filePath;
	}
	
	
	private RecForm processRecform(RecForm recForm)
	{
		recForm.setTitle(recForm.getTitle()!=null?ContentUtils.replaceBrackets(recForm.getTitle()):"");
		return recForm;
	}
	
/*	public void createDoc(ModelMap model, String fileName, Template t,
			HttpServletResponse response) throws IOException, TemplateException {
		response.setContentType("application/msword");
		response.addHeader("Content-Disposition", "attachment; filename="
				+ java.net.URLEncoder.encode(fileName, "UTF-8"));
		PrintWriter out = response.getWriter();
		t.process(model, out);
		out.close();
	}*/

	/**
	 * 打印方法
	 */
	// @RequestMapping(value = "/print/printrecform")
	// public void printrecform(String id, ModelMap model,
	// HttpServletRequest request, HttpServletResponse response,
	// String fileName) throws IOException, TemplateException {
	// RecForm recForm = recFormService.fetch(id);
	// configuration = new Configuration();
	// configuration.setDefaultEncoding("utf-8");
	// Map<String, Object> dataMap = new HashMap<String, Object>();
	// dataMap.put("recForm", recForm);
	// dataMap.put("wordCut", this.wordCut(recForm.getContent()));
	// dataMap.put("depone", this.worddep(recForm.getDepName()));
	// dataMap.put("deptwo", this.worddeptwo(recForm.getDepName()));
	// fileName = "D:/outFile.doc";
	// configuration.setClassForTemplateLoading(this.getClass(),
	// "/com/yunji/oa/template");
	// Template t = null;
	// try {
	// if (null == recForm.getRecType()
	// || recForm.getRecType().equals(
	// Constants.TYPE_RECFORM_HANDLE)) {
	// t = configuration.getTemplate("handle.ftl");
	// } else {
	// t = configuration.getTemplate("read.ftl");
	// }
	// Writer out = null;
	// FileOutputStream fos = null;
	// File outFile = new File(fileName);
	// fos = new FileOutputStream(outFile);
	// OutputStreamWriter oWriter = new OutputStreamWriter(fos, "UTF-8");
	// out = new BufferedWriter(oWriter);
	// t.process(dataMap, out);
	// out.close();
	// fos.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// } finally {
	// // 始终释放资源
	// printDoc(dataMap, fileName, t);
	// ComThread.Release();
	// }
	// }
	//
	// /**
	// * 打印word
	// *
	// * @param dataMap
	// * @param fileName
	// * @param t
	// * @throws IOException
	// * @throws TemplateException
	// */
	// public void printDoc(Map<String, Object> dataMap, String fileName,
	// Template t) throws IOException, TemplateException {
	// ComThread.InitSTA();
	// ActiveXComponent wd = new ActiveXComponent("Word.Application");
	// try {
	// // 不打开文档
	// Dispatch.put(wd, "Visible", new Variant(true));
	// Dispatch document = wd.getProperty("Documents").toDispatch();
	// // 打开文档
	// Dispatch doc = Dispatch.invoke(document, "Open", Dispatch.Method,
	// new Object[] { fileName }, new int[1]).toDispatch();
	// // 开始打印
	// Dispatch.call(doc, "PrintOut");
	// wd.invoke("Quit", new Variant[] {});
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// // 始终释放资源
	// deletefile("D:/outFile.doc");
	// ComThread.Release();
	// }
	//
	// }
	//
	// /**
	// * 删除word文档
	// *
	// * @param delpath
	// * @return
	// * @throws FileNotFoundException
	// * @throws IOException
	// */
	// public static boolean deletefile(String delpath)
	// throws FileNotFoundException, IOException {
	// try {
	//
	// File file = new File(delpath);
	// if (!file.isDirectory()) {
	// System.out.println("1");
	// file.delete();
	// } else if (file.isDirectory()) {
	// System.out.println("2");
	// String[] filelist = file.list();
	// for (int i = 0; i < filelist.length; i++) {
	// File delfile = new File(delpath + "\\" + filelist[i]);
	// if (!delfile.isDirectory()) {
	// System.out.println("path=" + delfile.getPath());
	// System.out.println("absolutepath="
	// + delfile.getAbsolutePath());
	// System.out.println("name=" + delfile.getName());
	// delfile.delete();
	// System.out.println("删除文件成功");
	// } else if (delfile.isDirectory()) {
	// deletefile(delpath + "\\" + filelist[i]);
	// }
	// }
	// file.delete();
	// }
	// } catch (FileNotFoundException e) {
	// System.out.println("deletefile() Exception:" + e.getMessage());
	// }
	// return true;
	// }
}
