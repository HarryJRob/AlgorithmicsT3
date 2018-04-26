package Trees;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

	private final int DATASET_ARRAY_SIZE = 10000;
	
	private BinarySearchTree<Integer> bst;
	
	private Integer[] dataset = new Integer[DATASET_ARRAY_SIZE];
	
	@Before
	public void setUp(){
		bst = new BinarySearchTree<Integer>();
		dataset = generateUniqueDataSet(DATASET_ARRAY_SIZE);
	}
	
	//Generates a dataset with no repeating numbers of size n
	private Integer[] generateUniqueDataSet(int size) {
		Integer[] tempArray = new Integer[size*3];
		
		for(int i = 0; i < size*3; i++) {
			tempArray[i] = i;
		}
		
		Collections.shuffle(Arrays.asList(tempArray));
		return Arrays.copyOf(tempArray, size);
	}
	
	//Adds a collection to a binary tree
	private void addDataToBST(Object[] objArray, BinarySearchTree bst) {
		
		for(Object curObj : objArray) {
			bst.add(curObj);
		}
	}
	
	@Test
	public void addValidDataTest() {
		for(int i = 0; i < dataset.length; i++) {
			assertEquals(true, bst.add(dataset[i]));
		}
	}
	
	@Test
	public void addInvalidDataTest() {
		addDataToBST(dataset, bst);
		
		assertEquals(false, bst.add(dataset[(int) (Math.random() * dataset.length)]));
	}

	@Test
	public void removeValidDataTest() {
		addDataToBST(dataset, bst);
		
		for(int i = 0; i < dataset.length; i++) {
			assertEquals(true, bst.remove(dataset[i]));
		}
	}
	
	@Test
	public void removeInvalidDataTest() {
		addDataToBST(dataset, bst);
		
		assertEquals(false, bst.remove(-1));
	}
	
	@Test
	public void containsValidDataTest() {
		addDataToBST(dataset, bst);
		
		assertEquals(true, bst.contains(dataset[(int) (Math.random() * dataset.length)]));
	}
	
	@Test
	public void containsInvalidDataTest() {
		addDataToBST(dataset, bst);
		
		assertEquals(false, bst.contains(-1));
	}
	
	@Test
	public void iteratorLoopsTest() {
		addDataToBST(dataset, bst);
		
		Iterator<Integer> it = bst.iterator();
		
		assertNotNull(it);
		
		Arrays.sort(dataset);
		
		int i = 0;
		while(it.hasNext()) {
			assertEquals(dataset[i] , it.next());
			i++;
		}
		
		i = 0;
		while(it.hasNext()) {
			it.hasNext();
			assertEquals(dataset[i] , it.next());
			i++;
		}
	}
	
	@Test
	public void iteratorRemoveTest() {
		addDataToBST(dataset, bst);
		
		Iterator<Integer> it = bst.iterator();
		
		while(it.hasNext()) {
			it.next();
			it.remove();
		}
		
		assertEquals(0, bst.size());
	}
	
	@Test(expected = IllegalStateException.class)
	public void iteratorRemoveErrorTest() {
		
		addDataToBST(dataset, bst);
		
		Iterator<Integer> it = bst.iterator();
		
		it.remove();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void iteratorNextErrorTest() {
		addDataToBST(dataset, bst);
		
		Iterator<Integer> it = bst.iterator();
		
		while(it.hasNext()) { it.next(); }
		
		it.next();
	}
	
	//Used for question 3. Not actually a test
	@Test
	public void depthVsInputs() {
		addDataToBST(dataset, bst);
		
		for(int i = 100; i <= DATASET_ARRAY_SIZE; i+= 100) {
			
			double totalDepth = 0;
			
			for(int repeats = 0; repeats < 3; repeats++ ) {
				bst = new BinarySearchTree<Integer>();
				addDataToBST(generateUniqueDataSet(i), bst);
				totalDepth += bst.averageDepth();
				//System.out.print("\t" + (repeats+1) + " : " + bst.averageDepth());
			}
			System.out.println( i + "\t" + (totalDepth/3.0f));
		}
		
	}
}
