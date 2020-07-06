
package com.matthewxu.multithread;

/**
 * Description:
 * @author Matthew Xu
 * @date Jul 3, 2020
 */
public class MyThread extends Thread{

	private int count = 5;
	
	public MyThread(String name){
		super();
		this.setName(name);
	}
	
	@Override
	public void run() {
		while(count > 0){
			count --;
			System.out.println(Thread.currentThread().getName() + ":" + count);
		}
		
	}
	
}
