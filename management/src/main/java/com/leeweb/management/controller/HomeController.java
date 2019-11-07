package com.leeweb.management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

	/**
	 * @author イーソンハク
	 * @param ModelAndView mv
	 * @return ModelAndView mv
	 */
	@RequestMapping(value = "/")
	public ModelAndView home(ModelAndView mv) {

		//throw new RuntimeException();

		mv.setViewName("Home");
		return mv;
	}
}
