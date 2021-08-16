package com.cssl.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cssl.pojo.Users;
import com.cssl.service.UsersService;
import com.cssl.vo.UsersVo;

@Scope("singleton")
@Controller
public class UploadController  {
	
	private UsersService service;
	
	@Autowired
	public UploadController(UsersService service) {
		System.out.println("UploadController 构造："+service);
		this.service = service;
	}

	@Autowired
	private ServletContext application;
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("index...");
		return "aniwodw";
	}
		
	
	@PostMapping("/regist")
	public String regist(UsersVo uvo,BindingResult br) {
		
		if(br.hasErrors()) {
			return "index";
		}
		
		System.out.println("regist:"+uvo);
		//vo->pojo
		Users user = new Users();
		BeanUtils.copyProperties(uvo, user);
		
		//return "success";
		
		if(service.saveUsers(user)) {
			return "success";
		}
		return "index";
	}
	
	
	/**
	 * 文件上传
	 * @param title
	 * @param files
	 * @return
	 * @throws IOException 
	 */
	@PostMapping("/upload")
	public String upload(String title,MultipartFile[] files) throws IOException {
		System.out.println("upload:"+title+"\t"+files.length);
		//绝对路径		
		String path = application.getRealPath("/upload");
		System.out.println("path:"+path);
		List<String> types = Arrays.asList("image/jpeg","image/gif","image/png");
		
		
		for (MultipartFile file : files) {
			if(!file.isEmpty()) {
				if(types.contains(file.getContentType())) {
					String uuid = UUID.randomUUID().toString();
					System.out.println("type:"+file.getContentType());
					System.out.println("name:"+file.getOriginalFilename());
					System.out.println("size:"+file.getSize()+"byte");
					//固定绝对路径
					File df = new File("D:\\nginx\\static\\image\\"+file.getOriginalFilename());						

					file.transferTo(df);	
				}					
			}
		}
		
		
		
		return "success";
	}

	

	
}
