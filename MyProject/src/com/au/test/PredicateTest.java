package com.au.test;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {

	public static void main(String[] args) {

		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);

		//Predicate<Integer> isEvenNumber = x -> x % 2 == 0;
		//Predicate<Integer> isOddNumber = x -> x % 2 == 1;

		Predicate<Integer> isEvenNumber2 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {

				return t % 2 == 0;
			}

		};
		
		Function<Integer, Integer> multiply = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer t) {
				return t * t;
			}

		};
		
		Function<Integer, Integer> multiply2 = x ->  {
				return x*x;
		};
		
		Consumer<Integer> consumer = new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				
				System.out.println("printing"+t);
								
			}
			
		};
		
		Consumer<Integer> consume = t -> {
			System.out.println("111--"+t);			
		};
		
		BinaryOperator<Integer> sumOfNum = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				// TODO Auto-generated method stub
				return t+u;
			}
			
		};

		filterUpdate(list, x -> x % 2 == 0, multiply, consume);
		filterUpdate(list, x -> x % 2 == 1, multiply, consume);
		
		Integer sum = list.stream().filter(isEvenNumber2).map(multiply).reduce(0,sumOfNum );
		System.out.println("sum value" + sum);
		
		 extracted(list, x->x*x).forEach(consume);
		extracted(list,x->x*x*x).forEach(consume);
		

	}

	private static List<Integer> extracted(List<Integer> list, Function<Integer, Integer> Function) {
		return list.stream().map(Function).collect(Collectors.toList());
	}

	private static void filterUpdate(List<Integer> list, Predicate<Integer> predicate,
			Function<Integer, Integer> multiply, Consumer<Integer> consumer) {
		list.stream().filter(predicate).map(multiply).forEach(consumer);
	}

}
