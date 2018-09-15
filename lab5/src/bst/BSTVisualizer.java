package bst;

import java.awt.Color;

import bst.BinarySearchTree.BinaryNode;
import drawing.*;

public class BSTVisualizer {
	private DrawingArea canvas;
	
	// width of empty tree (i.e. "null nodes")
	private final static int EMPTY_TREE_WIDTH = 0; // = 1;
	// diameter of nodes;
	private final static int DIAMETER = 20;
	// horizontal distance between nodes on same level
	private final static int HORIZONTAL_DIST = 1;
	// vertical distance between levels
	private final static int VERTICAL_DIST = 10;
	// distance between node (circle) center and content string
	private final static int OFFSET = -10;

	/**
	 * Creates a canvas with a certain title, width, height.
	 */
	public BSTVisualizer(String title, int width, int height) {
		canvas = new DrawingArea(title, width, height, Color.white);
	}

	/**
	 * Draws a binary search tree on the canvas.
	 */
	public void drawTree(BinarySearchTree<?> bst) {
		if (bst.root != null) {
			canvas.erase();
			VNode root = buildVTree(bst);
			calculateWidth(root);
			drawTree(root, 1, 0);
			canvas.paint();
		}
	}
	
	/* ------ Private auxiliary methods -------------- */

	private void calculateWidth(VNode root) {
		if(root.node == null) {
			root.width = EMPTY_TREE_WIDTH;
		} else {
			calculateWidth(root.left  = new VNode(root.node.left));
			calculateWidth(root.right = new VNode(root.node.right));
			root.width = 1 + root.left.width + root.right.width;
		}
	}

	private VNode buildVTree(BinarySearchTree<?> bst) {
		VNode root = new VNode(bst.root);
		buildVTree(root);
		return root;
	}
	
	private void buildVTree(VNode root) {
		if(root.node != null) {
			root.left = new VNode(root.node.left);
			root.right = new VNode(root.node.right);
		}
	}

	private void drawTree(VNode vnode, int level, int offset) {
		int col = 1 + vnode.left.width + offset;
		int xPos = computeXpos(col);
		int yPos = computeYpos(level);
		int childYpos = computeYpos(level + 1);
		
		if (vnode.left.node != null) {
			int leftChildXpos = computeXpos(1+vnode.left.left.width+offset);
			canvas.drawLine(Color.BLACK, xPos, yPos, leftChildXpos, childYpos);
			drawTree(vnode.left, level + 1, offset);
		}
		if (vnode.node.right != null) {
			int rightChildXpos = computeXpos(1+col+vnode.right.left.width);
			canvas.drawLine(Color.BLACK, xPos, yPos, rightChildXpos, childYpos);
			drawTree(vnode.right, level + 1, col);
		}
		
		String text = String.valueOf(vnode.node.element);
		canvas.fillCircle(Color.BLUE, xPos, yPos, DIAMETER);
		canvas.drawString(Color.BLACK, text, xPos + OFFSET, yPos + OFFSET);
	}

	/* Compute y-position of a node from its level. */
	private int computeYpos(int level) {
		return level * (DIAMETER + VERTICAL_DIST);
	}

	/* Compute x-position of a node from its inordernumber. */
	private int computeXpos(int actNodeNbr) {
		return actNodeNbr * (DIAMETER + HORIZONTAL_DIST);
	}
	
	private static class VNode {
		BinarySearchTree.BinaryNode<?> node;
		VNode left;
		VNode right;
		int width;
		public VNode(BinaryNode<?> node) {
			this.node = node;
		}
		
	}

}
