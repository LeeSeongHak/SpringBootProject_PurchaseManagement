package com.leeweb.management.purchase.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leeweb.management.Properties;
import com.leeweb.management.purchase.dao.SearchDao;
import com.leeweb.management.purchase.dto.ProductDTO;
import com.leeweb.management.purchase.dto.PurchaseInfoDTO;
import com.leeweb.management.purchase.service.SearchService;

@Service
public class SearchServiceImpl  implements  SearchService{

	Logger logger = LoggerFactory.getLogger(FileIOServiceImpl.class);

	@Autowired
	SearchDao searchDao;

	/**
	 * @author イーソンハク
	 * @param String lastName
	 * @return List<PurchaseInfoDTO> listResult
	 */
	@Override
	public List<PurchaseInfoDTO> searchByUserName(String lastName){
		System.out.println(Properties.SORTING_LINE);
		logger.info("姓による検索機能を実行します。");

		List<PurchaseInfoDTO> listResult = new ArrayList<>();

		listResult = searchDao.searchByUserName(lastName);

		logger.info("検索機能を終わります。");
		System.out.println(Properties.SORTING_LINE);
		return listResult;
	}

	/**
	 * @author イーソンハク
	 * @param String productID, String language
	 * @return ProductDTO productDTO
	 */
	@Override
	public ProductDTO searchByProductID(String productID, String language){
		System.out.println(Properties.SORTING_LINE);
		logger.info("ProductIDによる検索機能を実行します。");

		ProductDTO productDTO;

		productDTO = searchDao.searchByProductID(productID, language);

		logger.info("ProductIDによる検索機能を実行します。");
		System.out.println(Properties.SORTING_LINE);
		return productDTO;
	}
}
