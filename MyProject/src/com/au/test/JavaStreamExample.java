package com.au.test;
import java.util.*;  
import java.util.stream.Collectors;  

public class JavaStreamExample {  
    /**
     * @param args
     */
    public static void main(String[] args) {  
        List<Product> productsList = new ArrayList<Product>();  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",(double) 25000));  
        productsList.add(new Product(2,"Dell Laptop",(double) 30000));  
        productsList.add(new Product(3,"Lenevo Laptop",(double) 28000));  
        productsList.add(new Product(4,"Sony Laptop",(double) 28000));  
        productsList.add(new Product(5,"Apple Laptop",(double) 90000));  
        List<Product> productPriceList2 =productsList.stream()  
                                     .filter(price -> price.getPrice() > 30000)// filtering data  
                                     //.map(p1->p1.price).peek(System.out::print)        // fetching price  
                                     .peek(System.out::println)
                                     .collect(Collectors.toList()); // collecting as list  
        
        int count = (int) productsList.stream().filter(p -> p.getPrice() > 30000).count();
        System.out.println(productPriceList2);  
        System.out.println(""+count);
        
        
        
    }  
} 