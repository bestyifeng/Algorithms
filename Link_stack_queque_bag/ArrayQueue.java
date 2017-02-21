package simpleDataStructure;

import java.util.Iterator;

public class ArrayQueue<Item> implements Iterable<Item> {
	Item[] a;
	private int in;
	private int out;
	
	public ArrayQueue(){
		a = (Item[]) new Object[1];
	}
	
	public void push(Item item){
		if(in == a.length)
		{
			Item[] newItem = (Item[])new Object[2 * a.length];
			for(int i=0; i<a.length; i++)
			{
				newItem[i] = a[i];
			}
			a = newItem;
		}
		a[in++] = item;
	}
	
	public Item pop(){
			return a[out++];
	}
	public boolean isEmpty(){
		return in - out == 0;
	}
	
	public int size(){
		return in - out;
	}
	public Iterator<Item> iterator(){
		return new ArrayQueueIterator();
	}
	
	private class ArrayQueueIterator implements Iterator<Item>{
		private int index = out;
		
		public boolean hasNext(){
			return in - index == 0;
		}
		
		public Item next(){
			return a[index++];
		}
	}
	
}
