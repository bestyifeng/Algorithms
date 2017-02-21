package simpleDataStructure;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item>{
	
	private Item[] a;
	private int N;
	
	public ResizingArrayStack(){
		a = (Item[])new Object[1];
		N = 0;
	}
	
	public void push(Item item){
		if(N == a.length)
		{
			Item[] temp = (Item[])new Object[2 * a.length];
			for(int i=0; i<N; i++)
			{
				temp[i] = a[i];
			}
			a = temp;
		}
		a[N++] = item;
	}
	
	public Item pop(){
		return a[--N];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public Iterator<Item> iterator(){
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{
		//后进先出。
		private int i = N;
		public boolean hasNext(){
			return i > 0;
		}
		
		public Item next(){
			return a[--i];
		}
		
		public void remove(){}
	}
}
