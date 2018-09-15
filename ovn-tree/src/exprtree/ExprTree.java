package exprtree;

public class ExprTree {
	private ExprNode root;

	public ExprTree() {
		root = null;
	}

	/**
	 * Skapar ett binärt träd med innehållet data i roten och med leftTree som
	 * vänster underträd och rightTree som höger underträd.
	 */
	public ExprTree(String element, ExprTree leftTree, ExprTree rightTree) {
		root = new ExprNode(element);
		if (leftTree != null) {
			root.left = leftTree.root;
		} else {
			root.left = null;
		}
		if (rightTree != null) {
			root.right = rightTree.root;
		} else {
			root.right = null;
		}
	}

	/**
	 * Returnerar en teckensträng som representerar uttrycket. Teckensträngen
	 * innehåller parenteser runt alla deluttryck, utom runt talen.
	 */
	public String fullParen() {
		return null;
	}

	private static class ExprNode {
		public ExprNode(String element) {
			this.element = element;
		}

		String element;
		ExprNode left;
		ExprNode right;
	}

	public static void main(String[] args) {
		ExprTree empty = new ExprTree();
		System.out.println(empty.fullParen());

		ExprTree leftOp = new ExprTree("9", null, null);
		ExprTree rightOp = new ExprTree("2", null, null);
		ExprTree minus = new ExprTree("-", leftOp, rightOp);

		leftOp = new ExprTree("5", null, null);
		ExprTree mult = new ExprTree("*", leftOp, minus);

		rightOp = new ExprTree("7", null, null);
		ExprTree tree = new ExprTree("+", mult, rightOp);
		System.out.println(tree.fullParen());
	}
}
