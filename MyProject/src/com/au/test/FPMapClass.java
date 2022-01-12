package com.au.test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FPMapClass {

	public static void main(String[] args) {
		
		// Print the odd number and even numbers
		
		List<Integer> list =List.of(1,2,3,4,5,6,7,8);
		
		list.stream().filter(n->n%2!=0).forEach(n -> System.out.println(n));
		
		list.stream().filter(num -> num % 2 == 0 ).forEach(System.out::println);//filter
		list.stream().filter(n->n%2!=0).forEach(System.out::println);
		
		
		list.stream().map(n -> n*n).forEach(System.out::println);//method reference
		
		list.stream().forEach(n -> System.out.println(n));
		
		list.stream().reduce(0, (x,y) ->x+y);
		System.out.println(""+list.stream().reduce(0, (x,y) ->x+y));
		
		list.stream().reduce(Integer.MAX_VALUE, (x,y) -> x>y ? y : x);
		
		System.out.println("max value--"+list.stream().reduce(Integer.MAX_VALUE, (x,y) -> x>y ? y : x));
		System.out.println("min value--"+list.stream().reduce(Integer.MIN_VALUE, (x,y) -> x>y ? x : y));
		
		list.stream().reduce(0,FPMapClass::sum );
		
		int sum = list.stream().map(n -> n*n).reduce(0, (x,y)->x+y);
		System.out.println(""+sum);
		
		int sumofOddNumnbers = list.stream().filter(x -> x%2!=0).reduce(0,(x,y)->(x+y));
		System.out.println("sumofOddNumnbers"+sumofOddNumnbers);
		
		List<String> couses = List.of("API","Spring","Micro","services","boot","maven","git");
		couses.stream().sorted(Comparator.comparing(x->x.length())).forEach(System.out::println);
		couses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		list.stream().distinct().forEach(System.out::println);
		System.out.println("---------");
		List<Integer> li = list.stream().filter(x -> x%2==0).collect(Collectors.toList());
		li.forEach(System.out::println);
		System.out.println("---------");
		List<Integer> lencour = couses.stream().map(x -> x.length()).collect(Collectors.toList());
		lencour.forEach(System.out::println);
		
	}
	
	private static int sum(int x, int y) {
		System.out.println(0+ "---"+x + "," + y + "---"+ (x>y ? x : y ));
		
		return  x>y ? x : y;
	}

}
