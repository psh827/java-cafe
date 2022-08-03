package com.varxyz.javacafe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.varxyz.javacafe.domain.Image;
import com.varxyz.javacafe.domain.LargeCategory;
import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.provider.CategoryProvider;

public class AdminDao {

	private JdbcTemplate jdbcTemplate;
	
	public AdminDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public long addProduct(MenuItem menuItem) {
		String sql = "INSERT INTO MenuItem (lcFk, menuItemName, menuPrice, ihb)"
				+ " VALUES(?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator creator = (connection) -> {
			PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"mId"});
			pstmt.setLong(1, 1001);
			pstmt.setString(2, menuItem.getMenuItemName());
			pstmt.setInt(3, menuItem.getMenuPrice());
			pstmt.setNString(4, String.valueOf(menuItem.getIhb()));
			
			return pstmt;
		};
		jdbcTemplate.update(creator, keyHolder);
		System.out.println("상품등록완료 mId=" + keyHolder.getKey().longValue());
		return keyHolder.getKey().longValue();
	}
	
	

	public void addProductImg(long menuId, Image img) {
		String sql = "INSERT INTO Image (menuFk, imgName, imgOriname, imgUrl)"
				+ " VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, menuId, img.getImgName(), img.getImgOriName(), img.getImgUrl());
		System.out.println("이미지 저장완료");
	}

	public boolean addCategory(LargeCategory largeCategory) {
		String sql = "INSERT INTO LargeCategory (largeCategoryName) VALUE (?)";
		boolean result = true;
		try {
			jdbcTemplate.update(sql, largeCategory.getLargeCategoryName());
		} catch (Exception e) {
			result = false;
		}
		
		return result;
	}

	public List<MenuItem> viewAllMenu() {
		String sql = "SELECT m.menuItemName, m.menuPrice, m.ihb, m.outOfStock, l.largeCategoryName,"
				+ " i.imgUrl, i.imgName, m.regDate FROM MenuItem m INNER JOIN Image i ON m.mId = i.menuFk"
				+ " INNER JOIN LargeCategory l ON l.lcId = m.lcFk";
		
		return jdbcTemplate.query(sql, new RowMapper<MenuItem>() {

			@Override
			public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				MenuItem menuItem = new MenuItem(rs.getString("menuItemName"), rs.getInt("menuPrice"),
						rs.getString("ihb").charAt(0), rs.getString("outOfStock").charAt(0), new LargeCategory(rs.getString("largeCategoryName")),
								new Image(rs.getString("imgUrl"), rs.getString("imgName")), rs.getTimestamp("regDate"));
				return menuItem;
			}
			
		});
	}

	public List<CategoryProvider> getCategory(){
		String sql = "SELECT * FROM LargeCategory";
		return jdbcTemplate.query(sql, new RowMapper<CategoryProvider>() {

			@Override
			public CategoryProvider mapRow(ResultSet rs, int rowNum) throws SQLException {
				CategoryProvider cp = new CategoryProvider(rs.getLong("lcId"), rs.getString("largeCategoryName"));
				return cp;
			}
		});
	}

}
