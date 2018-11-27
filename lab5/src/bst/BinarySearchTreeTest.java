package bst;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import bst.BinarySearchTree;


class BinarySearchTreeTest {
	
	BinarySearchTree<Integer> myBinarySearchTree;

	@BeforeEach
	public void setUp() throws Exception {
		myBinarySearchTree = new BinarySearchTree<Integer>();
	}


	@Test
	void testHeight() {
		assertTrue(myBinarySearchTree.add(3));
		assertTrue(myBinarySearchTree.add(20));
		assertTrue(myBinarySearchTree.add(34));
		assertTrue(myBinarySearchTree.add(15));
		assertTrue(myBinarySearchTree.height() == 3);
	}
	

	@Test
	void testHeightEmpty() {
		assertTrue(myBinarySearchTree.height() == 0);
	}
	
	@Test
	void testsizeEmpty() {
		assertTrue(myBinarySearchTree.size() == 0);
	}
	
	@Test
	void testAdd() {
		assertTrue(myBinarySearchTree.add(3));
		assertTrue(myBinarySearchTree.add(21));
		assertTrue(myBinarySearchTree.add(45));
		assertTrue(myBinarySearchTree.add(20));
		assertTrue(myBinarySearchTree.root.element == 3);
		assertTrue(myBinarySearchTree.root.right.element == 21);
		assertTrue(myBinarySearchTree.root.right.right.element == 45);
		myBinarySearchTree.printTree();
	}
	
	@Test
	void testAddDubletter() {
		assertTrue(myBinarySearchTree.add(3));
		assertFalse(myBinarySearchTree.add(3));
	}
	
	@Test
	void testSize() {
		assertTrue(myBinarySearchTree.add(3));
		assertTrue(myBinarySearchTree.add(2));
		assertTrue(myBinarySearchTree.add(1));
		assertTrue(myBinarySearchTree.add(4));
		assertTrue(myBinarySearchTree.size() == 4);
	}

}
