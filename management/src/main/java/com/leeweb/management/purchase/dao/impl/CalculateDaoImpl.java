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
import com.leeweb.management.purchase.dao.CalculateDao;
import com.leeweb.management.purchase.dto.CategoryDTO;

@Repository
public class CalculateDaoImpl extends JdbcDaoSupport implements CalculateDao {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	/**
	 * @author イーソンハク
	 * @return List<CategoryDTO> listTotalCategory
	 */
	@Override
	public List<CategoryDTO> calculateCategory() {
		String selectCategory = "SELECT category, total FROM VIEW02_LEE";

		List<CategoryDTO> listTotalCategory
		= getJdbcTemplate().query(selectCategory, new CategoryMapper());

		return listTotalCategory;
	}

	//RowMapper interfaceの具現クラス
	public class CategoryMapper implements RowMapper<CategoryDTO>{

		/**
		 * @author イーソンハク
		 * @param ResultSet rs, int rowNum
		 * @return CategoryDTO categoryDTO
		 * @exception SQLException
		 */
		@Override
		public CategoryDTO mapRow(ResultSet rs, int rowNum) {
			CategoryDTO categoryDTO = new CategoryDTO();

			try {
				categoryDTO.setCATEGORY(rs.getString(Properties.TOTAL_CATEGORY[0]));
				categoryDTO.setTOTAL(rs.getDouble(Properties.TOTAL_CATEGORY[1]));
			}
			catch (SQLException e) {
				logger.debug(e + "エラーが発生しました。");
			}
			return categoryDTO;
		}
	}
}
