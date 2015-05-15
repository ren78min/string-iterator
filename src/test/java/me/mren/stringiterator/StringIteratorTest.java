package me.mren.stringiterator;

import static org.junit.Assert.*;
import me.mren.stringiterator.StringIterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author ren78min
 * 
 */
public class StringIteratorTest {

	private static final String EXPECTED_EXCEPTION = "Should throw exception.";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPasswordIterator() {
		StringIterator pi = new StringIterator(3, new char[] { 'a', 'b',
				'c' });
		assertNotNull(pi);
	}

	@Test
	public void testPasswordIteratorNoLength() {
		try {
			new StringIterator(0, "abc".toCharArray());
			fail(EXPECTED_EXCEPTION);
		} catch (Exception e) {
			// OK
		}
	}

	@Test
	public void testPasswordIteratorNullChars() {
		try {
			new StringIterator(1, null);
			fail(EXPECTED_EXCEPTION);
		} catch (Exception e) {
			// OK
		}
	}

	@Test
	public void testPasswordIteratorEmptyChars() {
		try {
			new StringIterator(1, new char[0]);
			fail(EXPECTED_EXCEPTION);
		} catch (Exception e) {
			// OK
		}
	}

	@Test
	public void testHasNext() {
		StringIterator pi = new StringIterator(1, "ab".toCharArray());
		while (pi.hasNext()) {
			assertNotNull(pi.next());
		}

		try {
			pi.next();
			fail(EXPECTED_EXCEPTION);
		} catch (Exception e) {
			// OK
		}
	}

	@Test
	public void testNext() {
		StringIterator pi = new StringIterator(2,
				"0123456789".toCharArray());
		for (int i = 0; i < 100; i++) {
			String actual = pi.next();
			if (i == 0) {
				assertEquals("00", actual);
			} else if (i < 10) {
				assertEquals("0" + i, actual);
			} else {
				assertEquals("" + i, actual);
			}
		}

		try {
			pi.next();
			fail(EXPECTED_EXCEPTION);
		} catch (Exception e) {
			// OK
		}
	}

}
