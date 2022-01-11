package leetcode;

import java.util.*;

/*Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

* LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
* int get(int key) Return the value of the key if the key exists, otherwise return -1.
* void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. 
  If the number of keys exceeds the capacity from this operation, evict the least recently used key.
  The functions get and put must each run in O(1) average time complexity.*/

public class P0146_LRUCache {

	private class DoublyLinkedNode {
		private int key;
		private int value;
		DoublyLinkedNode prev;
		DoublyLinkedNode next;
	}

	private void addNode(DoublyLinkedNode node) {
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
	}
	
	private void removeNode(DoublyLinkedNode node) {
		DoublyLinkedNode prev = node.prev;
		DoublyLinkedNode next = node.next;
		prev.next = next;
		next.prev = prev;
	}
	
	private void moveToHead(DoublyLinkedNode node) {
		removeNode(node);
		addNode(node);
	}
	
	private DoublyLinkedNode popTail() {
		DoublyLinkedNode curr = tail.prev;
		removeNode(curr);
		return curr;
	}
	
	private Map<Integer, DoublyLinkedNode> ht = new HashMap<>();
	private int size;
	private int capacity;
	private DoublyLinkedNode head, tail;
	
    public P0146_LRUCache(int capacity) {
    	this.size = 0;
    	this.capacity = capacity;
    	head = new DoublyLinkedNode();
    	tail = new DoublyLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
    	DoublyLinkedNode node = ht.get(key);
    	if (node == null) {
    		return -1;
    	}
		moveToHead(node);
		return node.value;
    }
    
    public void put(int key, int value) {
    	DoublyLinkedNode node = ht.get(key);
    	if (node == null) {
    		DoublyLinkedNode newNode = new DoublyLinkedNode();
    		newNode.key = key;
    		newNode.value = value;
    		ht.put(key, newNode);
    		addNode(newNode);
    		size++;
    		if (size > capacity) {
    			DoublyLinkedNode tail = popTail();
    			ht.remove(tail.key);
    			size--;
    		}
    	} else {
    		node.value = value;
    		moveToHead(node);
    	}
    }

}
