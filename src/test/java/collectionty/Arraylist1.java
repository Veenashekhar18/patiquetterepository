package collectionty;

import java.util.ArrayList;
import java.util.Collections;

public class Arraylist1 {

	public static void main(String[] args) {
		ArrayList<Object> l=new ArrayList<Object>();
		l.add(20);
		l.add(13);
		l.add("hi");
		l.add('R');
		l.add(null);
		l.add(20);
		System.out.println(l);
		ArrayList<Integer> l1=new ArrayList<Integer>();
		l1.add(18);
		l1.add(1318);
		l1.add(13);
		l1.add(58);
		Collections.sort(l1);
		l.add(l1);
		for (Object obj : l) 
		{
			System.out.println(obj);
		}
		System.out.println(l);
		Collections.shuffle(l);
		System.out.println(l);
	}
}
