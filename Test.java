import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class Test {
	String path;
	
	@BeforeEach
	void before() {
		/*
		 *INSTRUCTIONS:
		 *1. Use the same directory for all the testing files.
		 *2. Assign the directory's path to the variable path. */
		
		path = "res/student/"; //<- Your directory's path goes here.
	}
	@Test
	void problem1() {
		assertEquals("T...e n...w i...s y...r i...r c...y o...f t...e M...s b...d r...d b...y", Main.problem1_abbreviateWords(path+"test.txt"));			
	}
	@Test
	void problem2() {
		long result = 4;
		assertEquals(result, Main.problem2_countLinesWithThe(path+"testThe.txt"));	
	}	
	@Test
	void problem3() {
		List<String> result = new ArrayList<String>(
				List.of("Its","Look", "a", "and", "as", "at", "by", "city", "few", "her", "is", "it", "land", "left", "mole", "now", "of", "out", "surf", "take", "that", "the", "were", "with", "you", "your"));		
		assertEquals(result, Main.problem3_getDistinctShortWords(path+"testWords.txt"));
	}	
	@Test
	void problem4() {
		String[] words = { "Mary", "had", "a", "little", "lamb" };
		assertEquals("Mary, had, a",Main.problem4_streamToString(Stream.of(words), 3));	
		assertEquals("Mary, had", Main.problem4_streamToString(Stream.of(words), 2));
		assertEquals("Mary, had, a, little, lamb",Main.problem4_streamToString(Stream.of(words), 50));
		
		Integer[] digits = { 3, 1, 4, 1, 5, 9 };
		assertEquals("3, 1, 4", Main.problem4_streamToString(Stream.of(digits), 3));
		assertEquals("3, 1, 4, 1", Main.problem4_streamToString(Stream.of(digits), 4));
		assertEquals("", Main.problem4_streamToString(Stream.of(digits), 0));
		assertEquals("3, 1, 4, 1, 5, 9", Main.problem4_streamToString(Stream.of(digits), 10));	
	}
	@Test
	void problem5() {
		Optional<Integer> result = Main.problem5_smallestProperDivisor(9);
		assertEquals(3,result.orElse(-1));		
		result = Main.problem5_smallestProperDivisor(17);
	    assertEquals(-1,result.orElse(-1));		
		result = Main.problem5_smallestProperDivisor(25);
		assertEquals(5, result.orElse(-1));
		result = Main.problem5_smallestProperDivisor(551);
		assertEquals(19, result.orElse(-1));
	}
	
	@Test
	void problem6() {
		int[]result1 = new int[] {1, 4, 9};
		assertEquals(true, Arrays.equals(result1, Main.problem6_getIntPalindromes(10)));
		int[]result2 = new int[] {1, 4, 9, 121, 484, 676};
		assertEquals(true, Arrays.equals(result2, Main.problem6_getIntPalindromes(100)));
		int[]result3 = new int[] {1, 4, 9, 121, 484, 676, 10201, 12321, 14641, 40804, 44944, 69696, 94249};
		assertEquals(true, Arrays.equals(result3, Main.problem6_getIntPalindromes(500)));		
		int[]result4 = new int[] {1, 4, 9, 121, 484, 676, 10201, 12321, 14641, 40804, 44944, 69696, 94249, 698896};
		assertEquals(true, Arrays.equals(result4, Main.problem6_getIntPalindromes(1000)));					
	}
	
	@Test
	void problem7() {
		assertEquals("Circumambulate", Main.problem7_maxVowels(path+"testVowels.txt"));			
	}
	
	@Test
	void problem8() {
		Map<Integer, Long> result = new TreeMap<>();
		result.put(1, Long.valueOf(2));
		result.put(2, Long.valueOf(20));
		result.put(3, Long.valueOf(19));
		result.put(4, Long.valueOf(30));
		result.put(5, Long.valueOf(11));
		result.put(6, Long.valueOf(11));
		result.put(7, Long.valueOf(8));
		result.put(8, Long.valueOf(8));
		result.put(9, Long.valueOf(6));
		result.put(14, Long.valueOf(1));
		
		assertEquals(result,Main.problem8_countWordLengths(path+"testWords2.txt"));
	}

	@Test
	void problem9() {
		Map<String, Double> result = new TreeMap<>();
		result.put("a",3.769230769230769);
		result.put("b",5.2);
		result.put("c",7.857142857142857);
		result.put("d",3.8);
		result.put("f",4.6);
		result.put("g",3.5);
		result.put("h",4.0);
		result.put("i",2.0);
		result.put("l",6.0);
		result.put("m",4.5);
		result.put("n",7.5);
		result.put("o",2.8333333333333335);
		result.put("p",5.0);
		result.put("r",7.5);
		result.put("s", 5.4375);
		result.put("t", 3.8095238095238093);
		result.put("u", 3.3333333333333335);
		result.put("w", 5.25);
		result.put("y", 3.0);
		
		assertEquals(result,Main.problem9_averageWordLengths(path+"testWords2.txt"));	
	}
	@Test
	void problem10(){
		assertEquals("deliberately",Main.problem10_findLongestWordContaining(path+"/moby.txt", "er")); // deliberately
		assertEquals("flourish",Main.problem10_findLongestWordContaining(path+"/moby.txt", "f")); // flourish		
	}
	
}
