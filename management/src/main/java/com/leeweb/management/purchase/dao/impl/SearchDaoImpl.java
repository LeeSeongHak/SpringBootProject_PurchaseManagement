package com.leeweb.management.purchase.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.leeweb.management.Properties;
import com.leeweb.management.purchase.dao.SearchDao;
import com.leeweb.management.purchase.dto.ProductDTO;
import com.leeweb.management.purchase.dto.PurchaseInfoDTO;

@Repository
public class SearchDaoImpl extends JdbcDaoSupport implements SearchDao{

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	/**
	 * @author イーソンハク
	 * @param String lastName
	 * @return List<PurchaseInfoDTO> listResult
	 */
	@Override
	public List<PurchaseInfoDTO> searchByUserName(String lastName){
		String selectPurchaseInfoByUser = "SELECT product_id, create_user, create_time FROM searchUserProc("+"'" + lastName + "'" +") ORDER BY product_id";

		List<PurchaseInfoDTO> listResult = getJdbcTemplate().query(selectPurchaseInfoByUser, new selectPurchaseInfoByUserMapper());

		return listResult;
	}

	//RowMapper interfaceの具現クラス
	public class selectPurchaseInfoByUserMapper implements RowMapper<PurchaseInfoDTO>{

		/**
		 * @author イーソンハク
		 * @param ResultSet rs, int rowNum
		 * @return PurchaseInfoDTO purchaseInfoDTO
		 * @exception SQLException
		 */
		@Override
		public PurchaseInfoDTO mapRow(ResultSet rs, int rowNum) {
			PurchaseInfoDTO purchaseInfoDTO = new PurchaseInfoDTO();

			try {
				purchaseInfoDTO.setPRODUCT_ID(rs.getString(Properties.PURCHASEINFO_BYUSER[0]));
				purchaseInfoDTO.setCREATE_USER(rs.getString(Properties.PURCHASEINFO_BYUSER[1]));
				purchaseInfoDTO.setCREATE_TIME(rs.getString(Properties.PURCHASEINFO_BYUSER[2]));
			}
			catch (SQLException e) {
				logger.debug(e + "エラーが発生しました。");
			}
			return purchaseInfoDTO;
		}
	}

	/**
	 * @author イーソンハク
	 * @param String productID, String language
	 * @return ProductDTO productDTO
	 */
	@Override
	public ProductDTO searchByProductID(String productID, String language){

		String selectProductNameByProductID;
		ProductDTO productDTO = null;

		int checkExistProductID = getJdbcTemplate().queryForObject("SELECT count(*) FROM VIEW05_LEE WHERE product_id =" + "'" + productID +"'", Integer.class);

		if(checkExistProductID == 0) {
			return productDTO;
		}

		selectProductNameByProductID = "SELECT product_id, product_name_ja, product_name_en, category_id,  category_name_ja, category_name_en FROM VIEW05_LEE WHERE product_id = ?";

		if(language.equals("ja")) {
			productDTO = getJdbcTemplate().queryForObject(selectProductNameByProductID, new Object[] {productID}, new jaProductIDMapper());
		}
		else {
			productDTO = getJdbcTemplate().queryForObject(selectProductNameByProductID, new Object[] {productID}, new enProductIDMapper());
		}
		return productDTO;
	}

	//RowMapper interfaceの具現クラス
	public class jaProductIDMapper implements RowMapper<ProductDTO>{

		/**
		 * @author イーソンハク
		 * @param ResultSet rs, int rowNum
		 * @return ProductDTO productDTO
		 * @exception SQLException
		 */
		@Override
		public ProductDTO mapRow(ResultSet rs, int rowNum) {
			ProductDTO productDTO = new ProductDTO();
			try {
				productDTO.setPRODUCT_ID(rs.getString("product_id"));
				productDTO.setPRODUCT_NAME(rs.getString("product_name_ja"));
				productDTO.setCATEGORY_NAME(rs.getString("category_name_ja"));
			}
			catch (SQLException e) {
				logger.debug(e + "エラーが発生しました。");
			}
			return productDTO;
		}
	}

	//RowMapper interfaceの具現クラス
	public class enProductIDMapper implements RowMapper<ProductDTO>{

		/**
		 * @author イーソンハク
		 * @param ResultSet rs, int rowNum
		 * @return ProductDTO productDTO
		 * @exception SQLException
		 */
		@Override
		public ProductDTO mapRow(ResultSet rs, int rowNum) {
			ProductDTO productDTO = new ProductDTO();
			try {
				productDTO.setPRODUCT_ID(rs.getString("product_id"));
				productDTO.setPRODUCT_NAME(rs.getString("product_name_en"));
				productDTO.setCATEGORY_NAME(rs.getString("category_name_en"));
			}
			catch (SQLException e) {
				logger.debug(e + "エラーが発生しました。");
			}
			return productDTO;
		}
	}
}
