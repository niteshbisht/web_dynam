package com.spring.innerbeanex;

public class Outer {
	int data;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	static class InnerSrc {
		static int innerdata;

		public int getInnerdata() {
			return innerdata;
		}

		public void setInnerdata(int innerdata) {
			this.innerdata = innerdata;
		}
	}
}
