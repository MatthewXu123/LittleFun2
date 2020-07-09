
package com.matthewxu.multithread;

/**
 * Description:
 * @author Matthew Xu
 * @date Jul 9, 2020
 */
public class ALogin extends Thread{

	@Override
	public void run() {
		LoginServlet.doPost("a", "aa");
	}
}
