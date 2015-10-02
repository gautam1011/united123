package com.vamsee.dao;

import java.util.List;

import com.vamsee.entities.File;
import com.vamsee.entities.PartialFileInfo;

public interface FileDao {

	public void persistFile(File file);
	
	public File getFileById(Long fileId);
	
	public List<PartialFileInfo> getallImages();

}
