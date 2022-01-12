package com.au.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FPFilesTest {

	public static void main(String[] args) {

		try {
			Files.lines(Paths.get("C:\\Users\\Mohan\\eclipse-workspace\\MyProject\\Test")).map(str -> str)
					.forEach(System.out::println);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		System.out.println("--------------");
		
		

	}

}
