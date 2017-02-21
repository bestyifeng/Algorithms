package simpleDataStructure;

import java.util.Iterator;

public class DoubleLinkList<Item> implements Iterable<Item>{
	private Node first;
	private Node last;
	private int N;
	
	private class Node{
		Item item;
		Node pre;
		Node next;
		
		public Node(Item item){
			this.item = item;
		}
	}
	
	public void addOnTop(Item item){
		Node node = new Node(item);
		if(N == 0)
		{
			first = node;
			last = node;
		}
		else
		{
			first.pre = node;
			node.next = first;
			first = node;
		}
		N++;
	}
	
	public void addOnEnd(Item item){
		Node node = new Node(item);
		if(N == 0)
		{
			first = node;
			last = node;
		}
		else
		{
			last.next = node;
			node.pre = last;
			last = node;
		}
		N++;
	}
	
	public Item deleteTop(){
		Item item = first.item;
		if(isEmpty())
			return null;
		else if (N == 1)
		{
			first = null;
			last = null;
		}
		else
		{
			first = first.next;
			first.pre = null;
		}
		return item;
	}
	
	public Item deleteEnd(){
		Item item = last.item;
		if(isEmpty())
			return null;
		else if (N == 1)
		{
			first = null;
			last = null;
		}
		else
		{
			last = last.pre;
			last.next = null;
		}
		return item;
	}
	
	public void insertAfter(Item item, Item thing){
		Node current = first;
		while(!current.item.equals(item))
		{
			current = current.next;
			if (current == null)
			{
				StdOut.println("Can not find item.");
				return;
			}
		}
		Node node = new Node(thing);
		if (current.next == null)
		{
			current.next = node;
			node.pre = current;
			last = node;
		}		
		else
		{
			node.next = current.next;
			current.next.pre = node;
			current.next = node;
			node.pre = current;
		}
		N++;
	}
	
	public void insertBefore(Item item, Item thing){
		Node current = first;
		while(!current.item.equals(item))
		{
			current = current.next;
			if (current == null)
			{
				StdOut.println("Can not find item.");
				return;
			}
		}
		Node node = new Node(thing);
		if (current.pre == null)
		{
			current.pre = node;
			node.next = current;
			first = node;
		}		
		else
		{
			node.pre = current.pre;
			current.pre.next = node;
			current.pre = node;
			node.next = current;
		}
		N++;
	}
	
	public void delete(Item item){
		Node current = first;
		while(current != null){
			if(current.item.equals(item))
			{
				if(N == 1)
				{
					first = null;
					last = null;
					return;
				}
				else if (current == first)
				{
					first = current.next;
					first.pre = null;
				}
				else if (current == last)
				{
					last = last.pre;
					last.next = null;
				}
				else
				{
					current.next.pre = current.pre;
					current.pre.next = current.next;
				}
				N--;
			}
			current = current.next;
		}
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
	
	public String toString(){
		String str = new String("");
		Node current = first;
		while(current != null)
		{
			str += current.item + " ";
			current = current.next;
		}
		return str;
	}
}

