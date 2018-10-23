Jeecg-P3 微服务框架
==========
特点：微服务插件式开发，业务组件以JAR方式提供、松耦合可插拔支持独立部署，也可以无缝集成Jeecg平台

当前版本：1.0.0（重构版本 | 发布日期：20180531）


#### 项目说明

	jeecg-p3-starter-parent        | 父POM（管理公共资源版本号）
	jeecg-p3-starter-web           | 启动主项目
	jeecg-p3-generator-project 	   | 项目骨架生成工具
	jeecg-p3-core-ui			   | UI依赖（h+、jquery等等第三方UI依赖）
    jeecg-p3-biz-helloworld        | 第一个插件例子


	
#### 架构说明

    1.Jeecg-P3技术架构
	    MVC层 ： SpringMvc_4.0.9.RELEASE
		持久层： Minidao_1.6.4
		View层： Velocity_1.6.4
		UI 层 ： H+、Bootstrap、Jquery
	
	2.通过eclipse启动项目
	  选中项目，右键采用maven方式，输入命令 tomcat:run 启动Web项目
	  
      http://localhost/jeecg-p3-report-web
	  
    4.页面层面采用模板语言Velocity，不能采用jsp
    5.每个业务组件以jar包方式提供

	
	
#### 技术交流

* 入门文档：[http://jeecg-p3.mydoc.io](http://jeecg-p3.mydoc.io)
* 入门视频：[http://jeecg-p3.mydoc.io/?t=292669](http://jeecg-p3.mydoc.io/?t=292669)
* QQ技术交流群: 286263896
* 下载更多插件：[http://yun.jeecg.org](http://yun.jeecg.org)

	
#### 效果图：
![github](http://www.jeecg.org/data/attachment/forum/201606/27/123504y69rv9zqxwevvv66.png "jeewx")
![github](http://static.oschina.net/uploads/space/2016/0424/131105_BSlN_930898.png "jeewx")