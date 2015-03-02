package com.nitesh.mainpack;

import com.nitesh.elasticsearch.ElasticSearchArchiver;
import com.nitesh.elasticsearch.Plugin;

public class MainClass {

	public static void main(String[] args) {
		Plugin p = new ElasticSearchArchiver();
		
		p.initialize();
	}

}
