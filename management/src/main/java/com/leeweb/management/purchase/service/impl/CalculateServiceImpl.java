package com.leeweb.management.purchase.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leeweb.management.Properties;
import com.leeweb.management.purchase.dao.CalculateDao;
import com.leeweb.management.purchase.dto.CategoryDTO;
import com.leeweb.management.purchase.service.CalculateService;

@Service
public class CalculateServiceImpl implements CalculateService {

	Logger logger = LoggerFactory.getLogger(FileIOServiceImpl.class);

	@Autowired
	CalculateDao calculateDao;

	/**
	 * @author イーソンハク
	 * @return List<CategoryDTO> listTotalCategory
	 */
	@Override
	public List<CategoryDTO> calculateCategory() {
		System.out.println(Properties.SORTING_LINE);
		logger.info("Calculate serviceを実行します。");

		List<CategoryDTO> listTotalCategory = new ArrayList<>();
		listTotalCategory = calculateDao.calculateCategory();

		logger.info("Calculate serviceを終わります。");
		System.out.println(Properties.SORTING_LINE);
		return listTotalCategory;
	}
}
