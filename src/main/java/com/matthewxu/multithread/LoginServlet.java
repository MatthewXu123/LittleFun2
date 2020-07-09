
package com.matthewxu.multithread;

/**
 * Description:
 * @author Matthew Xu
 * @date Jul 9, 2020
 */
public class LoginServlet {

	private static String usernameRef;
	
	private static String passwordRef;
	
	synchronized public static void doPost(String username, String password) {
		try {
			usernameRef = username;
			if(username.equals("a"))
				Thread.sleep(500);
			passwordRef = password;
			System.out.println("username:" + usernameRef + ";password:" + passwordRef);
		} catch (Exception e) {
		}
	}
}
