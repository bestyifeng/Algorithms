package simpleDataStructure;

public class CompleteParentheses {

	public static void main(String[] args) {
		In in = new In("E:/Java/eclipse/MyTest/src/simpleDataStructure/CompleteParentheses.txt");
		Stack<String> s = new Stack<String>();
		
		while(!in.isEmpty())
		{
			String str = in.readString();
			if (str.equals(")"))
			{
				String str1 = s.pop();
				String str2 = s.pop();
				String str3 = s.pop();
				s.push("(" + str3 + str2 + str1 + ")");
			}
			else 
				s.push(str);
		}
		
		Stack<String> newS = new Stack<String>();
		while(!s.isEmpty())
			newS.push(s.pop());
		
		for(String str : newS)
			StdOut.print(str);
	}

}
