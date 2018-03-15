Jeecg-P3 微服务框架（插件开发与容器技术最佳实践）
==========
特点：微服务与容器技术实践，业务组件以JAR方式提供，插件模式、松耦合、可插拔、支持独立部署，也可以无缝集成Jeecg平台中。

===============
当前最新版本：1.0.1（发布日期：20160915）


【项目说明】

	jeecg-p3-web               | 启动主项目(基础)
	jeecg-p3-project-generator | 项目骨架生成工具(基础)
	jeecg-p3-biz-demo          | hello word Demo（插件）
    jeecg-p3-biz-qywx          | 微信企业号（插件）
	jeecg-p3-biz-cms           | 微信CMS系统（插件）
	
技术交流
==========
* QQ交流群: 190866569
* 技术论坛：[www.jeecg.org](http://www.jeecg.org)

	
【JEECG插件开发】

* 在线演示：[http://yun.jeecg.org](http://yun.jeecg.org)
* 入门必读：[开发环境搭建文档](http://blog.csdn.net/zhangdaiscott/article/details/51896686)
* [Jeecg-p3开发入门视频](http://www.jeecg.org/forum.php?mod=viewthread&tid=3173&extra=page%3D1)




【架构说明】

    1.Jeecg-P3 采用SpringMvc + Minidao + Velocity + Maven(构建) 框架技术
    2.插件引入方式
        pom.xml文件中，引入新开发的插件
        <!-- P3 jar -->
 	    <dependency>
			<groupId>org.p3framework</groupId>
			<artifactId>jeecg-p3-biz-demo</artifactId>
			<version>1.0.0</version>
		</dependency>
	3.项目启动访问方式：
	  采用maven方式，启动Web项目
      http://localhost/jeecg-p3-web/{页面访问地址}
    4.页面层面不能采用jsp，需要采用模板语言Velocity
    5.插件式开发,每个业务组件以jar包方式提供
	6.数据库配置文件：
	  jeecg-p3-web/src/main/resources/dbconfig.properties


【开发入门】

	☆准备工作：
		1.标准开发工具：eclipse + jdk7 + tomcat7 + mysql
		2.项目为maven工程，采用maven方式导入eclipse等IDE开发工具 

	☆快捷启动：
		第一步：创建Mysql数据库jeecg-p3，采用UTF-8编码，执行对应插件的数据库脚本
				{插件项目名}\doc\db\{插件项目名}-mysql.sql
		第二步：双击运行jeecg-p3-web\bin\run-tomcat7.bat或bin\run-tomcat.bat，
				启动Web服务器（第一次运行，需要下载依赖jar包，请耐心等待）。
		第三步：项目访问地址
				http://localhost/jeecg-p3-web
				
					
	☆Eclipse运行步骤：
		第一步：创建Mysql数据库jeecg-p3，采用UTF-8编码，执行下面数据库脚本
				{插件项目名}\doc\db\{插件项目名}-mysql.sql
		第二步：采用maven方式启动项目 (jeecg-p3-web)
				项目右建->debug as->debug configurations->选中jeecg-p3-web项目->输入命令：tomcat:run
				注意：[1].update snapshots需要选中，官方会不断更新底层包
					  [2].插件项目不能单独启动，需以maven方式引入jeecg-p3-web项目中，启动web主项目
		第四步：项目访问地址
				http://localhost/jeecg-p3-web

【代码生成器】

	1.工具类：jeecg-p3-web/src/main/java/util/P3CodeGenerateUtil.java
	2.配置文件：jeecg-p3-web/src/main/resources/p3-cg-config.properties
	
	
【标签用法】

	[1].下拉字典标签
		#selectDictTag("sex", "sex","")
		第一个参数 :类型组编码
		第二个参数 :id和name
		第三个参数 :默认值 
	[2].下拉表标签
		#selectTableTag("auth_id","auth_name","jw_auth","","");
		第1个参数 ：表字段（用于下拉选择value）
		第2个参数 ：表字段（用于下拉文本显示）
		第3个参数 ：表名
		第4个参数 ：id和name（页面控件）
		第5个参数 ：默认值
		
	[3].数据权限标签:页面元素权限控制
		#AuthFilterTag()
			  说明：无参数   ，在需要进行权限控制的页面最下面添加该标签（权限配置规则参考jeecg）
			  
	[4].数据权限标签:操作码权限控制
		#AuthOperateTag("myCode")
		//TODO 需要控制的页面代码
		#end
			说明：需要对上面的myCode操作码控制时,权限配置编码为 myCode



![github](http://www.jeecg.org/data/attachment/forum/201606/27/123504y69rv9zqxwevvv66.png "jeewx")
![github](http://static.oschina.net/uploads/space/2016/0424/131056_lr02_930898.png "jeewx")
![github](http://static.oschina.net/uploads/space/2016/0424/131105_BSlN_930898.png "jeewx")
![github](http://static.oschina.net/uploads/space/2016/0424/131036_oV7J_930898.png "jeewx")
![github](http://img.blog.csdn.net/20160424150826957?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center "jeewx")