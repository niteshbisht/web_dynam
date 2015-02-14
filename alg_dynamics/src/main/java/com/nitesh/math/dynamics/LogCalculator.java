package com.nitesh.math.dynamics;

public class LogCalculator {

	public static double findLog(int base, int num) {
		return getLog(base, num);
	}

	private static int getLog(int base, int num) {
		double p = base;
		int ctr = 0;
		while (p <= num) {
			p = p * base;
			ctr++;
		}
		return ctr;
	}

	public static void main(String[] args) {
		double val = findLog(10, 100);
		System.out.println(val);
		val = findLog(3, 9);
		System.out.println(val);
		val = findLog(9, 1000);
		System.out.println(val);
	}
}
