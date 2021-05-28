package aplication;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department obj = new Department(1, "books");
		Seller seller = new Seller("luis", "@gmail.com", new Date(), 3000.0, 1, obj);
		
		System.out.println(seller);

	}

}
