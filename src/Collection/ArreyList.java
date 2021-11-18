package Collection;

import java.util.ArrayList;

public class ArreyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("A");
		a.add(1, "pub1");
		a.add(2, "pub2");
		a.add(1, "pub5");
		System.out.println(a.contains("pub1hh"));
	}

}
