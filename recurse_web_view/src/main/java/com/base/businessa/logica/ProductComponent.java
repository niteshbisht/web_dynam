package com.base.businessa.logica;

import java.util.List;

public class ComplexChildBundles {
	List<SimpleChildBundle> childInsideComplexChildBundle;
	List<ComplexChildBundles> complexChildBundles;
	public List<ComplexChildBundles> getComplexChildBundles() {
		return complexChildBundles;
	}

	public void setComplexChildBundles(List<ComplexChildBundles> complexChildBundles) {
		this.complexChildBundles = complexChildBundles;
	}

	public List<SimpleChildBundle> getChildInsideComplexChildBundle() {
		return childInsideComplexChildBundle;
	}

	public void setChildInsideComplexChildBundle(
			List<SimpleChildBundle> childInsideComplexChildBundle) {
		this.childInsideComplexChildBundle = childInsideComplexChildBundle;
	}
}
