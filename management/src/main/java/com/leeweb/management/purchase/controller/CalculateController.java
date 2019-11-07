package com.leeweb.management.purchase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.leeweb.management.purchase.dto.CategoryDTO;
import com.leeweb.management.purchase.service.CalculateService;

@RestController
public class CalculateController {

	@Autowired
	CalculateService calculateService;

	/**
	 * @author イーソンハク
	 * @param ModelAndView mv
	 * @return ModelAndView mv
	 */
	@RequestMapping(value = "/CalculateByCategoryView", method = RequestMethod.POST)
	public ModelAndView calculateByCategoryView(ModelAndView mv) {
		mv.setViewName("/purchase/CalculateByCategory");
		return mv;
	}

	/**
	 * @author イーソンハク
	 * @return List<CategoryDTO> listTotalCategory
	 */
	@RequestMapping(value = "CalculateCategory", method = RequestMethod.POST)
	public List<CategoryDTO> calculateCategory(){
		List<CategoryDTO> listTotalCategory = new ArrayList<>();

		listTotalCategory = calculateService.calculateCategory();

		return listTotalCategory;
	}
}