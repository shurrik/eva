
package com.yunji.oa.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





import java.util.Properties;

import com.yunji.oa.model.Factaleader;
import com.yunji.oa.model.Processunit;

public class Ulist{
	private   Connection conn ;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Statement stmt;
	private String driver = "com.mysql.jdbc.Driver";
	
	
//	private String url = "jdbc:mysql://127.0.0.1:3306/oa";
//	private String user = "root";
//	private String password = "root";
	
	
	private String dbHost;
	private String dbPort;
	private String dbUsername;
	private String dbPassword;
	
//	public DbHelper(String dbHost,String dbPort,String dbUsername,String dbPassword) {
//
//		this.setDbHost(dbHost);
//		this.setDbPort(dbPort);
//		this.setDbUsername(dbUsername);
//		this.setDbPassword(dbPassword);
//	}	
	
	public List<Factaleader> getAllleader() throws ClassNotFoundException{
	List<Factaleader> leaderlist=new ArrayList<Factaleader>();
	ResultSet rst = null;
		Class.forName(driver);
		String url="jdbc:mysql://"+this.getDbHost()+":"+this.getDbPort()+"/oa";
		try {
			conn=DriverManager.getConnection(url, this.dbUsername, this.dbPassword);
			//获取连接对象
			pstmt = conn.prepareStatement("select * from t_oa_factaleader");
			rst = pstmt.executeQuery();
			while(rst.next()){
				Factaleader fleader=new Factaleader();
					fleader.setLeadername(rst.getString("leadername"));
					leaderlist.add(fleader);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return leaderlist;
}
public List<Processunit> getAllProcessunit(){
	List<Processunit> processunitlist=new ArrayList<Processunit>();
	ResultSet rst = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String url="jdbc:mysql://"+this.getDbHost()+":"+this.getDbPort()+"/oa";
		try {
			conn=DriverManager.getConnection(url, this.dbUsername, this.dbPassword);
			//获取连接对象
			pstmt = conn.prepareStatement("select * from t_oa_processunit");
			rst = pstmt.executeQuery();
			while(rst.next()){
				Processunit punit=new Processunit();
				punit.setUnitname(rst.getString("unitname"));
				processunitlist.add(punit);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return processunitlist;
}

public  Map getMap()
{
	Map<String, Object> conditions = new HashMap();
	ResultSet rst = null;
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	String url="jdbc:mysql://"+this.getDbHost()+":"+this.getDbPort()+"/oa";
	System.out.println(url);
	try {
		conn=DriverManager.getConnection(url, this.dbUsername, this.dbPassword);
		//获取连接对象
		pstmt = conn.prepareStatement("select * from t_oa_moduleinfo");
		rst = pstmt.executeQuery();
		while(rst.next()){
//			ModuleInfo moduleInfo=new ModuleInfo();
			System.out.println(rst.getString("remarkinfo"));
//			conditions.put("remarkinfo", rst.getString("remarkinfo"));		
//			conditions.put("userinfo", rst.getString("userinfo"));	
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	conditions.put("remarkinfo", rst.getString("remarkinfo"));		
//	conditions.put("userinfo", rst.getString("userinfo"));		
//	conditions.put("createDate", moduleInfo.getCreateDate());		
//	conditions.put("updateDate", moduleInfo.getUpdateDate());		
	return conditions;
}


public Connection getConn() {
	return conn;
}
public void setConn(Connection conn) {
	this.conn = conn;
}
public PreparedStatement getPstmt() {
	return pstmt;
}
public void setPstmt(PreparedStatement pstmt) {
	this.pstmt = pstmt;
}
public ResultSet getRs() {
	return rs;
}
public void setRs(ResultSet rs) {
	this.rs = rs;
}
public Statement getStmt() {
	return stmt;
}
public void setStmt(Statement stmt) {
	this.stmt = stmt;
}	
public String getDriver() {
	return driver;
}

public void setDriver(String driver) {
	this.driver = driver;
}

public String getDbHost() {
	return dbHost;
}

public void setDbHost(String dbHost) {
	this.dbHost = dbHost;
}

public String getDbPort() {
	return dbPort;
}

public void setDbPort(String dbPort) {
	this.dbPort = dbPort;
}

public String getDbUsername() {
	return dbUsername;
}

public void setDbUsername(String dbUsername) {
	this.dbUsername = dbUsername;
}

public String getDbPassword() {
	return dbPassword;
}

public void setDbPassword(String dbPassword) {
	this.dbPassword = dbPassword;
}


 public static String readValue(String filePath,String key) {
	  Properties props = new Properties();
	        try {
	         InputStream in = new BufferedInputStream (new FileInputStream(filePath));
	         props.load(in);
	         String value = props.getProperty (key);
	            System.out.println(key+value);
	            return value;
	        } catch (Exception e) {
	         e.printStackTrace();
	         return null;
	        }
	 }

}
