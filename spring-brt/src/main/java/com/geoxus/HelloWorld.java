package com.geoxus;

import org.openjdk.jol.info.ClassLayout;

public class HelloWorld {
	private static final boolean flag = false;
	private static final Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock();
		});
		Thread t2 = new Thread(() -> {
			lock();
		});

		t1.start();

		t2.start();
		t1.join();
		t2.join();

	}

	public static void lock() {
		System.out.println(ClassLayout.parseInstance(lock).toPrintable());
	}
}
