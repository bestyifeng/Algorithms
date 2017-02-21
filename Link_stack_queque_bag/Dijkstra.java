package simpleDataStructure;

//Evaluate (1+((2+3)*(4*5))) using double Stack.
public class Dijkstra {

	public static void main(String[] args) {
		Stack<Double> vals = new Stack<Double>();
		Stack<String> ops = new Stack<String>();
		In in = new In("E:/Java/eclipse/MyTest/src/simpleDataStructure/evaluate.txt");
		while(!in.isEmpty())
		{
			String str = in.readString();
			if(str.equals("(")) {}
			else if(str.equals("+")) ops.push(str);
			else if(str.equals("-")) ops.push(str);
			else if(str.equals("*")) ops.push(str);
			else if(str.equals("/")) ops.push(str);
			else if(str.equals("sqrt")) ops.push(str);
			else if(str.equals(")"))
			{
				String op = ops.pop();
				double v = vals.pop();
				
				if (op.equals("+")) v = vals.pop() + v;
				else if (op.equals("-")) v = vals.pop() - v;
				else if (op.equals("*")) v = vals.pop() * v;
				else if (op.equals("/")) v = vals.pop() / v;
				else if (op.equals("sqrt")) v = Math.sqrt(v);
				
				vals.push(v);
			}
			else vals.push(Double.parseDouble(str));
		}
		StdOut.println(vals.pop());
	}

}
