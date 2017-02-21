package simpleDataStructure;

public class LinkTest {

	public static void main(String[] args) {
		LinkList<Integer> link = new LinkList<Integer>();
		link.push(1);
		link.push(2);
		link.push(3);
		link.push(2);
		link.push(1);
		StdOut.println(max(link));
		
	}
	
	public static boolean find(LinkList<String> link, String key){
		for(String str : link)
		{
			if (str.equals(key))
				return true;
		}
		return false;
	}
	
	public static int max(LinkList<Integer> link){
		int max = Integer.MIN_VALUE;
		for(Integer i : link)
		{
			if(i > max){
				max = i;
			}
		}
		return max;
	}
}
