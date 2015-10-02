package com.vamsee.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PartialFileInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6638409466658821058L;

	@Id
	@Column(name="fileid")
	private Long fileId;
	
	@Column(name="filename")
	private String fileName;
	
	@Column(name="contenttype")
	private String contentType;
	
	@Column(name="filesize")
	private Long fileSize;

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	
	

}
