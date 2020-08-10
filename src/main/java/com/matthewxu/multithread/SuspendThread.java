
package com.matthewxu.multithread;

/**
 * Description:
 * @author Matthew Xu
 * @date Jul 29, 2020
 */
public class SuspendThread implements Runnable{

	private int i;
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		while(true){
			i++;
		}
		
	}

}
