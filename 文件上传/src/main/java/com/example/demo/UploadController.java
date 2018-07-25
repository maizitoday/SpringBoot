package com.example.demo;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/22 上午11:12
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Controller
@Log4j2
public class UploadController {
	@RequestMapping("uploadView")
	public ModelAndView uploadView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("upload");
		return mav;
	}

	/***
	 * 上传文件
	 * 
	 * @param file
	 * @param request
	 */
	@RequestMapping("uploadAction")
	@ResponseBody
	public void uploadAction(MultipartFile file, HttpServletRequest request) {
		try {
			String fileName = file.getOriginalFilename();
			File imageFile = new File(  "/github/upload/" + fileName);
			if (!imageFile.exists()) {
				boolean flag = imageFile.createNewFile();
				if (flag) {
					file.transferTo(imageFile);
					log.info("文件上传完成");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("上传失败");
		}
	}
}
