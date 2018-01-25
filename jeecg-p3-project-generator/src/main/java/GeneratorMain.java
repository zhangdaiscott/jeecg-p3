import org.jeecgframework.p3.core.GeneratorFactory;


/**
 * 
 * @author jeecg
 * @email jeecg@sina.com
 */
public class GeneratorMain {
	
	/**
	 * 请修改{项目名}，执行项目生成
	 */
	public static void main(String[] args) throws Exception {
		//项目名
		String projectName = "bizcore";//项目名称 ：jeecg-p3-biz-{自定义模块名}
		GeneratorFactory.doMake(projectName);
	}
}
