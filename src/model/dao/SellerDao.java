package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {

	void insert(Seller obj);
	void delete(Integer id);
	void update(Seller obj);
	Seller findById(Integer id);
	List<Seller> findAll();
	
}
