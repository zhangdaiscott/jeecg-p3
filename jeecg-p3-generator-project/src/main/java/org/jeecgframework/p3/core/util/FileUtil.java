package org.jeecgframework.p3.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class FileUtil {

	public static void createNewFile(String fileDirectoryAndName, String fileContent) {
		if(fileDirectoryAndName.indexOf("svn")>0){
			return;
		}
		try {
			String fileName = fileDirectoryAndName;
			//文件名首字母大写
			if (fileName.endsWith(".java")) {
				String s1 = fileName.substring(0, fileName.lastIndexOf("\\") + 1);
				String s2 = fileName.substring(fileName.lastIndexOf("\\") + 1);
				s2 = FileUtil.captureName(s2);
				fileName = s1 + s2;
			} 
			// 创建File对象，参数为String类型，表示目录名
			File myFile = new File(fileName);
			// 判断文件是否存在，如果不存在则调用createNewFile()方法创建新目录，否则跳至异常处理代码
			if (!myFile.exists())
				myFile.createNewFile();
//			else
				// 如果不存在则扔出异常
//				throw new Exception("The new file already exists!");
			// 下面把数据写入创建的文件，首先新建文件名为参数创建FileWriter对象
			FileWriter resultFile = new FileWriter(myFile);
			// 把该对象包装进PrinterWriter对象
			PrintWriter myNewFile = new PrintWriter(resultFile);
			// 再通过PrinterWriter对象的println()方法把字符串数据写入新建文件
			myNewFile.println(fileContent);
			resultFile.close(); // 关闭文件写入流
		} catch (Exception ex) {
			System.out.println("无法创建新文件！");
			ex.printStackTrace();
		}
	}
	
	//首字母大写
	public static String captureName(String name) {
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
        
    }

	public static boolean createFile(String destFileName) {
		File file = new File(destFileName);
		if (file.exists()) {
			// System.out.println("创建单个文件" + destFileName + "失败，目标文件已存在！");
			return false;
		}
		if (destFileName.endsWith(File.separator)) {
			// System.out.println("创建单个文件" + destFileName + "失败，目标文件不能为目录！");
			return false;
		}
		// 判断目标文件所在的目录是否存在
		if (!file.getParentFile().exists()) {
			// 如果目标文件所在的目录不存在，则创建父目录
			// System.out.println("目标文件所在目录不存在，准备创建它！");
			if (!file.getParentFile().mkdirs()) {
				// System.out.println("创建目标文件所在目录失败！");
				return false;
			}
		}
		// 创建目标文件
		try {
			if (file.createNewFile()) {
				// System.out.println("创建单个文件" + destFileName + "成功！");
				return true;
			} else {
				// System.out.println("创建单个文件" + destFileName + "失败！");
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			// System.out.println("创建单个文件" + destFileName + "失败！" +
			// e.getMessage());
			return false;
		}
	}

	public static boolean createDir(String destDirName) {
		if(destDirName.indexOf("svn")>0){
			return false;
		}
		File dir = new File(destDirName);
		if (dir.exists()) {
			// System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		// 创建目录
		if (dir.mkdirs()) {
			// System.out.println("创建目录" + destDirName + "成功！");
			return true;
		} else {
			// System.out.println("创建目录" + destDirName + "失败！");
			return false;
		}
	}

	public static String createTempFile(String prefix, String suffix, String dirName) {
		File tempFile = null;
		if (dirName == null) {
			try {
				// 在默认文件夹下创建临时文件
				tempFile = File.createTempFile(prefix, suffix);
				// 返回临时文件的路径
				return tempFile.getCanonicalPath();
			} catch (IOException e) {
				e.printStackTrace();
				// System.out.println("创建临时文件失败！" + e.getMessage());
				return null;
			}
		} else {
			File dir = new File(dirName);
			// 如果临时文件所在目录不存在，首先创建
			if (!dir.exists()) {
				if (!FileUtil.createDir(dirName)) {
					// System.out.println("创建临时文件失败，不能创建临时文件所在的目录！");
					return null;
				}
			}
			try {
				// 在指定目录下创建临时文件
				tempFile = File.createTempFile(prefix, suffix, dir);
				return tempFile.getCanonicalPath();
			} catch (IOException e) {
				e.printStackTrace();
				// System.out.println("创建临时文件失败！" + e.getMessage());
				return null;
			}
		}
	}

	/**
	 * 主要是输入流的使用，最常用的写法
	 * 
	 * @param filePath
	 * @return
	 */
	public static String read(String filePath) {
		// 读取txt内容为字符串
		StringBuffer txtContent = new StringBuffer();
		// 每次读取的byte数
		byte[] b = new byte[8 * 1024];
		InputStream in = null;
		try {
			// 文件输入流
			in = new FileInputStream(filePath);
			while (in.read(b) != -1) {
				// 字符串拼接
				txtContent.append(new String(b));
			}
			// 关闭流
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return txtContent.toString();
	}
}
