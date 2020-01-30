package com.javarush.task.task35.task3511;

import java.lang.reflect.ParameterizedType;

public class Test<T> {
	public static void main(String[] args) {
		Test<Integer> t = new Test<>();
		System.out.println(((ParameterizedType)t.getClass().getTypeParameters()[0].getBounds()[0]).getActualTypeArguments()[0]);
	}
}
