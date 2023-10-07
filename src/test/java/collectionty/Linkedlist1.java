package collectionty;

import java.util.LinkedList;

public class Linkedlist1 {

	public static void main(String[] args) {
		LinkedList<Object> list=new LinkedList<Object>();
		list.add(20);
		list.add(30);
		list.add("hi");
		list.add(null);
		list.add(20);
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		list.addFirst(100);
		list.addLast("hey");
		System.out.println(list);
		System.out.println(list.removeFirst());
		System.out.println(list.removeLast());
		System.out.println(list);
	}

}
