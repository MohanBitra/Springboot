package com.au.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReplaceallTest {

	public static void main(String[] args) {
		
		List<String> listofStrings = List.of("string","struts","aws","gcp");
		
		listofStrings = new ArrayList<String>(listofStrings);
		
		System.out.println(listofStrings.stream().peek(System.out::println).collect(Collectors.joining()));
		
		System.out.println(listofStrings);


	}

}
