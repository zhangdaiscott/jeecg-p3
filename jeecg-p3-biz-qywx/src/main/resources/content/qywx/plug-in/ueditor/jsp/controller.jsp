<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter"
    pageEncoding="UTF-8"%>
<%

    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	
	String rootPath = application.getRealPath( "/" );
	
	
	//-update--begin--author:qinfeng----date:20151025---for:图片列表显示问题-----
	String action = request.getParameter("action");
	String result = new ActionEnter( request, rootPath ).exec();
	if( action!=null && 
	   (action.equals("listfile") || action.equals("listimage") ) ){
	    rootPath = rootPath.replace("\\", "/");
	    result = result.replaceAll(rootPath, "/");//把返回路径中的物理路径替换为 '/'
	}
	out.write( result );
	//out.write( new ActionEnter( request, rootPath ).exec() );
	//-update--end--author:qinfeng----date:20151025---for:图片列表显示问题-----
%>