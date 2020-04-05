package kyu5;

import java.util.*;

public class CanYouGetTheLoop {
	public int loopSize(Node node) {
		Node slow = node;
		Node fast = node;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return countNodes(slow);
			}
		}
		return 0;
	}
	public int countNodes(Node node) {
		int count = 1;
		Node tmp = node;
		while (tmp.next != node) {
			count++;
			tmp = tmp.next;
		}
		return count;
	}
}