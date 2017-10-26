import static org.junit.Assert.*;
import org.junit.Test;

/** SongTest.java - 
 * A JUnit test class for Song's equals(Song) and compareTo(Song) methods.
 * 
 * @author Aidan Kierans
 * @version 1.0
 * @since Project 2 of CMSC 256, Fall 2017
 */
public class SongTest {

	/**
	 * Test method for {@link Song#equals(Song)}, 
	 * which makes sure Song(null, null, null)
	 * and Song() are equal.
	 */
	@Test
	public void testEqualsNull1() {
	Song a = new Song(null, null,null);
	Song b = new Song();
		assertTrue(a.equals(b));
	}
	
	/**
	 * Test method for {@link Song#equals(Song)}, 
	 * which makes sure Song(null, null, null)
	 * and Song() are equal.
	 */
	@Test
	public void testEqualsNull2() {
	Song a = new Song(null, null,null);
		assertTrue(a.equals(null));
	}
	
	
	/**
	 * Test method for {@link Song#equals(Song)}, 
	 * which sees if a song initialized using the 
	 * default constructor is equal to itself.
	 */
	@Test
	public void testEqualsSongReflexive1() {
	Song mySong = new Song();
		assertTrue(mySong.equals(mySong));
	}	
	
	/**
	 * Test method for {@link Song#equals(Song)}, 
	 * which sees if a song initialized using 
	 * Song(String, String, String) is equal to itself.
	 */
	@Test
	public void testEqualsSongReflexive2() {
	Song mySong = new Song("a","b","c");
		assertTrue(mySong.equals(mySong));
	}

	/**
	 * Test method for {@link Song#equals(Song)}, 
	 * which sees if a song initialized using 
	 * Song(null, null, null) is equal to itself.
	 */
	@Test
	public void testEqualsSongReflexive3() {
	Song mySong = new Song(null, null, null);
		assertTrue(mySong.equals(mySong));
	}

	/**
	 * Test method for {@link Song#equals(Song)}, 
	 * which makes sure a.equals(b) = b.equals(a)
	 */
	@Test
	public void testEqualsSongSymmetric1() {
	Song a = new Song();
	Song b = new Song();
		assertEquals(null, a.equals(b), b.equals(a));
	}
	
	/**
	 * Test method for {@link Song#equals(Song)}, 
	 * which makes sure a.equals(b) = b.equals(a)
	 */
	@Test
	public void testEqualsSongSymmetric2() {
	Song a = new Song("a","b","c");
	Song b = new Song("a","b","c");
		assertEquals(null, a.equals(b), b.equals(a));
	}
	
	/**
	 * Test method for {@link Song#equals(Song)}, 
	 * which makes sure a.equals(b) = b.equals(a)
	 */
	@Test
	public void testEqualsSongSymmetric3() {
	Song a = new Song("a","b","c");
	Song b = new Song("d","e","f");
		assertEquals(null, a.equals(b), b.equals(a));
	}
	
	/**
	 * Test method for {@link Song#equals(Song)}, 
	 * which sees if a.equals(c), provided that
	 *  a.equals(b) and b.equals(c).
	 */
	@Test
	public void testEqualsSongTransitive1() {
		Song a = new Song();
		Song b = new Song();
		Song c = new Song();
	
		assertEquals(null, (a.equals(b) && b.equals(c)), a.equals(c));
	}	
	
	/**
	 * Test method for {@link Song#equals(Song)}, 
	 * which sees if a.equals(c), provided that
	 *  a.equals(b) and b.equals(c).
	 */
	@Test
	public void testEqualsSongTransitive2() {
		Song a = new Song("a", "b", "c");
		Song b = new Song("a", "b", "c");
		Song c = new Song("a", "b", "c");
	
		assertEquals(null, (a.equals(b) && b.equals(c)), a.equals(c));
	}	

	/**
	 * Test method for {@link Song#equals(Song)}, 
	 * which sees if a.equals(b) is consistent.
	 */
	@Test
	public void testEqualsSongConsistent1() {
		Song a = new Song();
		Song b = new Song();

		assertEquals(null, a.equals(b), a.equals(b));
	}	
	
	/**
	 * Test method for {@link Song#equals(Song)}, 
	 * which sees if a.equals(b) is consistent.
	 */
	@Test
	public void testEqualsSongConsistent2() {
		Song a = new Song("a", "b", "c");
		Song b = new Song("a", "b", "c");

		assertEquals(null, a.equals(b), a.equals(b));
	}	

	/**
	 * Test method for {@link Song#compareTo(Song)},
	 * to see if a.compareTo(a) returns 0.
	 */
	@Test
	public void testCompareToReflexive1() {
		Song a = new Song();		
		assertEquals(null, 0, a.compareTo(a));
	}

	/**
	 * Test method for {@link Song#compareTo(Song)},
	 * to see if a.compareTo(a) returns 0.
	 */
	@Test
	public void testCompareToReflexive2() {
		Song a = new Song("a", "b", "c");		
		assertEquals(null, 0, a.compareTo(a));
	}

	/**
	 * Test method for {@link Song#compareTo(Song)}.
	 */
	@Test
	public void testCompareTo1() {
		Song a = new Song("", "", "");
		Song b = new Song();
		
		assertEquals(null, 0, a.compareTo(b));
	}
	
	/**
	 * Test method for {@link Song#compareTo(Song)}.
	 */
	@Test
	public void testCompareTo2() {
		Song a = new Song("b", "c", "a");
		Song b = new Song("b", "c", "a");
		
		assertEquals(null, 0, a.compareTo(b));
	}
	
	/**
	 * Test method for {@link Song#compareTo(Song)}.
	 * This test makes sure album comparison works
	 * correctly.
	 */
	@Test
	public void testCompareTo3() {
		Song a = new Song("b", "b", "a");
		Song b = new Song("a", "a", "b");
		
		assertEquals(null, -1, a.compareTo(b));
	}
	
	/**
	 * Test method for {@link Song#compareTo(Song)}.
	 * This test makes sure album comparison works
	 * correctly.
	 */
	@Test
	public void testCompareTo4() {
		Song a = new Song("a", "a", "b");
		Song b = new Song("b", "b", "a");
		
		assertEquals(null, 1, a.compareTo(b));
	}
	
	/**
	 * Test method for {@link Song#compareTo(Song)}.
	 * This test makes sure title comparison works
	 * correctly.
	 */
	@Test
	public void testCompareTo5() {
		Song a = new Song("a", "b", "c");
		Song b = new Song("b", "a", "c");
		
		assertEquals(null, -1, a.compareTo(b));
	}

	/**
	 * Test method for {@link Song#compareTo(Song)}.
	 * This test makes sure title comparison works
	 * correctly.
	 */
	@Test
	public void testCompareTo6() {
		Song a = new Song("b", "a", "c");
		Song b = new Song("a", "b", "c");
		
		assertEquals(null, 1, a.compareTo(b));
	}
	
	/**
	 * Test method for {@link Song#compareTo(Song)}.
	 * This test makes sure artist comparison works
	 * correctly.
	 */
	@Test
	public void testCompareTo7() {
		Song a = new Song("c", "a", "c");
		Song b = new Song("c", "b", "c");
		
		assertEquals(null, -1, a.compareTo(b));
	}

	/**
	 * Test method for {@link Song#compareTo(Song)}.
	 * This test makes sure artist comparison works
	 * correctly.
	 */
	@Test
	public void testCompareTo8() {
		Song a = new Song("c", "b", "c");
		Song b = new Song("c", "a", "c");
		
		assertEquals(null, 1, a.compareTo(b));
	}

	/**
	 * Test method for {@link Song#compareTo(Song)}.
	 * This test makes sure comparing non-empty strings
	 * to empty strings works correctly.
	 */
	@Test
	public void testCompareTo9() {
		Song a = new Song("a", "a", "a");
		Song b = new Song();
		
		assertEquals(null, 1, a.compareTo(b));
	}

	/**
	 * Test method for {@link Song#compareTo(Song)}.
	 * This test makes sure comparing non-empty strings
	 * to empty strings works correctly.
	 */
	@Test
	public void testCompareTo10() {
		Song a = new Song();
		Song b = new Song("a", "a", "a");
		
		assertEquals(null, -1, a.compareTo(b));
	}

}
