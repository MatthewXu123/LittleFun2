
package com.matthewxu.multithread;

/**
 * Description:
 * @author Matthew Xu
 * @date Jul 29, 2020
 */
public class SuspendRun {
	public static void main(String[] args) throws InterruptedException {
		SuspendThread suspendRun = new SuspendThread();
		Thread thread = new Thread(suspendRun);
		thread.start();
		thread.sleep(5000);
		
		thread.suspend();
	}
}
