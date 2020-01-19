package com.javarush.task.task32.task3206;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.stream.Stream;

/*
Дженерики для создания прокси-объекта
*/
public class Solution {

	public static void main(String[] args) {
//        Solution solution = new Solution();
//        test(solution.getProxy(Item.class));                        //true false false
//        test(solution.getProxy(Item.class, Small.class));           //true false true
//        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
//        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
//        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
		Integer[] a = new Integer[6];
		Arrays.fill(a, 1);
		Integer[] b = new Integer[12];
		Arrays.fill(b, 2);

		for (Integer integer : Stream.concat(Arrays.stream(a), Arrays.stream(b)).toArray(Integer[]::new)) {
			System.out.print(integer);
		}
		System.out.println();
		for (int i : a) {
			System.out.print(i);
		}
		System.out.println();
		for (int i : b) {
			System.out.print(i);
		}
		System.out.println();
	}


	private static void test(Object proxy) {
		boolean isItem = proxy instanceof Item;
		boolean isBig = proxy instanceof Big;
		boolean isSmall = proxy instanceof Small;

		System.out.format("%b %b %b\n", isItem, isBig, isSmall);
	}

	public <T extends Item> T getProxy(Class<T> clazz, Class<?>... classes) {
		Class[] interfaces = new Class[classes.length + 1];
		for (int i = 0; i < classes.length; i++) {
			interfaces[i] = classes[i];
		}
		interfaces[classes.length] = clazz;
		return clazz.cast(Proxy.newProxyInstance(this.getClass().getClassLoader(), interfaces, new ItemInvocationHandler()));
	}
}