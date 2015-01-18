package com.nitesh.math.dynamics;

public class Primordial {
	public static boolean evaluatePrime(int n) {
		return validateRecursePrime(n, 2);
	}

	private static boolean validatePrime(int n) {
		int start = 2;
		if (n < 2)
			return false;
		for (start = 2; start * start <= n; start++)
			if (n % start == 0)
				return false;
		return true;
	}

	private static boolean validateRecursePrime(int n, int start){
		if(n<start) return false;
		if(start*start<=n)
			if(n%start==0) return false;
			else return validateRecursePrime(n, start+1); 
		return true;
	}
	
	private Primordial() {
		// prevent construction of object
	}
	
	public static void main(String[] args) {
		boolean p = evaluatePrime(11);
		System.out.println(p);
	}
}
