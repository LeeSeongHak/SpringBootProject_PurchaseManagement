package com.leeweb.management.purchase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.leeweb.management.purchase.dto.ProductDTO;
import com.leeweb.management.purchase.dto.PurchaseInfoDTO;
import com.leeweb.management.purchase.service.SearchService;

@RestController
public class SearchController {

	@Autowired
	SearchService searchService;

	/**
	 * @author イーソンハク
	 * @param ModelAndView mv
	 * @return ModelAndView mv
	 */
	@RequestMapping(value = "/SearchByUserView", method = RequestMethod.POST)
	public ModelAndView searchByUserView(ModelAndView mv) {
		mv.setViewName("/purchase/SearchByUser");
		return mv;
	}

	/**
	 * @author イーソンハク
	 * @param ModelAndView mv
	 * @return ModelAndView mv
	 */
	@RequestMapping(value = "/SearchByProductAndCategoryView", method = RequestMethod.POST)
	public ModelAndView fileUpload(ModelAndView mv) {
		mv.setViewName("/purchase/SearchByProductAndCategory");
		return mv;
	}

	/**
	 * @author イーソンハク
	 * @param String lastName
	 * @return List<PurchaseInfoDTO> listResult
	 */
	@RequestMapping(value = "searchByUserName", method = RequestMethod.POST)
	public List<PurchaseInfoDTO> searchByUserName(String lastName){
		List<PurchaseInfoDTO> listResult = new ArrayList<>();

		listResult = searchService.searchByUserName(lastName);

		return listResult;
	}

	/**
	 * @author イーソンハク
	 * @param String productID, String language
	 * @return ProductDTO productDTO
	 */
	@RequestMapping(value = "searchByProductID", method = RequestMethod.POST)
	public ProductDTO searchByProductID(String productID, String language){
		ProductDTO productDTO;

		productDTO = searchService.searchByProductID(productID, language);

		return productDTO;
	}
}
