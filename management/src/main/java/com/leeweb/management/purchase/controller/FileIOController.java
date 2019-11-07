package com.leeweb.management.purchase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.leeweb.management.purchase.service.FileIOService;

@RestController
public class FileIOController {

	@Autowired
	FileIOService fileIOService;

	/**
	 * @author イーソンハク
	 * @param ModelAndView mv
	 * @return ModelAndView mv
	 */
	@RequestMapping(value = "/FileUploadView", method = RequestMethod.POST)
	public ModelAndView fileUploadView(ModelAndView mv) {
		mv.setViewName("/purchase/FileUpload");
		return mv;
	}

	/**
	 * @author イーソンハク
	 * @param String filePath
	 * @return String msg
	 */
	@RequestMapping(value = "InsertFile", method = RequestMethod.POST)
	public String insertFile(String filePath) {

		String msg = fileIOService.insertFile(filePath);

		return msg;
	}
}
