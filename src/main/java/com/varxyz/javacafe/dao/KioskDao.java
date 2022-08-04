package com.varxyz.javacafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.javacafe.domain.Image;
import com.varxyz.javacafe.domain.LargeCategory;
import com.varxyz.javacafe.domain.MenuItem;

public class KioskDao {
	
	JdbcTemplate jdbcTemplate;
	
	public KioskDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<LargeCategory> getCategoryToKiosk(){
		String sql = "SELECT * FROM LargeCategory";
		return jdbcTemplate.query(sql, new RowMapper<LargeCategory>() {

			@Override
			public LargeCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
				LargeCategory lc = new LargeCategory();
				lc.setLcId(rs.getLong("lcId"));
				lc.setLargeCategoryName(rs.getString("largeCategoryName"));
				return lc;
			}
		});
	}
	
	/**
	 * 
	 * @return
	 */
	
	public List<MenuItem> getAllMenuToKiosk(long lcFk){
		String sql = "SELECT m.mId, m.lcFk, m.menuItemName, m.menuPrice, m.ihb, m.description,"
				+ " i.imgUrl, i.imgName, l.lcId, l.largeCategoryName"
				+ " FROM MenuItem m INNER JOIN Image i ON m.mId = i.menuFk"
				+ " INNER JOIN LargeCategory l ON m.lcFk = l.lcId WHERE m.lcFk=?";
		
		return jdbcTemplate.query(sql, new RowMapper<MenuItem>() {

			@Override
			public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				MenuItem menuItem = new MenuItem();
				menuItem.setMenuid(rs.getLong("mId"));
				menuItem.setLcFk(rs.getLong("lcFk"));
				menuItem.setMenuItemName(rs.getString("menuItemName"));
				menuItem.setMenuPrice(rs.getInt("menuPrice"));
				menuItem.setIhb(rs.getString("ihb"));
				menuItem.setDescription(rs.getString("description"));
				menuItem.setImage(new Image(rs.getString("imgUrl"), rs.getString("imgName")));
				menuItem.setLargeCategory(new LargeCategory(rs.getString("largeCategoryName")));
				
				return menuItem;
			}
		}, lcFk);
		
	}
	
	public MenuItem getMenuItemByImgName(String imgName) {
		String sql = "SELECT m.mId, m.lcFk, m.menuItemName, m.menuPrice, m.ihb, m.description, i.imgUrl, i.imgName FROM MenuItem m"
				+ " INNER JOIN Image i ON m.mId = i.menuFk WHERE i.imgName=?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<MenuItem>() {

			@Override
			public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				MenuItem menuItem = new MenuItem();
				menuItem.setMenuid(rs.getLong("mId"));
				menuItem.setLcFk(rs.getLong("lcFk"));
				menuItem.setMenuItemName(rs.getString("menuItemName"));
				menuItem.setMenuPrice(rs.getInt("menuPrice"));
				menuItem.setIhb(rs.getString("ihb"));
				menuItem.setDescription(rs.getString("description"));
				menuItem.setImage(new Image(rs.getString("imgUrl"), rs.getString("imgName")));
				return menuItem;
			}
			
		}, imgName);
	}
}
