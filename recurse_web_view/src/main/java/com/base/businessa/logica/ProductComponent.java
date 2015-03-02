package com.base.businessa.logica;

import java.util.List;

public class ProductComponent {
	List<ProductComponent> simpleBundle;
	public List<ProductComponent> getSimpleBundle() {
		return simpleBundle;
	}

	public void setSimpleBundle(List<ProductComponent> simpleBundle) {
		this.simpleBundle = simpleBundle;
	}

	List<ProductComponent> complexChildBundles;
	String productDisplayName;
	public String getProductDisplayName() {
		return productDisplayName;
	}

	public void setProductDisplayName(String productDisplayName) {
		this.productDisplayName = productDisplayName;
	}

	public List<ProductComponent> getComplexChildBundles() {
		return complexChildBundles;
	}

	public void setComplexChildBundles(List<ProductComponent> complexChildBundles) {
		this.complexChildBundles = complexChildBundles;
	}
}
