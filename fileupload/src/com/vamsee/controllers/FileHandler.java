package com.vamsee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vamsee.entities.File;
import com.vamsee.service.FileService;

@Component("filehandler")
@Scope("prototype")
public class FileHandler implements Runnable{
	
	@Autowired
	private FileService fileSevice;
	
	private File file;
	

	public void  setFileInfo(String fileName, byte[] filedata,
			String contentType, Long fileSize){
		this.file = new File( fileName, filedata, contentType, fileSize);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		fileSevice.persistFile(file);
		
	}

}
