package com.yunji.oa.service.impl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.tools.ant.taskdefs.SQLExec;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunji.oa.model.Dictionary;
import com.yunji.oa.model.Factaleader;
import com.yunji.oa.model.Processunit;
import com.yunji.oa.service.IDictionaryService;
import com.yunji.oa.service.IFactaleaderService;
import com.yunji.oa.service.InitService;
import com.yunji.oa.service.IprocessunitService;

@Service("InitServiceImpl")
public class InitServiceImpl implements InitializingBean, InitService {
//	private String driver = "com.mysql.jdbc.Driver";
//	private String url = "jdbc:mysql://127.0.0.1:3306/oa";
//	private String user = "root";
//	private String password = "root";
//	private Connection con;

	
	@Autowired
	private IDictionaryService dictionaryService;
	@Autowired
	private IFactaleaderService factaleaderService;
	@Autowired
	private IprocessunitService iprocessunitService;

	@Override
	public void afterPropertiesSet() throws ClassNotFoundException,
			SQLException {
//		getlist();
		getcConditions();
		leaderlist();
		unitlist();
//		Class.forName(driver);
//		con = DriverManager.getConnection(url, user, password);
//		List<String> tablename = new ArrayList<String>();
//		DatabaseMetaData meta = con.getMetaData();
//		ResultSet rs = null;
//		rs = meta.getTables(null, null, null, new String[] { "TABLE" });
//		while (rs.next()) {
//			if (rs.getString(3).equals("t_oa_user")) {
//				System.out.println("有呢");
//				return;
//			} else {
//				antinput();
//				return;
//			}
//		}
	
		// TODO Auto-generated method stub
/*		String wwwroot = readValue(StringUtil.getRootPath("system.properties"), "system.wwwroot");
		System.out.println(wwwroot);*/
	}
//这里写个map在初始化的时候调用
//	public List<Dictionary> getlist(){
//		List<Dictionary> dictionaryInfos = dictionaryService.findAll();
//		Map<String, Object> conditions=null;
//		for(Dictionary m:dictionaryInfos)
//		{
//			conditions.put(""+m.getPropertkey()+"",m.getPropertvalue());
//			System.out.println(m.getPropertkey());
//			System.out.println(m.getPropertvalue());
//		}
//		return dictionaryInfos;
//	}
	public Map<String, Object> getcConditions(){
		Map<String, Object> conditions=new HashMap<String, Object>();
		List<Dictionary> dictionaryInfos = dictionaryService.findAll();
		for(Dictionary m:dictionaryInfos)
		{
			conditions.put(m.getPropertkey()+"",m.getPropertvalue());
//			System.out.println(m.getPropertkey());
//			System.out.println(m.getPropertvalue());
		}
		return  conditions;
	}
	public List<Factaleader> leaderlist(){
		List<Factaleader> leaderlist=factaleaderService.findAll();
		return leaderlist;
	}
	@Override
	public List<Processunit> unitlist() {
		// TODO Auto-generated method stub
		List<Processunit> unitlist=iprocessunitService.findAll();
		return unitlist;
	}
	
//  protected Map<String, Object> putMap(String key,Object value)
//  {
//		conditions.put(""+key+"",value);		
//  	return conditions;
//  }
//	 public static String readValue(String filePath,String key) {
//		  Properties props = new Properties();
//		        try {
//		         InputStream in = new BufferedInputStream (new FileInputStream(filePath));
//		         props.load(in);
//		         String value = props.getProperty (key);
//		            System.out.println(key+value);
//		            return value;
//		        } catch (Exception e) {
//		         e.printStackTrace();
//		         return null;
//		        }
//		 }


//	private void antinput() {
//		SQLExec sqlExec = new SQLExec();
//		sqlExec.setDriver(driver);
//		sqlExec.setUrl(url);
//		sqlExec.setUserid(user);
//		sqlExec.setPassword(password);
//		sqlExec.setSrc(new File("src/main/resources/sql/oa_init20150423.sql"));// 要执行的脚本
//		// 有出错的语句该如何处理
//		sqlExec.setOnerror((SQLExec.OnError) (EnumeratedAttribute.getInstance(
//				SQLExec.OnError.class, "abort")));
//		sqlExec.setPrint(true); // 设置是否输出
//		// 输出到文件 sql.out 中；不设置该属性，默认输出到控制台
//		sqlExec.setOutput(new File("src/main/resources/sql/sql.out"));
//		sqlExec.setProject(new Project()); // 要指定这个属性，不然会出错
//		sqlExec.execute();
//		System.out.println("OK");
//	}
//	Processunit  Factaleader
//	public List<Factaleader> getAllleader(){
//		List<Factaleader> leaderlist=new ArrayList<Factaleader>();
//		FactaleaderAction fa=new FactaleaderAction();
//		return leaderlist;
//	}
//	public List<Processunit> getAllProcessunit(){
//		List<Processunit> processunitlist=new ArrayList<Processunit>();
//		return processunitlist;
//	}
//    public void li(Factaleader factaleader){
//    	Map<String, Object> conditions = getMap(factaleader); 	
//    	 Set<Map.Entry<String,Object>> entry = conditions.entrySet();  
//         //通过迭代器取出map中的键值关系，迭代器接收的泛型参数应和Set接收的一致  
//         Iterator<Map.Entry<String,Object>> it = entry.iterator();  
//         while (it.hasNext())  
//         {  
//             //将键值关系取出存入Map.Entry这个映射关系集合接口中  
//             Map.Entry<String,Object>  me = it.next();  
//             //使用Map.Entry中的方法获取键和值  
//             String key = me.getKey();  
//             Object value = me.getValue();  
//             System.out.println(key + " : " + value);  
//         }  
//    }
//    
//    protected Map getMap(Factaleader factaleader)
//    {
//    	Map<String, Object> conditions = new HashMap();
//    	
//		conditions.put("leadername", factaleader.getLeadername());		
//		conditions.put("createDate", factaleader.getCreateDate());		
//		conditions.put("updateDate", factaleader.getUpdateDate());		
//    	return conditions;
//    }

		
		
}
