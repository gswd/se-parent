package com.hm707.limit;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {

		List<? extends Fruit> fruitlist = new ArrayList<Apple>();

		List<Apple> appleList = new ArrayList<Apple>();


		Plate<? extends Fruit> p = new Plate<Apple>(new Apple());

		System.out.println(p.getItem());
		p.getItem();

		Plate[] plates = new Plate[10];

		Object[] os = plates;
		os[0] = new Plate<>(new Fruit());



		//p.setItem(new Fruit());
		//p.setItem(new Apple());

		List<String> stringList = new ArrayList<>();

		List sList = stringList;
		sList.add(new Object());

		System.out.println(stringList.get(0));

		List<?> list = new ArrayList<Integer>();
		//list.add(1);



	}

	public void test(Object object) {
		if (object instanceof List) {
			return ;
		}

		List<String> a = (List<String>) object;

		System.out.println("");

	}

}
