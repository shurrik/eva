package com.yunji.install.util;

import java.io.File;

public class InstallSetting {

	public static Boolean INSTALL_LOCK = false;
	
	static{
//		File installLockFile = new File(StringUtil.getRootPath()+"/install/install.lock");
		File installLockFile = new File(StringUtil.getRootPath()+"/install.lock");
		if( installLockFile.exists() ){
			INSTALL_LOCK = true; //如果存在则不能安装
		}else{
			INSTALL_LOCK = false; //如果不存在，则认为是全新的，跳到install页
		}		
	}
}
