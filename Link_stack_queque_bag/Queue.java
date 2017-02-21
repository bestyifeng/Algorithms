package simpleDataStructure;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{
	private Node first;
	private Node last;
	private int N;
	
	private class Node{
		Item item;
		Node next;
		
		public Node(Item item){
			this.item = item;
		}
	}
	
	public void push(Item item){
		Node oldLast = last;
		last = new Node(item);
		if(isEmpty())
			first = last;
		else
			oldLast.next = last;
		N++;
	}
	
	public Item pop(){
		Item item = first.item;
		first = first.next;
		if(isEmpty())
			last = null;
		N--;
		return item;
	}
	public boolean isEmpty(){
		return N==0;
	}
	
	public int size(){
		return N;
	}
	
	public Iterator<Item> iterator(){
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item>{
		private Node current = first;
		public boolean hasNext(){
			return current != null;
		}
		
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}
