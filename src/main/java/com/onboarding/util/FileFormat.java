package com.onboarding.util;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.onboarding.exception.CustomRunTimeException;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class FileFormat{
	
	
	private FileFormat() {
		super();
	}

	public static boolean checkIsImage(MultipartFile file) {
		String originalFilename = file.getOriginalFilename();
		if (!file.isEmpty() && originalFilename != null) {
			String fileName = StringUtils.cleanPath(originalFilename).toUpperCase();
			return fileName.endsWith(".JPG") || fileName.endsWith(".JPEG") || fileName.endsWith(".PNG");
		}
		return false;
	}

	public static boolean checkIsPDF(MultipartFile file, String docType) {
		String originalFilename = file.getOriginalFilename();
		if (!file.isEmpty() && originalFilename != null) {
	        String fileName = StringUtils.cleanPath(originalFilename).toUpperCase();
	        return  fileName.endsWith(".PDF") && docType.equals("bill"); 
		}
		return false;
	}
	
	public static boolean checkIsPDF(Resource resource) {
		String originalFilename = resource.getFilename();
		if (resource.exists()&& originalFilename != null) {
	        String fileName = StringUtils.cleanPath(originalFilename).toUpperCase();
	        return  fileName.endsWith(".PDF");
		}
		return false;
	}
	
	public static String getFileName(MultipartFile file) {
		String originalFilename = file.getOriginalFilename();
		if (!file.isEmpty() && originalFilename != null) {
	        originalFilename = StringUtils.cleanPath(originalFilename).toUpperCase();
	        return  originalFilename;
		}
		return "";
	}
	
	public static String getFileExtension(MultipartFile file) {
		String originalFileName=file.getOriginalFilename();
		 try {
			 if (!file.isEmpty() && originalFileName != null) {
				 return originalFileName.substring(originalFileName.lastIndexOf("."));
			 }else {
				 throw new CustomRunTimeException("Cannot read the file extension");
			 }
      } catch(Exception e) {
            log.error(e.getMessage());throw new CustomRunTimeException("Invalid file extension");
      }
	}

}
