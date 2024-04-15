package com.onboarding.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.onboarding.exception.CustomRunTimeException;
import com.onboarding.exception.FileStorageException;

@Service
public class FileUploadUtil {
	
	
	private FileUploadUtil() {
		super();
	}

	

	private static void createFileDireactory(Path filePath) {
		try {
            Files.createDirectories(filePath);
      }catch (Exception ex) {
         throw new FileStorageException("Could not create upload dir!");
      }	
	}

	public static String saveFileToLocal(MultipartFile file, String docType, String fileType) {
		
		Path filePath;
		try {
			Path path=Paths.get(fileType).toAbsolutePath().normalize();
			filePath=path.resolve(path);//
			if(!Files.exists(filePath)) {
				createFileDireactory(filePath);//O
			}
	    	Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		}catch (Exception exception) {
			throw new CustomRunTimeException("File not save in local"+exception);
		}
		return filePath.toString();
	

		
		
	}
	
	
	
	
	
	
	
	
	
	

}
