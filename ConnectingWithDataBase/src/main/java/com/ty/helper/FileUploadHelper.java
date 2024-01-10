package com.ty.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	//public final String UPLOAD_DIR="C:\\Users\\ayush\\Documents\\workspace-spring-tool-suite-4-4.19.1.RELEASE\\ConnectingWithDataBase\\src\\main\\resources\\static";
	public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();
	public FileUploadHelper() throws IOException
	{
		
	}
	public boolean uplaodfile(MultipartFile k)
	{
		boolean f=false;
		try
		{
			InputStream h=k.getInputStream();
			byte b[]=new byte[h.available()];
			h.read(b);
			FileOutputStream fs=new FileOutputStream(UPLOAD_DIR+File.separator+k.getOriginalFilename());
			fs.write(b);
			fs.flush();
			fs.close();
			f=true;
			
			
		}
		catch(Exception e)
		{
			
		}
		return f;
		
	}

}
