package com.vamsee.service;

import java.util.List;

import com.vamsee.entities.File;
import com.vamsee.entities.PartialFileInfo;

public interface FileService {
public void persistFile(File file);
	
	public File getFileById(Long fileId);
	
	public List<PartialFileInfo> getallImages();
}
