import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.*;
import java.io.*;

class Main {
	public static String problem1_abbreviateWords(String filename) {
	    String z = "";
	    File a = new File(filename);
	    BufferedReader b;
	    String c;
	    String[] d;
	    try(Scanner inFile = new Scanner(new File(filename))) {
	    	b = new BufferedReader(new FileReader(a));
	    	c = b.readLine();
	    	d = c.split(" ");
			while(null != c) {
				for(String x : d) {
				    z += x.charAt(0) + "..." + x.charAt(x.length() - 1) + " ";
				}
				z = z.replaceAll("\\s+$", "");
				c = b.readLine();
			}
			inFile.close();
		} catch(FileNotFoundException e) {
			System.out.println("File: " + filename + " not found");
		} catch(IOException ex){
			System.out.println("File: " + filename + " not found");
		}
		return z;
	}

	public static long problem2_countLinesWithThe(String filename) {
		int z = 0;
		try(Stream<String> x = Files.lines(Paths.get(filename))){ 
			z = x.filter(a -> a.contains(" the ") || a.contains("the ") || a.contains(" the")).toArray().length;
		}
		catch(IOException ex){
			System.out.println("File: " + filename + " not found");
		}
		return z;
	}

	public static List<String> problem3_getDistinctShortWords(String filename) {
		List<String> z = new ArrayList<String>();
		Set<String> a = new TreeSet<String>();
		String b;
		try(Scanner inFile = new Scanner(new File(filename))) {
			while(inFile.hasNext()) {
				b = inFile.next();
				if(4 >= b.length()) {
					a.add(b);
				}
			}
			inFile.close();
		} catch(FileNotFoundException e) {
			System.out.println("File: " + filename + " not found");
		}
		for(String x : a) {
			z.add(x);
		}
		return z; 
	}

	public static <T> String problem4_streamToString(Stream<T> stream, int n) {
        String z = stream.map(a -> a.toString()).limit(n).collect(Collectors.joining(", "));
        return z;
	}
	
	public static Optional<Integer> problem5_smallestProperDivisor(int n) {
	    int a = 2;
	    while(((int)n / 2) > a) {
	        if(0 == n % a) {
		        return Optional.ofNullable(a);
		    }
	        a++;
	    }
		return Optional.ofNullable(null);
	}
	
	public static int[] problem6_getIntPalindromes(int num) {
		int xyz[] = {};
		if(0 > num) {
		    return xyz;
		}
		int[] x;
		int a[] = new int[num];
		int b = 0;
		int c;
		int e;
		int f = 0;
		int m = 0;
		int n = 1;
		int o = 0;
		while(num > m) {
		    a[m] = -1;
		    m++;
		}
		do {
		    c = (int)Math.pow(n, 2);
		    e = c;
		    int d = 0, dd;
		    while(0 != e) {
		        dd = e % 10;
		        d = (d * 10) + dd;
		        e = e / 10; 
		    }
		    if(c == d) {
		        a[n] = c;
		        b = b + 1;
		    }
		    n++;
		} while(num >= n);
		x = new int[b];
		while(a.length > o) {
		    if(-1 != a[o]) {
		        x[f++] = a[o];
		    }
		    o++;
		}
		return x;
	}

	public static String problem7_maxVowels(String filename) {
		String z = "";
		File a = new File(filename);
		BufferedReader b;
		String[] c = null;
		int d;
		int f = 0;
		char x;
		String y;
		try(Scanner inFile = new Scanner(new File(filename))) {
		    b = new BufferedReader(new FileReader(a));
		    while(null != (y = b.readLine())) {
		        c = y.split(" ");
		        for(int i = 0; i < c.length; i++) {
		            d = 0;
		            for(int j = 0; j < c[i].length(); j++) {
		                x = c[i].charAt(j);
		                if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
		                    d = d + 1;
		                }
		            }
		            if(f < d) {
		                z = c[i];
		                f = d;
		            }
		        }
		    }
		inFile.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File: " + filename + " not found");
		}
		catch(IOException e){
			System.out.println("File: " + filename + " not found");
		}
		return z;
	}
	
	public static Map<Integer, Long> problem8_countWordLengths(String filename) {
		Map<Integer, Long> z = new TreeMap<>();
		int a;
		long b;
		try(Scanner inFile = new Scanner(new File(filename))) {
		    while(inFile.hasNext()) {
		        a = inFile.next().length();
		        b = z.getOrDefault(a, 0l);
		        z.put(a, b + 1);
		    }
		    inFile.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File: " + filename + " not found");
		}
		return z;
	}

	public static Map<String, Double> problem9_averageWordLengths(String filename) {
		Map<String, Double> z = Collections.emptyMap();
		String a = "";
		String[] b;
		try(Scanner inFile = new Scanner(new File(filename))) {
		    a = new String(Files.readAllBytes(Paths.get(filename)));
		}
		catch(FileNotFoundException e){
			System.out.println("File: " + filename + " not found");
		}
		catch(IOException e){
			System.out.println("File: " + filename + " not found");
		}
		if(true != a.isEmpty()) {
		    a = a.replace("\n", " ");
		    b = a.split(" ");
		    z = Arrays.stream(b).collect(Collectors.groupingBy((String c) -> String.valueOf(c.charAt(0)).toLowerCase(), Collectors.averagingDouble(c -> c.length())));
		}
		return z;
	}

	public static String problem10_findLongestWordContaining(String filename, String word) {
		String z = "";
		File a = new File(filename);
		BufferedReader b;
		String c;
		String[] d;
		ArrayList<String> y = new ArrayList<>();
		try(Scanner inFile = new Scanner(new File(filename))) {
		    b = new BufferedReader(new FileReader(a));
		    while(null != (c = b.readLine())) {
		        d = c.split(" ");
		        for(String x : d) {
		            if(x.contains(word)) {
		                y.add(x);
		            }
		        }
		    }
		    if(0 < y.size()) {
		        z = y.stream().max(Comparator.comparing(String::length)).get();
		    }
		    inFile.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File: " + filename + " not found");
		}
		catch(IOException e){
			System.out.println("File: " + filename + " not found");
		}
		return z;
	}

	public static void main(String[] args) {
	    System.out.println(problem1_abbreviateWords("test.txt")); 
	    //returns "T...e n...w i...s y...r i...r c...y o...f t...e M...s b...d r...d b...y"
		
		System.out.println(problem2_countLinesWithThe("testThe.txt"));
		//returns 4
		
		System.out.println(problem3_getDistinctShortWords("testWords.txt"));
		//returns [Its, Look, a, and, as, at, by, city, few, her, is, it, land, left, mole, 
		//now, of, out, surf, take, that, the, were, with, you, your]
		
		String[] words = {"Mary", "had", "a", "little", "lamb"};
        System.out.println(problem4_streamToString(Stream.of(words), 3));
        // Mary, had, a  
        System.out.println(problem4_streamToString(Stream.of(words), 2));
        // Mary, had
        System.out.println(problem4_streamToString(Stream.of(words), 50));
        // Mary, had, a, little, lamb
        Integer[] digits = {3, 1, 4, 1, 5, 9};
        System.out.println(problem4_streamToString(Stream.of(digits), 3));
        // 3, 1, 4
        System.out.println(problem4_streamToString(Stream.of(digits), 4));
        // 3, 1, 4, 1
        System.out.println(problem4_streamToString(Stream.of(digits), 0));
        //
        System.out.println(problem4_streamToString(Stream.of(digits), 10));
        // 3, 1, 4, 1, 5, 9
		
		Optional result = problem5_smallestProperDivisor(9);
        System.out.println(result.orElse(-1)); 
        // 3
        result = problem5_smallestProperDivisor(17);
        System.out.println(result.orElse(-1)); 
        //-1
        result = problem5_smallestProperDivisor(25);
        System.out.println(result.orElse(-1)); 
        // 5
        result = problem5_smallestProperDivisor(551);
        System.out.println(result.orElse(-1)); 
        // 19
        
        System.out.println(problem6_getIntPalindromes(100)); 
        // returns {1, 4, 9, 121, 484, 676}
        System.out.println(problem6_getIntPalindromes(-100)); 
        // returns {}

        System.out.println(problem7_maxVowels("testVowels.txt")); 
        //returns "Circumambulate"

        System.out.println(problem8_countWordLengths("testWords2.txt"));
        //returns {1=2, 2=20, 3=19, 4=30, 5=11, 6=11, 7=8, 8=8, 9=6, 14=1}
        
        System.out.println(problem9_averageWordLengths("testWords2.txt"));
        //returns {a=3.769230769230769, b=5.2, c=7.857142857142857, d=3.8, f=4.6, g=3.5, h=4.0, i=2.0, l=6.0, m=4.5, n=7.5, o=2.8333333333333335, 
        //p=5.0, r=7.5, s=5.4375, t=3.8095238095238093, u=3.3333333333333335, w=5.25, y=3.0}
        
        System.out.println(problem10_findLongestWordContaining("moby.txt", "er"));
        //returns "deliberately"
        System.out.println(problem10_findLongestWordContaining("moby.txt", "f"));
        //returns "flourish"
	}
}