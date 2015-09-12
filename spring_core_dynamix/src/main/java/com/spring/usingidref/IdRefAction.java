package com.spring.usingidref;

public class IdRefAction {

	InsideClassObject insideObj;
	
	
	public IdRefAction(InsideClassObject insideObj) {
		super();
		this.insideObj = insideObj;
	}

	public void setInsideObj(InsideClassObject insideObj) {
		this.insideObj = insideObj;
	}

	public InsideClassObject getInsideObj() {
		return insideObj;
	}
}
