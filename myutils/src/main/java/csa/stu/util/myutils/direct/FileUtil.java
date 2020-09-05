package csa.stu.util.myutils.direct;

import java.io.File;

public abstract class FileUtil {
	
	/**
	 * 创建不存在的目录
	 * @param files
	 */
	public static void createDirs(File...files){
		for (File file : files) {
			if(!file.exists()){
				file.mkdirs();
			}
		} //end for
	}
	
	public static void createDirs(String...paths){
		File file=null;
		for (String path : paths) {
			file=new File(path);
			if(!file.exists()){
				file.mkdirs();
			}
		} //end for
	}
	
	public static String getSuffix(String path){
		try{
			return path.substring(path.lastIndexOf(".")+1);
		}catch(Exception e){
			throw new RuntimeException("获取文件后缀失败");
		}
		
	}
	
	
	public static boolean deleteFile(String path){
		return new File(path).delete();
	}

}
