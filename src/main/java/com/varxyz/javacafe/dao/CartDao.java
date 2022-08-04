package com.varxyz.javacafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.javacafe.domain.Cart;

public class CartDao {
	
	JdbcTemplate jdbcTemplate;
	
	public CartDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int addCart(Cart cart) {
		String sql = "INSERT INTO Cart (menuItemName, ihb, menuPrice, imgName, buyCount)"
				+ " VALUE(?, ?, ?, ?, ?)";
		
		try {
			jdbcTemplate.update(sql, cart.getMenuItemName(), 
					cart.getIhb(), cart.getMenuPrice(), cart.getImgName(),
					cart.getBuyCount());
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
		
		
	}
	
	public Cart checkCart(Cart cart) {
		try {
			String sql = "SELECT * FROM Cart WHERE menuItemName=?";
			return jdbcTemplate.queryForObject(sql, new RowMapper<Cart>() {

				@Override
				public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
					Cart cart = new Cart();
					cart.setCId(rs.getLong("cId"));
					cart.setMenuItemName(rs.getString("menuItemName"));
					cart.setIhb(rs.getString("ihb"));
					cart.setMenuPrice(rs.getInt("menuPrice"));
					cart.setImgName(rs.getString("imgName"));
					cart.setBuyCount(rs.getInt("buyCount"));
					
					return cart;
				}
				
			}, cart.getMenuItemName());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public int updateCart(Cart cart) {
		String sql = "UPDATE Cart SET buyCount = buyCount + ? WHERE menuItemName=?";
		
		try {
			jdbcTemplate.update(sql, cart.getBuyCount(), cart.getMenuItemName());
			return 4;
			
		} catch (Exception e) {
			return 2;
		}
	}
	
	public List<Cart> getAllCart() {
		try {
			String sql = "SELECT * FROM Cart";
			return jdbcTemplate.query(sql, new RowMapper<Cart>() {

				@Override
				public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
					Cart cart = new Cart();
					cart.setCId(rs.getLong("cId"));
					cart.setMenuItemName(rs.getString("menuItemName"));
					cart.setIhb(rs.getString("ihb"));
					cart.setMenuPrice(rs.getInt("menuPrice"));
					cart.setImgName(rs.getString("imgName"));
					cart.setBuyCount(rs.getInt("buyCount"));
					
					return cart;
				}
				
			});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
