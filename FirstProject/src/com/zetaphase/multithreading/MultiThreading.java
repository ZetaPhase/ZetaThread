package com.zetaphase.multithreading;

import Finance.*;

import com.zetaphase.fp.Person;

public class MultiThreading {

	public static void main(String[] args) throws Exception {
		Person dave = new Person("Dave", 15, "M", "12345");
		Person ricky = new Person("Ricky", 50, "M", "09876");
		Account daveAccount = new Account("12345", 10, dave);
		Account rickyAccount = new Account("09876", 50, ricky);
		MyThread[] threads = new MyThread[100];
		int numThreads = 2;
		for (int i=0; i<numThreads; i++) {
			MyThread t = new MyThread();
			threads[i] = t;
			t.start();
			//t.join();
		}
		for (int i=0; i<numThreads; i++) {
			threads[i].join();
		}
		System.out.println("Main thread has finished.");
		//System.out.println(daveAccount.getBalance());
		//System.out.println(rickyAccount.getBalance());
	}

}
