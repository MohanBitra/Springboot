package com.au.test;

public class FPThreadTest {

	public static void main(String[] args) {

		Runnable runnable = new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 100; i++) {
					System.out.println("i Value is" + i);

				}

			}

		};

		Thread t = new Thread(runnable);
		t.start();

		Thread t1 = new Thread(runnable);
		t1.start();

		Runnable runnable2 = () -> {

			for (int i = 0; i < 10; i++) {
				System.out.println(i);
			}

		};

		Thread t3 = new Thread(runnable2);
		t3.start();

	}
}
