package com.jeecg.cms.web;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jeecg.cms.util.ContextHolderUtils;

 /**
 * 描述：</b>CmsUploadController<br>
 * @author p3.jeecg
 * @since：2016年06月13日 15时00分30秒 星期一 
 * @version:1.0
 */
@Controller
@RequestMapping("/p3/cms/upload")
public class CmsUploadController extends BaseController{
  
  @RequestMapping(value = "doUpload",method ={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public AjaxJson doUpload(MultipartHttpServletRequest request,HttpServletResponse response){
		AjaxJson j = new AjaxJson();
		try {
			MultipartFile uploadify = request.getFile("file");
	        byte[] bytes = uploadify.getBytes();  
	        String realFilename=uploadify.getOriginalFilename();
	        String fileNoExtension = realFilename.substring(0,realFilename.lastIndexOf("."));
	        String fileExtension = realFilename.substring(realFilename.lastIndexOf("."));
	        String filename=fileNoExtension+System.currentTimeMillis()+fileExtension;
	        
	        StringBuffer path = new StringBuffer();
	        path.append("upload");
	        path.append(File.separator);
	        path.append("img");
	        path.append(File.separator);
	        path.append("cms");
	        
	        String uploadDir = ContextHolderUtils.getRequest().getSession().getServletContext().getRealPath(path.toString());   
	        File dirPath = new File(uploadDir);  
	        if (!dirPath.exists()) {  
	            dirPath.mkdirs();  
	        }
	        
	        File uploadedFile = new File(uploadDir + File.separator + filename);  
	        FileCopyUtils.copy(bytes, uploadedFile); 
	        j.setObj(filename);
	        j.setSuccess(true);
			j.setMsg("保存成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("保存失败");
		}
		System.out.println(j.getObj());
		return j;
	}
}

