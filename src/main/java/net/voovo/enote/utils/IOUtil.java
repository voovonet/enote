package net.voovo.enote.utils;

import java.io.File;

public class IOUtil {

	/**
	 * 创建目录
	 * @param dirPath
	 * @return
	 */
	public static boolean mkdirs(String dirPath) {
		File path=new File(dirPath);
		if(!path.exists()) {
			if(path.isFile()){
				System.out.println("路径不正确！");
				return false;
			}
			path.mkdirs();
		}
		return true;
	}
}
