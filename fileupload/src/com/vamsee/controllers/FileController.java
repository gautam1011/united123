package com.vamsee.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.vamsee.entities.File;
import com.vamsee.service.FileService;

@Controller
public class FileController {
	@Autowired
	private FileService fileService;
	
	@Autowired
	private WebApplicationContext applicationContext;
	
	@Autowired
	private TaskExecutor taskExecutor;
	
@RequestMapping(value="/",method=RequestMethod.GET)
public ModelAndView getFileUploadPage(){
		return new ModelAndView("singlefile").addObject("albumId", 10L);
	}
	
@RequestMapping(value="/multifileupload",method=RequestMethod.POST)
public void multiuploadFilePage( @RequestParam("file") MultipartFile file,HttpServletResponse response,@RequestParam("albumId")Long albumId ){
	
	System.out.println("albumId >> "+albumId);
	try {
		FileHandler fh = (FileHandler) applicationContext.getBean("filehandler");
		fh.setFileInfo(file.getOriginalFilename(), file.getBytes(), file.getContentType(), file.getSize());
		taskExecutor.execute(fh);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	response.setStatus(HttpServletResponse.SC_OK);
}
		
@RequestMapping(value="/image/{imageId}")
public void displayImage(@PathVariable("imageId") Long imageId, HttpServletResponse response){
	
	File file = fileService.getFileById(imageId);
	response.setContentLengthLong(file.getFileSize());
	response.setContentType(file.getContentType());
	try {
		response.getOutputStream().write(file.getFiledata());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			response.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	@RequestMapping(value="/images",method=RequestMethod.GET)
	public ModelAndView getAllPictures(){
		return new ModelAndView("allimages").addObject("images", fileService.getallImages());
		
	}
}
