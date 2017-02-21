package simpleDataStructure;

import java.util.Iterator;

//last in and first out.
public class Stack<Item> implements Iterable<Item>{
	private Node first;
	private int N;
	
	public void push(Item item){
		Node oldFirst = first;
		Node node = new Node(item);
		first = node;
		node.next = oldFirst;
		N++;
	}
	
	public Item pop(){
		Item re = first.item;
		first = first.next;
		N--;
		return re;
	}
	
	public Item peek(){
		return first.item;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	
	private class Node{
		Item item;
		Node next;
		
		Node(Item item){
			this.item = item;
			next = null;
		}
	}

	public Iterator<Item> iterator(){
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Item>{
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
