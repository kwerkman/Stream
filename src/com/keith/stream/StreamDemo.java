package com.keith.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDemo {
	public static ArrayList<Emp> arrayOfEmps = new ArrayList<Emp>();
	public static Emp emp;
	
	
	public static void main(String[] args) {

		arrayOfEmps.add(new Emp(1,"Keith", 100.));
		arrayOfEmps.add(new Emp(2,"Tam", 1000.));
		arrayOfEmps.add(new Emp(3,"Ryan", 10000.));
		
		arrayOfEmps.forEach(System.out::println);
		Stream.of(arrayOfEmps).forEach(System.out::println);
		
		
		};
		

}
