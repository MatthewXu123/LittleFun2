package com.matthewxu.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _416分割等和子集 {

	public static boolean canPartition(int[] nums) {
		int sum = 0;
		List<Integer> numList = new ArrayList<>();
		for (int num : nums) {
			sum += num;
			numList.add(num);
		}
		Collections.sort(numList, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		if(sum % 2 == 1)
			return false;
		else{
			int max = numList.get(0);
			int newSum = max;
			if(newSum > sum * 0.5)
				return false;
			else if (newSum == sum * 0.5)
				return true;
			for(int i = numList.size() - 1; i > 0; i--){
				Integer num = numList.get(i);
				newSum += num;
				if(newSum > sum * 0.5){
					newSum = newSum - num;
				}else if (newSum == sum * 0.5){
					return true;
				}
			}
			
		}
		return false;
    }
	
	
}
