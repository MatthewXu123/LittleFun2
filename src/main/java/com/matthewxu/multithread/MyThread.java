
package com.matthewxu.multithread;

/**
 * Description:
 * @author Matthew Xu
 * @date Jul 3, 2020
 */
public class MyThread extends Thread{

	
	@Override
	public void run() {
		System.out.println("begin:" + this.isAlive());
	}
	
}
