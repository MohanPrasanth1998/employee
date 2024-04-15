package com.onboarding.response;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadFileResponse {
	
	private Date timeStamp;
	private String message;
	private String docName;
	private String fileType;
	private String fileName;
	private String fileDownloadUri;
	private HttpStatus status;
	
	
	
	public UploadFileResponse(Date timeStamp, String message,String fileName,
			String fileDownloadUri, String fileType,HttpStatus status) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.status = status;
	}

}
