package Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMAP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> m = new HashMap<Integer, String>();
		m.put(0, "hhjdyjew");
		m.put(1, "hhjdyjew1");
		m.put(2, "hhjdyjew2");
		m.put(3, "hhjdyjew3");
		m.put(4, "hhjdyjew4");
		
		Set<Entry<Integer, String>> set = m.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext())
		{
			Map.Entry mp =(Map.Entry)i.next();
			System.out.println(mp.getKey());
			System.out.println(mp.getValue());
			
		}
	}

}
