package com.matthewxu.effectivejava;

public class Test {

	static int test(){
		int countX = 0;
		int x = 999999;
		while(x>0){
			countX ++;
			x = x & (x - 1);
		}
		return countX;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(test());
	}
}
