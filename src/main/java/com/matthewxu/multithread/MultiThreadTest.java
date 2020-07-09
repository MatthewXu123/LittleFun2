
package com.matthewxu.multithread;

/**
 * Description:
 * @author Matthew Xu
 * @date Jul 3, 2020
 */
public class MultiThreadTest {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		System.out.println(myThread.isAlive());
		myThread.start();
		System.out.println("start:" + myThread.isAlive());
	}
}
