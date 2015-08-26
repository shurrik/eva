package com.yunji.oa.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.yunji.oa.model.User;
import com.yunji.oa.service.IUserService;
import com.yunji.oa.util.Constants;
import com.yunji.oa.util.JsonResult;
import com.yunji.oa.util.myProgressListener;

@Controller
public class FileUploadAction extends AbstractAdminController<IUserService>{
	  @RequestMapping(value="/upload")
	    public String upload(HttpServletRequest request,HttpServletResponse response){
	        return "/module/fileupload/upload";
	    }   

	  @RequestMapping(value="/user/upload")
	  @ResponseBody
	  public String doupload(HttpServletRequest req, HttpServletResponse resp,String upload)
				throws ServletException, IOException {
		    User user =getCurrentUser(req);
		    String username=user.getUserName();
			DiskFileItemFactory factory = new DiskFileItemFactory();
//			setSizeThreshold设置是否将上传文件已临时文件的形式保存在磁盘的临界值（以字节为单位的int值），
//			如果从没有调用该方法设置此临界值，将会采用系统默认值10KB。对应的getSizeThreshold() 方法用来获取此临界值。
			factory.setSizeThreshold(2048*1024);
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
						String fileName = item.getName().substring(item.getName().lastIndexOf("\\")+1);
						System.out.println("文件名称 ："+fileName);
						try {
							   if (!(new File("D:/temp/"+username+"/").isDirectory())) {
							    new File("D:/temp/"+username+"/").mkdir();
							   }
							  } catch (SecurityException e) {
							   e.printStackTrace();
							  }
						 String ext = fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();
						 System.out.println("后缀名："+ext);
						File file = new File("d:\\temp"
								+ "\\" + username+ "\\" + fileName);
						OutputStream out = item.getOutputStream();
						InputStream in = item.getInputStream();
						req.getSession().setAttribute("outPutStream", out);
						req.getSession().setAttribute("inPutStream", in);
						item.write(file);
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

	  @RequestMapping(value="/user/download")
	  @ResponseBody
	  public HttpServletResponse download(String name, HttpServletRequest request,HttpServletResponse response) {
		    User user =getCurrentUser(request);
		    String username=user.getUserName();
		    name="测试.txt";
	        try {
	        	String path="D:/temp/"+username+"/"+name;
	        	  response.addHeader("Content-Type", "text/html; charset=utf-8");  
	            File file = new File(path);
	            // 取得文件名。
	            String filename = file.getName();
	            // 取得文件的后缀名。
	            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
	            // 以流的形式下载文件。
	            InputStream fis = new BufferedInputStream(new FileInputStream(path));
	            byte[] buffer = new byte[fis.available()];
	            fis.read(buffer);
	            fis.close();
	            // 清空response
	            response.reset();
	            // 设置response的Header
	            response.setHeader( "Content-Disposition", "attachment;filename=" + new String( filename.getBytes("gb2312"), "ISO8859-1" ) ); 
	            response.addHeader("Content-Length", "" + file.length());
	            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
	            response.setContentType("application/octet-stream");
	            toClient.write(buffer);
	            toClient.flush();
	            toClient.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        return null;
	    }
	  
	  
	  
	@Override
	protected IUserService getMainService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getMainObjName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getViewTitle() {
		// TODO Auto-generated method stub
		return null;
	}

}
