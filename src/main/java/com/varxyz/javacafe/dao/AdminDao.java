package com.varxyz.javacafe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
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
		String sql = "INSERT INTO MenuItem (lcFk, menuItemName, menuPrice, ihb, description)"
				+ " VALUES(?, ?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator creator = (connection) -> {
			PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"mId"});
			pstmt.setLong(1, menuItem.getLargeCategory().getLcId());
			pstmt.setString(2, menuItem.getMenuItemName());
			pstmt.setInt(3, menuItem.getMenuPrice());
			pstmt.setString(4, String.valueOf(menuItem.getIhb()));
			pstmt.setString(5, String.valueOf(menuItem.getDescription()));
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
		String sql = "SELECT m.mId, m.menuItemName, m.menuPrice, m.ihb, m.outOfStock, l.largeCategoryName,"
				+ " i.imgUrl, i.imgName, m.regDate FROM MenuItem m INNER JOIN Image i ON m.mId = i.menuFk"
				+ " INNER JOIN LargeCategory l ON l.lcId = m.lcFk";
		
		return jdbcTemplate.query(sql, new RowMapper<MenuItem>() {

			@Override
			public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				MenuItem menuItem = new MenuItem(rs.getString("menuItemName"), rs.getInt("menuPrice"),
						rs.getString("ihb"), rs.getString("outOfStock").charAt(0), new LargeCategory(rs.getString("largeCategoryName")),
								new Image(rs.getString("imgUrl"), rs.getString("imgName")), rs.getTimestamp("regDate"));
				menuItem.setMenuid(rs.getLong("mId"));
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

	public LargeCategory isCate(LargeCategory largecategory) {
		try {
			String sql = "SELECT * FROM LargeCategory WHERE largeCategoryName = ?";
			return jdbcTemplate.queryForObject(sql, new RowMapper<LargeCategory>() {

				@Override
				public LargeCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
					LargeCategory lc = new LargeCategory();
					lc.setLcId(rs.getLong("lcId"));
					lc.setLargeCategoryName(rs.getString("largeCategoryName"));
					return lc;
				}
				
			}, largecategory.getLargeCategoryName());
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public MenuItem isMenuItem(MenuItem menuitem) {
		try {
			String sql = "SELECT * FROM MenuItem WHERE menuItemName = ?";
			return jdbcTemplate.queryForObject(sql, new RowMapper<MenuItem>() {

				@Override
				public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
					MenuItem menuItem = new MenuItem();
					menuItem.setMenuItemName(rs.getString("menuItemName"));
					menuItem.setIhb(rs.getString("ihb"));
					return menuItem;
				}
				
			}, menuitem.getMenuItemName());
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public int deleteMenuByMenuItemName(long menuid) {
		String sql = "DELETE i FROM Image i INNER JOIN MenuItem m ON i.menuFk = m.mId WHERE m.mId=?";
		String sql2 = "DELETE FROM MenuItem WHERE mId=?";
		try {
			jdbcTemplate.update(sql, menuid);
			jdbcTemplate.update(sql2, menuid);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	

}
