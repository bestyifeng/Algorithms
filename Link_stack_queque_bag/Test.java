package simpleDataStructure;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		In in = new In("E:/Java/eclipse/MyTest/src/simpleDataStructure/words.txt");
		DoubleLinkList<String> s = new DoubleLinkList<String>();
		while(!in.isEmpty())
		{
			String str = in.readString();
			if (!str.equals("-"))
				s.addOnTop(str);
			else
				s.addOnEnd(str);;
		}
		StdOut.println(s);
		s.insertAfter("it", "Yifeng");
		StdOut.println(s);
		s.insertBefore("it", "Yifeng");
		StdOut.println(s);
		s.deleteTop();
		StdOut.println(s);
		s.deleteEnd();
		StdOut.println(s);
		s.delete("-");
		StdOut.println(s);
	}

}
