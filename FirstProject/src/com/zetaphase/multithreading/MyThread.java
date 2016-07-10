package com.zetaphase.multithreading;

import java.util.Random;

import Finance.Account;

public class MyThread extends Thread{

	@Override
	public void run(){
		// TODO Auto-generated method stub
		try {
			super.run();
			for (int i=0; i<100; i++) {
				//System.out.println(this.getId() + " is running " + new Date());
				try {
					Random rand = new Random();
					if (rand.nextBoolean()) {
						System.out.println(this.getId() + ": Attempting to lock on 12345, transfer");
						Account.getAccountByNumber("12345").transfer("09876", rand.nextInt(5)+1);
						System.out.println(this.getId() + ": Lock on 12345 has released, transfer");
					} else {
						System.out.println(this.getId() + ": Attempting to lock on 09876, transfer");
						Account.getAccountByNumber("12345").transfer("09876", -1*(rand.nextInt(5)+1));
						System.out.println(this.getId() + ": Lock on 09876 has released, transfer");
					}
					//Thread.sleep(rand.nextInt(1000)+700);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Thread " + this.getId() + " ended.");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
