package src.nitesh.mainpackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.nitesh.algos.sort.InsertionSort;

public class MainT {

	public static void main(String[] args) throws IOException {
		File f = new File("src/test/resources/insertionsort.txt");
		FileWriter fw= new FileWriter(f);
		for(int i = 300000;i>0;i--){
			fw.write(i+",");
		}
		fw.flush();
		InsertionSort srt = new InsertionSort("insertionsort");
		srt.doInsertionSort();
	}

}
