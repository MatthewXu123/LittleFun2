package com.matthewxu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1002查找常用字符 {

	 public static List<String> commonChars(String[] A) {
		 Map<Character,Integer> minCountMap = new HashMap<>();
		 Map<Character,Integer> appearCountMap = new HashMap<>();
		 for (String str : A) {
			char[] charArray = str.toCharArray();
			List<Object> tempCharArray = new ArrayList<>();
			for (char c : charArray) {
				if(tempCharArray.contains(c))
					continue;
				int count = getCount(c, charArray);
				if(minCountMap.get(c) == null)
					minCountMap.put(c, count);
				else
					minCountMap.put(c, Math.min(minCountMap.get(c).intValue(), count));
				
				if(appearCountMap.get(c) == null)
					appearCountMap.put(c, 1);
				else
					appearCountMap.put(c, appearCountMap.get(c).intValue() + 1);
				
				tempCharArray.add(c);
			}
		}
		 
		List<String> list = new ArrayList<>();
		 for(java.util.Map.Entry<Character, Integer> entry : minCountMap.entrySet()){
			 Character key = entry.getKey();
			 if(appearCountMap.get(key).intValue() != A.length)
				 continue;
			 Integer count = entry.getValue();
			 for(int i = 0; i < count;i++){
				 list.add(String.valueOf(key));
			 }
		 }
		 return list;
	 }
	 
	 public static int getCount(char c, char[] charArray){
		int count = 0;
		for (char d : charArray) {
			if(c == d)
				count ++ ;
		}
		return count;
	 }
	 
	 public static void main(String[] args) {
		String[] a = {"bbddabab","cbcddbdd","bbcadcab","dabcacad","cddcacbc","ccbdbcba","cbddaccc","accdcdbb"};
		List<String> commonChars = commonChars(a);
		System.out.println(commonChars);
	}
}
