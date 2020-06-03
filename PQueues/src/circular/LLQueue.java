//// Rahul and Aravind
//
//public class LLQueue implements MyQueue {
//
//	private class MyLinkedList {
//
//		private Node first;
//
//		public MyLinkedList() {
//			first = null;
//		}
//
//		public void addLast(Object element) {
//
//			if (first == null) {
//				first = new Node(element, first);
//			} else {
//				Node tmp = first;
//				while (tmp.next != null)
//					tmp = tmp.next;
//				tmp.next = new Node(element, null);
//			}
//		}
//
//		public Object getFirst() {
//			if (first == null) {
//				return null;
//			}
//			return first.data;
//		}
//
//		public Object removeFirst() {
//			if (first == null) {
//				return null;
//			}
//			Object element = first.data;
//			first = first.next;
//			return element;
//		}
//
//		private class Node {
//			public Object data;
//			public Node next;
//
//			public Node(Object data, Node next) {
//				this.data = data;
//				this.next = next;
//			}
//
//			public String toString() {
//				return data + "";
//			}
//		}
//	}
//
//	private MyLinkedList linkedlist;
//
//	public LLQueue() {
//		linkedlist = new MyLinkedList();
//	}
//
//	@Override
//	public boolean empty() {
//		return linkedlist.first == null;
//	}
//
//	@Override
//	public boolean offer(Object item) {
//		linkedlist.addLast(item);
//		return true;
//	}
//
//	@Override
//	public Object poll() {
//		return linkedlist.removeFirst();
//	}
//
//	@Override
//	public Object peek() {
//		return linkedlist.getFirst();
//	}
//
//	@Override
//	public String toString() {
//		MyLinkedList tmp = new MyLinkedList();
//		tmp.first = linkedlist.first;
//		String out = "";
//
//		while (tmp.first.next != null) {
//			out += tmp.first + " ";
//			tmp.first = tmp.first.next;
//		}
//
//		return out += tmp.first;
//	}
//
//	/***
//	 * Adds q to the end of the current queue. Queue q is then cleared.
//	 */
//	public void append(LLQueue q) {
//		LLQueue tmp = new LLQueue();
//		tmp.linkedlist.first = q.linkedlist.first;
//		while (tmp.linkedlist.first != null)
//			this.linkedlist.addLast(tmp.linkedlist.removeFirst());
//	}
//
//	/**
//	 * Inserts q to the current queue alternately. Queue q is then cleared.
//	 */
//	public LLQueue alternate(LLQueue q) {
//		LLQueue tmp = new LLQueue();
//
//		while (q.linkedlist.first != null && this.linkedlist.first != null) {
//			tmp.linkedlist.addLast(this.linkedlist.removeFirst());
//			tmp.linkedlist.addLast(q.linkedlist.removeFirst());
//		}
//		while (q.linkedlist.first != null) {
//			tmp.linkedlist.addLast(q.linkedlist.removeFirst());
//		}
//		while (this.linkedlist.first != null) {
//			tmp.linkedlist.addLast(this.linkedlist.removeFirst());
//		}
//
//		return tmp;
//	}
//
//	public static void main(String[] args) {
//		System.out.println("Initializing");
//		LLQueue queue = new LLQueue();
//		for (int k = 1; k <= 5; k++)
//			queue.offer(new Integer(k));
//		System.out.println(queue);
//
//		LLQueue queue2 = new LLQueue();
//		for (int k = 11; k <= 15; k++)
//			queue2.offer(new Integer(k));
//		System.out.println(queue2);
//
//		LLQueue queue3 = new LLQueue();
//		for (int k = 21; k <= 27; k++)
//			queue3.offer(new Integer(k));
//		System.out.println(queue3);
//
//		queue.append(queue3);
//		System.out.println("\nAppend");
//		System.out.println(queue);
//
//		System.out.println("\nPolling");
//		while (!(queue.empty())) {
//			System.out.print(queue.poll() + " ");
//		}
//
//		LLQueue queue4 = queue3.alternate(queue2);
//		System.out.println("\n\nAlternate");
//		System.out.println(queue4);
//	}
//
//}
