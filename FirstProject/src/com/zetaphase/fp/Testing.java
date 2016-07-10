package com.zetaphase.fp;

import java.util.Random;

public class Testing {

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i=0; i<10; i++) {
			a[i] = i;
		}
		for (int num : a) {
			System.out.println(num);
		}
	}

}
