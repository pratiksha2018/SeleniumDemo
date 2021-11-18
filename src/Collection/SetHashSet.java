package Collection;

import java.util.HashSet;
import java.util.Iterator;

public class SetHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> s = new HashSet<String>();
		s.add("A");
		s.add("B");
		s.add("A");
		System.out.println(s);
		
		Iterator<String> I = s.iterator();
		while(I.hasNext())
		{
			System.out.println(I.hasNext());
		}

	}

}
