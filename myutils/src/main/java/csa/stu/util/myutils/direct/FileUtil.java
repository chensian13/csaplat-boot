package csa.stu.util.myutils.direct;

import csa.stu.util.myutils.exception.CsaplatException;
import java.io.File;

/**
 * 文件系统帮助类
 */
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
	
	public static String getSuffix(String path) throws CsaplatException{
		try{
			return path.substring(path.lastIndexOf(".")+1);
		}catch(Exception e){
			throw new CsaplatException("获取文件后缀失败");
		}
	}

	/**
	 * 是否图片的尾缀
	 * @param path
	 * @return
	 */
	public static boolean isImageSuffix(String path){
		if(path.endsWith(".jpg")
				|| path.endsWith(".JPG")
				|| path.endsWith(".png")
				|| path.endsWith(".PNG")
				|| path.endsWith(".gif")
				|| path.endsWith(".GIF")
				|| path.endsWith(".jpeg")
				|| path.endsWith(".JPEG")){
			return true;
		}
		return false;
	}

	/**
	 * 删除文件
	 * @param path
	 * @return
	 */
	public static boolean deleteFile(String path){
		return new File(path).delete();
	}

	/**
	 * 安全删除文件夹
	 * @param path
	 * @return
	 */
	public static void deleteDirSave(String path){
		deleteDirSave(new File(path));
	}

	/**
	 * 安全删除文件夹
	 * @param path
	 * @return
	 */
	public static void deleteDirSave(File file){
		String[] ps = file.list();
		if(ps == null
				|| ps.length == 0){
			file.delete();
		}
	}


}
