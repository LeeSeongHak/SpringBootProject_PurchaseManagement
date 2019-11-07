package com.leeweb.management.purchase.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.leeweb.management.purchase.dao.FileIODao;
import com.leeweb.management.purchase.dto.FileDTO;


@Repository
public class FileIODaoImpl extends JdbcDaoSupport implements FileIODao{

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	/**
	 * @author イーソンハク
	 * @param List<FileDTO> readDataList
	 */
	@Override
	public void insertFile(List<FileDTO> readDataList) {
		for(int i = 0; i < readDataList.size(); i++) {
			int count = getJdbcTemplate().queryForObject("SELECT count(*) + 1 FROM purchase", Integer.class);

			//Check ProductID
			String lastProductID = getJdbcTemplate().queryForObject("SELECT purchase_id FROM purchase ORDER BY purchase_id DESC LIMIT 1 ", String.class);


			String lastText = lastProductID.substring(lastProductID.length() -2, lastProductID.length() - 1);

			String newProductID;
			if(lastProductID.length() == 0) {
				newProductID = "PC000000";
			}

			else {
				//Check of letter before zero
				int idx = lastProductID.indexOf("0");
				newProductID = lastProductID.substring(0, idx);

				//Count of zero in ProductID
				int countZero = StringUtils.countMatches(lastProductID, "0");

				//Check last letter
				if(lastText.equals("0")) {
					countZero -= 1;
				}

				//Add zero in newProductID
				for(int j = 0; j < countZero; j++) {
					newProductID += 0;
				}
			}

			//Insert in DB
			String insertData = "INSERT INTO purchase " + "(purchase_id, product_id, quantity, create_user, update_user) VALUES(?, ?, ?, ?, ?)";
			getJdbcTemplate().update(insertData, new Object[] {
					newProductID + count
					, readDataList.get(i).getPRODUCT_ID()
					, readDataList.get(i).getQUANTITY()
					, readDataList.get(i).getCREATE_USER()
					, readDataList.get(i).getUPDATE_USER()});
		}
	}
}
