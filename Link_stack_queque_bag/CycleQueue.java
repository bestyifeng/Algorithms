package simpleDataStructure;

import java.util.Iterator;

public class CycleQueue<Item> implements Iterable<Item> {
	private Node last;
	int N;
	
	private class Node{
		Item item;
		Node next;
		
		public Node(Item item){
			this.item = item;
		}
	}
	
	public void push(Item item){
		Node node = new Node(item);
		if(N == 0)
		{
			last = node;
			node.next = node;
		}
		else
		{
			node.next = last.next;
			last.next = node;
			last = node;
		}
		N++;
	}
	
	public Item pop(){
		Item item = last.next.item;
		if(N == 0)
		{
			return null;
		}
		else if(N == 1)
		{
			last = null;
		}
		else
		{
			last.next = last.next.next;
		}
		N--;
		return item;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public int size(){
		return N;
	}
	
	public QueueIterator iterator(){
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item>{
		private Node current = last.next;
		private int n = N;
		private boolean end = false;
		
		public boolean hasNext(){
			if(n == 0)
				return false;
			if(n == 1)
				return !end;
			return !(current == last.next && end == true);
		}
		
		public Item next(){
			Item item = current.item;
			current = current.next;
			end = true;
			return item;
		}
		
		public void remove(){}
	}
}
