package me.mren.stringiterator;

import java.util.Iterator;

public class Runner {

	public static void main(String[] args) {
		Iterator<String> it = new StringIterator(3, "ABCD".toCharArray());
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
