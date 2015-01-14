package com.nitesh.algos.sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InsertionSort {

	private volatile int[] array;

	public int[] getArray() {
		return array;
	}

	public InsertionSort(String filename) {
		File f = new File("src/test/resources/" + filename + ".txt");
		String s;
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(f));
			while ((s = bfr.readLine()) != null) {
				String p[] = s.split(",");
				array = new int[p.length];
				for (int i = 0; i < p.length; i++)
					array[i] = Integer.parseInt(p[i]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doInsertionSort() {
		long t1=System.currentTimeMillis();
		for(int j=1;j<array.length;j++){
			int key = array[j];
			int i = j-1;
			while(i>=0 && array[i]>key){
				array[i+1]=array[i];
				i=i-1;
			}
			array[i+1]=key;
			System.out.println("Pass "+j+" the array is -->");
		/*	for(int p=0;p<array.length;p++)
				System.out.print(array[p]+" ");
			System.out.println();*/
		}
		
		long t2=System.currentTimeMillis();
		System.out.println(t2-t1);
	}
}
