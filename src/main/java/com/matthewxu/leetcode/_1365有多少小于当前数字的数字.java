package com.matthewxu.leetcode;

public class _1365有多少小于当前数字的数字 {

	public int[] smallerNumbersThanCurrent(int[] nums) {
		int[] count = new int[nums.length];
		for(int i = 0; i < nums.length; i++){
			count[i] = count(nums[i], nums);
		}
		return count;
    }
	
	public int count(int num, int[] nums){
		int count = 0;
		for(int i = 0; i < nums.length;i ++){
			if(nums[i] < num)
				count ++;
		}
		return count;
	}
}
