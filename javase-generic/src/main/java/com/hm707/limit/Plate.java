package com.hm707.limit;

public class Plate<T extends Fruit> {

	private T item;

	public Plate(T item) {
		this.item = item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public T getItem() {
		return this.item;
	}

}
