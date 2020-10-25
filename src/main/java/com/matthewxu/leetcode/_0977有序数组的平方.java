package com.matthewxu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _0977有序数组的平方 {

	public static int[] sortedSquares(int[] A) {
		List<Integer> list = new ArrayList<>();
		Arrays.stream(A).forEach(ele -> list.add(ele * ele));
		Collections.sort(list);
		for(int i = 0; i < list.size();i++){
			A[i] = list.get(i);
		}
		return A;
    }
	
}
