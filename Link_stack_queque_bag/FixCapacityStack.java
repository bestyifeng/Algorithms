package simpleDataStructure;

public class FixCapacityStack<Item> {
	
	private Item[] a;
	private int N;
	
	public FixCapacityStack(int cap){
		a = (Item[])new Object[cap];
		N = 0;
	}
	
	public void push(Item item){
		a[N++] = item;
	}
	
	public Item pop(){
		return a[--N];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public boolean isFull(){
		return N == a.length;
	}
	
	public int size(){
		return N;
	}
}
