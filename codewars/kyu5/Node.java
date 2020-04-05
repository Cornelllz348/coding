package kyu5;

public class Node {
	public int value;
	public Node next;
	public Node(int value) {
		this.value = value;
		this.next = null;
	}
	public Node getNext(Node node) {
		return node.next;
	}
}
