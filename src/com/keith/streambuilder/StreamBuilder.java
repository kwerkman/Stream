package com.keith.streambuilder;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamBuilder {

	static boolean res1;
	static boolean res2;
	static boolean res3;
	static long res11;
	
	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9,0);
		stream.forEach(System.out::println);
		

		Stream<Integer> stream1 = Stream.of( new Integer[] {1,2,3,4,5,6,7,8,9,0});
		stream1.forEach(System.out::println);

		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		for(int i=1; i<7; i++ ) {
			list.add(i);
		}
		// copy object list
		List.copyOf(list2);

		Stream<Integer> stream2 = list.stream();
		stream2.forEach(System.out::println);

		Stream<Integer> stream3 = list2.stream();
//		stream3.forEach(System.out::println);
		
		// generate stream
		Stream<Integer> randoms = Stream.generate(  () -> (new Random()).nextInt(100) );
		randoms.limit(5).forEach(System.out::println);
		
		// stream of chars
		Stream<String> stream4 = Stream.of("A$B$C$D".split("\\$"));
		stream4.forEach(System.out::println);
		
		IntStream stream5 = "12345_abcde".chars();
		stream5.forEach(System.out::println);
		
		// Stream collectors
		// using list above
//List<Integer> evenNums = stream3.filter(i -> i%2 ==0 ).collect(Collectors.toList());
//System.out.println(evenNums);
		
		Integer[] evenNumArr = stream3.filter(i->i%2==0).toArray(Integer[]::new);
		System.out.println(evenNumArr);
		evenNumArr.toString();
		
		// Stream operations
		List<String> members = new ArrayList<>();
		members.add("AA");
		members.add("EE");
		members.add("CC");
		members.add("AB");
		members.add("AD");

		members.stream().filter( (s) -> s.startsWith("A") ).forEach(System.out::println);

		members.stream().filter( (s) -> s.startsWith("A") ).map(String::toLowerCase).forEach(System.out::println);

		members.stream().sorted().map(String::toUpperCase).forEach(System.out::println);
		
		// stream terminal conditions (after all stream processed)
		List<String> membersWithA = members.stream().sorted().filter((s)-> s.startsWith("A")).collect(Collectors.toList());
		System.out.println(membersWithA);

		res1 = members.stream().anyMatch((s)->s.startsWith("A"));
		System.out.println(res1);
		res11 = members.stream().filter( (s) -> s.startsWith("A") ).count();
		System.out.println(res11);

		res2 = members.stream().allMatch((s)->s.startsWith("A"));
		System.out.println(res2);

		res2 = members.stream().noneMatch((s)->s.startsWith("A"));
		System.out.println(res3);
		
	}

	@Test
	public void test1() {
		assertTrue(res1);
	}
	@Test
	public void test11() {
		assertEquals(3, res11);
	}
	@Test
	public void test2() {
		assertFalse(res2);
	}
	@Test
	public void test3() {
		assertFalse(res3);
	}

}
