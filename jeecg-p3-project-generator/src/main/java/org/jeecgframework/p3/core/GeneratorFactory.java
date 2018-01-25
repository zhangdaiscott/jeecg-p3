package org.jeecgframework.p3.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jeecgframework.p3.core.util.FileUtil;
import org.jeecgframework.p3.core.util.PropertiesUtil;

public class GeneratorFactory {
	private static final String TEMPLATE_PACKAGE = "project-template";
	private static final String PROJECT_NAME_KEY = "${projectName}";
	private static final String PROJECT_NAME_KEY_UPPERNAME = "${projectNameUpperName}";
	private static final String PROJECT_NAME_INDEX = "jeecg-p3-biz-";
	//模板路径
	private static  String templdate_url; //= "src/main/resources/project-template";
	//项目生成路径
	private static  String generator_url;// = "D:\\p3";
	
	static{
		PropertiesUtil p = new PropertiesUtil("project-generator.properties");
		templdate_url = p.readProperty("templdate_url");
		generator_url = p.readProperty("generator_url");
	}
	
	
	public GeneratorFactory() {
	}
	
	public static void doMake(String projectName){
		try {
			String projectTempldateUrl = System.getProperty("user.dir")+"\\"+ templdate_url;
			readfile(projectTempldateUrl, generator_url, projectName);
			System.out.println("********** Jeecg业务插件项目  ：  {"+"jeecg-p3-biz-"+projectName+"} 生成成功 。 下载目录："+ generator_url +"\\jeecg-p3-biz-"+projectName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * 读取某个文件夹下的所有文件
	 */
	public static boolean readfile(String filepath, String generator_url, String projectName) throws FileNotFoundException, IOException {
		try {
			String mainProjectUrl = generator_url + "\\" + PROJECT_NAME_INDEX + projectName;
			FileUtil.createDir(mainProjectUrl);
			
			File file = new File(filepath);
			if (!file.isDirectory()) {
//				System.out.println("文件");
//				System.out.println("path=" + file.getPath());
				// System.out.println("absolutepath=" + file.getAbsolutePath());
				// System.out.println("name=" + file.getName());
				String path = file.getPath();
				String content = FileUtil.read(path);
				if(content!=null){
					content = content.replace(PROJECT_NAME_KEY, projectName).trim();
				}
				path = path.substring(path.indexOf(TEMPLATE_PACKAGE), path.length()).replace(TEMPLATE_PACKAGE+"\\", "").replace("."+PROJECT_NAME_KEY, "."+lowerName(projectName)).replace(PROJECT_NAME_KEY,lowerName(projectName));
				if(!TEMPLATE_PACKAGE.equals(path)){
					String mkdirFileUrl = generator_url + "\\" + PROJECT_NAME_INDEX + projectName + "\\" + path;
					//过滤掉svn文件
					if(mkdirFileUrl.indexOf("svn")==-1){
						System.out.println("mkdirFileUrl=" + mkdirFileUrl);
						FileUtil.createNewFile(mkdirFileUrl,content);
					}
				}
			} else if (file.isDirectory()) {
				// System.out.println("文件夹");
				String[] filelist = file.list();
				String path = file.getPath();
				path = path.substring(path.indexOf(TEMPLATE_PACKAGE), path.length()).replace(TEMPLATE_PACKAGE+"\\", "").replace("."+PROJECT_NAME_KEY, "."+lowerName(projectName)).replace(PROJECT_NAME_KEY,lowerName(projectName));
				// System.out.println("path=" + path);
				// System.out.println("absolutepath=" + file.getAbsolutePath());
				// System.out.println("name=" + file.getName());
				
				if(!TEMPLATE_PACKAGE.equals(path)){
					String mkdirFileUrl = generator_url + "\\" + PROJECT_NAME_INDEX + projectName + "\\" + path;
//					System.out.println("mkdirFileUrl=" + mkdirFileUrl);
					FileUtil.createDir(mkdirFileUrl);
				}
				for (int i = 0; i < filelist.length; i++) {
					File readfile = new File(filepath + "\\" + filelist[i]);
					if (!readfile.isDirectory()) {
						path = readfile.getPath();
						String content = FileUtil.read(path);
						if(content!=null){
							content = content.replace(PROJECT_NAME_KEY, projectName).trim();
							content = content.replace(PROJECT_NAME_KEY_UPPERNAME, GeneratorFactory.upperName(projectName).trim());
						}
						path = path.substring(path.indexOf(TEMPLATE_PACKAGE), path.length()).replace(TEMPLATE_PACKAGE+"\\", "").replace("."+PROJECT_NAME_KEY, "."+lowerName(projectName)).replace(PROJECT_NAME_KEY,lowerName(projectName));
						if(!TEMPLATE_PACKAGE.equals(path)){
							String mkdirFileUrl = generator_url + "\\" + PROJECT_NAME_INDEX + projectName + "\\" + path;
//							System.out.println("mkdirFileUrl=" + mkdirFileUrl);
							FileUtil.createNewFile(mkdirFileUrl,content);
						}
//						System.out.println("文件");
//						System.out.println("path=" + readfile.getPath());
						// System.out.println("absolutepath="+ readfile.getAbsolutePath());
						// System.out.println("name=" + readfile.getName());

					} else if (readfile.isDirectory()) {
						readfile(filepath + "\\" + filelist[i], generator_url, projectName);
					}
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("readfile()   Exception:" + e.getMessage());
		}
		return true;
	}
	
	/**
	 * 首字母小写
	 * @param name
	 * @return
	 */
	public static String lowerName(String name) {
        name = name.substring(0, 1).toLowerCase() + name.substring(1);
       return  name;
    }
	
	/**
	 * 首字母大写
	 * @param name
	 * @return
	 */
	public static String upperName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
       return  name;
    }
}
