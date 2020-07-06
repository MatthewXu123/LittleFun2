
package com.matthewxu.multithread;

/**
 * Description:
 * @author Matthew Xu
 * @date Jul 3, 2020
 */
public class MultiThreadTest {

	public static void main(String[] args) {
		try {
			MyThread myThread = new MyThread("A");
			MyThread myThread2 = new MyThread("B");
			MyThread myThread3 = new MyThread("C");
			myThread.start();
			myThread2.start();
			myThread3.start();
		} catch (Exception e) {
		}
		
	}
}
