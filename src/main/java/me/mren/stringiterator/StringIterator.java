package me.mren.stringiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author ren78min
 * 
 */
public class StringIterator implements Iterator<String> {

	private int length;
	private char[] chars;
	private int[] map;
	private boolean hasNext = true;

	public StringIterator(int resultLength, char... charsDomain) {
		if (resultLength < 1) {
			throw new IllegalArgumentException("Length is negative.");
		}
		if (charsDomain == null) {
			throw new IllegalArgumentException("char[] is null.");
		}
		if (charsDomain.length == 0) {
			throw new IllegalArgumentException("char[] array is empty.");
		}

		this.length = resultLength;
		this.chars = charsDomain;
		this.map = new int[length];
	}

	public boolean hasNext() {
		return hasNext;
	}

	public String next() {
		if (hasNext) {
			String result = mapToString();
			hasNext = calculateNext(length - 1);
			return result;
		} else {
			throw new NoSuchElementException();
		}
	}

	private boolean calculateNext(int pos) {
		if (pos < 0) {
			return false;
		}

		map[pos]++;
		if (map[pos] == chars.length) {
			map[pos] = 0;
			return calculateNext(pos - 1);
		}
		return true;
	}

	private String mapToString() {
		char[] result = new char[length];
		for (int i = 0; i < length; i++) {
			result[i] = chars[map[i]];
		}
		return new String(result);
	}

}
