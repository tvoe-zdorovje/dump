package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {

	private static final Object PRESENT = new Object();
	private transient HashMap<E, Object> map;

	public AmigoSet() {
		map = new HashMap<>();
	}

	public AmigoSet(Collection<? extends E> collection){
		map = new HashMap<>((int)Math.max(16, Math.ceil(collection.size()/.75f)));
		addAll(collection);
	}

	@Override
	public Iterator iterator() {
		return map.keySet().iterator();
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return map.containsKey(o);
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public boolean remove(Object o) {
		map.remove(o);
		return !contains(o);
	}

	@Override
	public boolean removeAll(Collection c) {
		return super.removeAll(c);
	}

	public boolean add(Object e) {
		int size = map.size();
			map.put((E) e, PRESENT);
			return map.size()>size;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		try {

			return new AmigoSet<>(((Map)map.clone()).keySet());

		} catch (Exception e) {
			throw new InternalError();
		}
	}

	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		stream.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
		stream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
		stream.writeInt(map.size());
		for (E e : map.keySet()) {
			stream.writeObject(e);
		}
	}

	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		int capacity = stream.readInt();
		float loadFactory = stream.readFloat();
		map = new HashMap<>(capacity, loadFactory);
		int size = stream.readInt();
		for (int i = 0; i < size; i++) {
			map.put((E) stream.readObject(), PRESENT);
		}
	}
}
