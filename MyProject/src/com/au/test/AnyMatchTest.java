package com.au.test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnyMatchTest {

	public static void main(String[] args) {
		
		List <Product> listProduct = List.of(
				new Product(100, "Spring", (double) 100),
				new Product(10, "AWS", (double) 88),
				new Product(30, "Azure", (double) 77),
				new Product(120, "GCP", (double) 98)
				);
		
		System.out.println(listProduct.stream().allMatch(Product -> Product.getPrice()>10));
		System.out.println(listProduct.stream().anyMatch(Product -> Product.getPrice()>80));
		System.out.println(listProduct.stream().noneMatch(Product -> Product.getPrice()>10));
		
		Comparator<Product> comparator = Comparator.comparingInt(Product->Product.getId());
		Comparator<Object> comparatorreverse = Comparator.comparingInt(Product->((com.au.test.Product) Product).getId()).reversed();
		listProduct.stream().sorted(comparatorreverse).collect(Collectors.toList()).forEach(System.out::println);
		
		
		System.out.println(listProduct.stream().filter(Product -> Product.getPrice()>89).max(comparatorreverse));
		
		System.out.println(listProduct.stream().filter(Product -> Product.getPrice()>89).min(comparatorreverse));
		
		System.out.println("---");
		
		System.out.println(listProduct.stream().sorted(comparatorreverse).min(comparator));
		
		System.out.println(listProduct.stream().min(comparator));
		
		System.out.println(listProduct.stream().max(comparator));
		
		System.out.println(listProduct.stream().findFirst());
		
		System.out.println(listProduct.stream().findAny());
		
		System.out.println("---");
		
		
		System.out.println(listProduct.stream().mapToInt(Product -> Product.getId()).max());
		System.out.println(listProduct.stream().mapToInt(Product -> Product.getId()).min());
		System.out.println(listProduct.stream().mapToInt(Product -> Product.getId()).sum());
		System.out.println(listProduct.stream().mapToInt(Product -> Product.getId()).count());
		System.out.println(listProduct.stream().mapToInt(Product -> Product.getId()).average());
		
		
		
		
		

	}

}
