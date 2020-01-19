package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
	//мне кажется, было бы неплохо основываться на массиве
//это реализует индексацию и даст быстрый доступ к объектам, а так же упростит перебирание коллекции
	//а еще я не хочу исползовать другие коллекции, поэтому да.
	Entry<String> root;
	private int size;

	public CustomTree() {
		root = new Entry<>("root");
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean add(String s) {
		try {
			Entry addedChild = new Entry(s);
			Entry availableToAddEntry = getFirstAvailableToAdd(root);

			if (availableToAddEntry == null) {
				restoreTheAbilityToAdd(root);
				return add(s);
			}

			if (availableToAddEntry.availableToAddLeftChildren) {
				availableToAddEntry.leftChild = addedChild;
				availableToAddEntry.availableToAddLeftChildren = false;
			} else if (availableToAddEntry.availableToAddRightChildren) {
				availableToAddEntry.rightChild = addedChild;
				availableToAddEntry.availableToAddRightChildren = false;
			} else return false;

			addedChild.parent = availableToAddEntry;
			addedChild.level = availableToAddEntry.level + 1;
			++size;
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(Object o) {
		if (!(o instanceof String)) throw new UnsupportedOperationException();

		Entry toRemoved;

		if ((toRemoved = getEntry(root, (String) o)) == null) return false;

		if (toRemoved.parent.leftChild == toRemoved) toRemoved.parent.leftChild = null;
		else if (toRemoved.parent.rightChild == toRemoved) toRemoved.parent.rightChild = null;
		else return false;

		size -= 1 + getChildrenCount(toRemoved);

		return true;
	}

	public String getParent(String s) {
		try {
			return getEntry(root, s).parent.elementName;
		} catch (NullPointerException e) {
			return null;
		}
	}

	private Entry getFirstAvailableToAdd(Entry element) {
		if (element.isAvailableToAddChildren()) return element;


		Entry fromLeft = null;
		if (element.leftChild != null) fromLeft = getFirstAvailableToAdd(element.leftChild);
		Entry fromRight = null;
		if (element.rightChild != null) fromRight = getFirstAvailableToAdd(element.rightChild);

		if (fromLeft == null & fromRight == null) return null;
		if (fromLeft == null) return fromRight;
		if (fromRight == null) return fromLeft;

		return fromRight.level < fromLeft.level ? fromRight : fromLeft;
	}

	private void restoreTheAbilityToAdd(Entry root){
		if (root.leftChild == null & root.rightChild == null){
			root.availableToAddRightChildren = true;
			root.availableToAddLeftChildren = true;
		}
		if (root.leftChild != null) restoreTheAbilityToAdd(root.leftChild);
		if (root.rightChild != null) restoreTheAbilityToAdd(root.rightChild);

	}



	private Entry getEntry(Entry root, String elementName) {

		if (root.elementName.equals(elementName)) return root;

		Entry entry;

		if (root.leftChild != null) {
			if ((entry = getEntry(root.leftChild, elementName)) != null) return entry;
		}
		if (root.rightChild != null) {
			if ((entry = getEntry(root.rightChild, elementName)) != null) return entry;
		}

		return null;


	}

	private int getChildrenCount(Entry root) {
		int i = 0;
		if (root.leftChild != null) {
			i += 1 + getChildrenCount(root.leftChild);
		}
		;
		if (root.rightChild != null) {
			i += 1 + getChildrenCount(root.rightChild);
		}

		return i;
	}


	@Override
	public String set(int index, String element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String get(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<String> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, String element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends String> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void removeRange(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}


	static class Entry<T> implements Serializable {

		String elementName;
		boolean availableToAddLeftChildren, availableToAddRightChildren;
		Entry<T> parent, leftChild, rightChild;
		int level;


		public Entry(String elementName) {
			this.elementName = elementName;
			availableToAddRightChildren = true;
			availableToAddLeftChildren = true;
		}


		public boolean isAvailableToAddChildren() {
			return availableToAddLeftChildren | availableToAddRightChildren;
		}
	}

}
