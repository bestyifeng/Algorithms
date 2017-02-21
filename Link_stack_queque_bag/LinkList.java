package simpleDataStructure;

import java.util.Iterator;

public class LinkList<Item> implements Iterable<Item>{
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
	
	public void deleteEnd(){
		Node current = first;
		for(int i=0; i<N-2; i++)
		{
			current = current.next;
		}
		current.next = null;
		last = current;
		N--;
	}
	
	public void delete(int key){
		if (key == N)
		{
			deleteEnd();
		}
		else if (key == 1)
		{
			pop();
		}
		else if (key < N && key > 1)
		{
			Node current = first;
			for(int i=0; i<key-2; i++)
				current = current.next;
			current.next = current.next.next;
			N--;
		}
	}
	
	public void remove(Item item){
		//delete first item if suited.
		while(first.item.equals(item))
		{
			delete(1);
		}
		
		Node current = first;
		int count = 1;
		while(current.next != null)
		{
			count++;
			if(current.next.item.equals(item))
			{
				delete(count);
				count--;
			}
			else
				current = current.next;
		}
	}
	
	public void removeAfter(Item item){
		if(N > 2)
		{
			int count = 1;
			Node current = first;
			for(int i=0; i<N-1; i++)
			{
				if (current.item.equals(item))
				{
					break;
				}
				count++;
				current = current.next;
			}
			current.next = null;
			last = current;
			N = count;
			StdOut.println("count = " + N);
		}
	}
	
	public void insertAfter(Item one, Item two){
		Node current = first;
		boolean find = false;
		if(N > 2)
		{
			for(int i=0; i<N-1; i++)
			{
				if (current.item.equals(one))
				{
					find = true;
					break;
				}
				current = current.next;
			}
		}
		if(find)
		{
			Node node = new Node(two);
			if(current.next == null)
				last = node;
			else
				node.next = current.next;
			current.next = node;
			N++;
		}
		StdOut.println("count = " + N);
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
		for(int i=0; i<N; i++)
		{
			str += current.item + " ";
			current = current.next;
		}
		return str;
	}
}

