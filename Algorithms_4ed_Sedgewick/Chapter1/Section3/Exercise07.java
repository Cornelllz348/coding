package chapter0103;

import java.util.Iterator;

// linked list implementation of stack
public class Exercise07<Item> implements Iterable<Item>
{
	private Node first; // top of stack (most recently added node)
	private int n;      // number of items
	
	private class Node
	{ // nested class to define nodes
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return n;
	}
	
	// add item to top of stack: create a new first Node and let it point to the old first
	// first (item) -> oldfirst -> ....
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		n++;
	}

	// remove item from top of stack
	// oldfirst -> ...
	public Item pop() {
		Item item = first.item;
		first = first.next;
		n--;
		return item;
	}
	
	// exercise 7: returns the most recently inserted item on the stack (without popping it)
	public Item peek() {
		return first.item;
	}
	
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	public class ListIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext() {
			return current != null;
		}
		public void remove() {}
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
}