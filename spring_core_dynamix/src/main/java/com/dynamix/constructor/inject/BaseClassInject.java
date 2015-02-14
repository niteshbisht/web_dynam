package com.dynamix.constructor.inject;

public class BaseClassInject {
	ChildInjectA childA;
	ChildInjectB childB;

	public BaseClassInject(ChildInjectA childA, ChildInjectB childB) {
		super();
		this.childA = childA;
		this.childB = childB;
	}
}