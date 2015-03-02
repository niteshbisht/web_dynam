package com.base.businessa.logica;

import java.util.List;

public class ProductOfferings {
	
	List<ProductComponent> simpleChildBundle;
	
	List<ProductComponent> complexChildBundle;

	public List<ProductComponent> getComplexChildBundle() {
		return complexChildBundle;
	}

	public void setComplexChildBundle(List<ProductComponent> complexChildBundle) {
		this.complexChildBundle = complexChildBundle;
	}

	public List<ProductComponent> getSimpleChildBundle() {
		return simpleChildBundle;
	}

	public void setSimpleChildBundle(List<ProductComponent> simpleChildBundle) {
		this.simpleChildBundle = simpleChildBundle;
	}
}
