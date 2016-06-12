/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	MyLinkedList<Integer> lst;
 	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own

	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		lst = new MyLinkedList<Integer>();
		lst.add(0, 1);
		lst.remove(0);
		lst.add(0, 1);
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		int b = list1.remove(list1.size()-1);
		assertEquals("Remove: check b is correct ", 42, b);
		assertEquals("Remove: check element last is correct ", (Integer)21, list1.get(list1.size-1));
		assertEquals("Remove: check size is correct ", 1, list1.size());
		try{
			list1.remove(-1);
			fail("Check out of bounds");
		}catch(IndexOutOfBoundsException e){}
		try{
			list1.remove(100);
			fail("Check IndexOutOfBounds");
		}catch(IndexOutOfBoundsException e){}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		assertEquals("Add at end",shortList.add("C"),true);
		assertEquals("Size check",shortList.size,3);
		assertEquals("Tail check",shortList.get(2),"C");
		assertEquals("Add at end",shortList.add("D"),true);
		assertEquals("Size check",shortList.size,4);
		assertEquals("Tail check",shortList.get(3),"D");
		try{
			list1.add(null);
			fail("Check null object");
		}catch(NullPointerException ne){}
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size check shortList",shortList.size,2);
		assertEquals("Size check emptyList",emptyList.size,0);
		assertEquals("Size check longerList",longerList.size,LONG_LIST_LENGTH);
		assertEquals("Size check list1",list1.size,3);
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try{
			emptyList.add(-1, 5);
			fail("Check IndexOutOfBounds");
		}catch(IndexOutOfBoundsException e){}
		try{
			list1.add(100, 10);
			fail("Check IndexOutOfBounds");
		}catch(IndexOutOfBoundsException e){}
		try{
			list1.add(0,null);
			fail("Check null object");
		}catch(NullPointerException ne){}
		list1.add(1, 51);
		assertEquals("Tail check",list1.get(1).toString(),"51");
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try{
			emptyList.set(1,50);
		}catch(IndexOutOfBoundsException e){}
		try{
			list1.set(-1, 5);
			fail("Check IndexOutOfBounds");
		}catch(IndexOutOfBoundsException e){}
		try{
			list1.set(100, 10);
			fail("Check IndexOutOfBounds");
		}catch(IndexOutOfBoundsException e){}
		try{
			list1.set(0,null);
			fail("Check null object");
		}catch(NullPointerException ne){}
	    list1.set(0,5);
	    int l = list1.get(0);
	    assertEquals("Correctness check",l,5);
	}
	
	
	// TODO: Optionally add more test methods.
	
}
