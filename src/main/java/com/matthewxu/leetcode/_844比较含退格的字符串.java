
package com.matthewxu.leetcode;

/**
 * Description:
 * @author Matthew Xu
 * @date Oct 19, 2020
 */
public class _844比较含退格的字符串 {

	public static boolean backspaceCompare(String S, String T) {
        if(S.equals(T) || S == T)
        	return true;
        return handle(S).equals(handle(T));
    }
	
	public static String handle(String str){
		char[] charArray = str.toCharArray();
		for(int i = 1; i < charArray.length; i++){
			char c = charArray[i];
			if(c == '#'){
				setSpecial(charArray, i);
			}
		}
		String result = "";
		for (char c : charArray) {
			if(c != '#')
				result += c;
		}
		return result;
	}
	
	public static void setSpecial(char[] charArray, int index){
		for(int i = index - 1;i >= 0; i--){
			if(charArray[i] != '#' ){
				charArray[i] = '#';
				break;
			}
				
		}
	}
	
	public static void main(String[] args) {
		System.out.println(backspaceCompare("ab#c", "ad#c"));
	}
}
