package com.sft.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sft.Dao.TestDao;
import com.sft.Entity.Test;

@Controller
public class TestController {
	
	@Autowired
	TestDao testDao;
	
	@RequestMapping(value = "/test")
	public String getTestFile() {
		try {
//			map.put("document", new Document());
//			map.put("documentList", documentDao.list());
		}catch(Exception e) {
			e.printStackTrace();
		}

		return "test";
	}
	
	@RequestMapping(value = "/save")
	public String saveTestFile(@ModelAttribute("test") Test doc,@RequestParam("file") MultipartFile file) {
		
		try {

			Test t = new Test();
			t.setName(file.getOriginalFilename());
			t.setFilename(file.getName());
			t.setContent(file.getBytes());
			t.setContentType(file.getContentType());
			System.out.print("file saving ..");
			
			testDao.saveImg(t);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "test";
	}
	
	@RequestMapping(value = "/imges")
	public String getImages(HttpServletResponse respon, ModelMap model) {
		Test img = testDao.get(3);
		String base64String = Base64.getEncoder().encodeToString(img.getContent());
		model.addAttribute("imgCode", base64String);
		return "test";
	}

}
