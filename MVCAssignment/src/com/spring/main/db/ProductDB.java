package com.spring.main.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.main.model.Product;

@Component
public class ProductDB {
	private NamedParameterJdbcTemplate jdbc;
	private DataSource dataSource;

	@Autowired
	public void setDatasource(DataSource dataSource) {
		jdbc = new NamedParameterJdbcTemplate(dataSource);

	}

	public List<Product> fetchAllProducts() {
		String sql = "select * from product";
		return jdbc.query(sql, new ABC());

	}

	public void insertProduct(Product product) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", product.getName());
		map.put("price", product.getPrice());
		map.put("description", product.getDescription());
		map.put("category", product.getCategory());
		String sql = "insert into product(name,price,description,category) values(:name, :price, :description, :category)";
		jdbc.update(sql, map);

	}

	public void deleteProduct(Integer id) {
		Map<String, Integer> map = new HashMap<>();
		map.put("id", id);

		String sql = "delete from product where id=:id";
		jdbc.update(sql, map);

	}

	public void processedit(Product product) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", product.getId());
		map.put("name", product.getName());
		map.put("price", product.getPrice());
		map.put("description", product.getDescription());
		map.put("category", product.getCategory());
		String sql = "update product SET name=:name,price=:price,description=:description,category=:category where id=:id";
		jdbc.update(sql, map);

	}

}

class ABC implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rst, int rowNum) throws SQLException {
		Product p = new Product();
		p.setId(rst.getInt("id"));
		p.setName(rst.getString("name"));
		p.setPrice(rst.getDouble("price"));
		p.setDescription(rst.getString("description"));
		p.setCategory(rst.getString("category"));
		return p;
	}
}
