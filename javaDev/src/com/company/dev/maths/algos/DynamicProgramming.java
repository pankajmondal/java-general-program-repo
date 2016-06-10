package com.company.dev.maths.algos;

public class DynamicProgramming {

	public static void main(String[] args) {
		DynamicProgramming dp = new DynamicProgramming();
		int[]fibs=dp.createFibonacciSeries(32);
		printIntArray(fibs);
		System.out.println("\n\n"+dp.fib(30));
	}
	
	int[] createFibonacciSeriesRecursive(int numOfFibs){
		int[] fibs = new int[numOfFibs];
		
		int fib,fibN=0,fibN1=1;
		fibs[0]=fibN;
		fibs[1]=fibN1;	
		int count=2;
		while(count < numOfFibs){
			fib=fibN+fibN1;
			fibs[count++]=fib;
			fibN=fibN1;
			fibN1=fib;
		} 
		return fibs;
	}
	int fib(int n){
		if(n==0)return 0;
		if(n==1)return 1;
		else return fib(n-1)+fib(n-2);
	}
	
	/**
	 * RETURNS A FIBONACCI SERIES ARRAY WITH O(n) time complexity.
	 * @param numOfFibs
	 * @return
	 */
	int[] createFibonacciSeries(int numOfFibs){
		int[] fibs = new int[numOfFibs];
		
		int fib,fibN=0,fibN1=1;
		fibs[0]=fibN;
		fibs[1]=fibN1;
		int count=2;
		while(count < numOfFibs){
			fib=fibN+fibN1;
			fibs[count++]=fib;
			fibN=fibN1;
			fibN1=fib;
		}
		return fibs;
	}
	static void printIntArray(int[]array){
		System.out.println();
		for (int j : array) {
			System.out.print(j + " ");
		}
	}
}
