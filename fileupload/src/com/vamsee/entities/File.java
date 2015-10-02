package com.vamsee.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@NamedNativeQueries({
	@NamedNativeQuery(name = "getAllImages", query = "SELECT fileid, filename, contenttype, filesize  FROM file",resultClass=PartialFileInfo.class)
})
@Entity
@Table(name="file")
public class File implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2779246938248755595L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fileid")
	private Long fileId;
	
	@Column(name="filename")
	private String fileName;
	
	@Lob
	@Type(type="org.hibernate.type.BinaryType")
	@Column(name="filedata")
	private byte[] filedata;
	
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

	public byte[] getFiledata() {
		return filedata;
	}

	public void setFiledata(byte[] filedata) {
		this.filedata = filedata;
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

	public File( String fileName, byte[] filedata,
			String contentType, Long fileSize) {
		super();
		
		this.fileName = fileName;
		this.filedata = filedata;
		this.contentType = contentType;
		this.fileSize = fileSize;
	}

	public File() {
		super();
	}
	}