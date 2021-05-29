package aplication;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(1);
		System.out.println(seller);

		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department department = new Department(4, null);
		List<Seller> list = sellerDao.findByDepatment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 4: seller Insert ===");

		Seller newSeller = new Seller("luk", "Luk@gmail", new Date(), 3000.0, null, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id: " + newSeller.getId());

		System.out.println("\n=== TEST 5: seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha waine");
		sellerDao.update(seller);
		System.out.println("update complete!");

		System.out.println("\n=== TEST 6: seller Delete ===");
		System.out.println("Id to delete: ");
		int id = sc.nextInt();
		sellerDao.delete(id);
		

		sc.close();
	}

}
