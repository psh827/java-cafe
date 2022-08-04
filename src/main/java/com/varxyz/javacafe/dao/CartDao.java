package com.varxyz.javacafe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

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
		String sql = "INSERT INTO Cart (cId, menuItemName, ihb, menuPrice, imgName, buyCount)"
				+ " VALUE(?, ?, ?, ?, ?, ?)";
		System.out.println(cart.getIhb());
		
		try {
			jdbcTemplate.update(sql, cart.getCId(), cart.getMenuItemName(), 
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
			String sql = "SELECT * FROM Cart WHERE cId=?";
			return jdbcTemplate.queryForObject(sql, new RowMapper<Cart>() {

				@Override
				public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
					Cart cart = new Cart();
					cart.setCId(rs.getLong("cId"));
					cart.setMenuItemName(rs.getString("menuItemName"));
					cart.setIhb(rs.getString("ihb"));
					cart.setMenuPrice(rs.getInt("menuPrice"));
					cart.setImgName(rs.getString("imgName"));
					cart.setBuyCount(rs.getInt("butCount"));
					
					return cart;
				}
				
			}, cart.getCId());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
	}

}
