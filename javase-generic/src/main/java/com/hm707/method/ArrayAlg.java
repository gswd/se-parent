package com.hm707.method;

import java.io.Serializable;
import java.util.Collection;

public class ArrayAlg {

	/**
	 * 调用泛型方法时，在方法名前面的<>中传入具体的类型，但大多情况下可以省略参数类型，编译器可以推断出所调用的方法。
	 * 如上面的例子中，可以省略<String>直接调用getMiddle方法。
	 * 当传入的参数类型不同时，虚拟机会找到传入元素的共同类型，如例子中ArrayAlg.getMiddel(1, 2.2, 5L)方法的返回值是Number类型。
	 */
	public static <T> T getMiddel(T... a) {
		System.out.println(a.getClass().getSimpleName());

		return a[a.length / 2];
	}

	public static <T extends Object & Comparable<T> & Serializable> T min(T[] a) {
		if (a == null || a.length == 0) {
			return null;
		}

		T smallest = a[0];
		for (int i = 0; i < a.length; i++) {
			if (smallest.compareTo(a[i]) > 0) {
				smallest = a[i];
			}
		}
		return smallest;
	}

	public static <T> void addAll(Collection<T> coll, T... ts) {
		for (T t : ts) {
			coll.add(t);
		}
	}

	public static <T> T[] getArr(T... ts) {
		return ts;
	}

	public static void main(String[] args) {

		ArrayAlg.<String>getMiddel("a", "b", "c");
		ArrayAlg.getMiddel("a", "b", "c");

		ArrayAlg.getMiddel(1, 2.2, 5L, null, new Object());
	}
}
