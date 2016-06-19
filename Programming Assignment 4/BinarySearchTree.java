
public class BinarySearchTree<T extends Comparable> {
	private TreeNode root;
	
	class TreeNode {
		private T label;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(T label) {
			setLabel(label);
		}
		
		public T getLabel() {
			return label;
		}
		
		public void setLabel(T label) {
			this.label = label;
		}
		
		public TreeNode getLeft() {
			return left;
		}
		
		public void setLeft(TreeNode left) {
			this.left = left;
		}
		
		public TreeNode getRight() {
			return right;
		}
		
		public void setRight(TreeNode right) {
			this.right = right;
		}
		
		public int getComparison(T element) {
			return element.compareTo(label);
		}
		
		public TreeNode getLargest() {
			if (getRight() != null)
				return getRight().getLargest();
			return this;
		}
	}
	
	
	public BinarySearchTree() {
		root = null;
	}
	
	public void addElement(T element) {
		root = addElement(root, element);
	}
	
	private TreeNode addElement(TreeNode node, T element) {
		if (node == null)
			return new TreeNode(element);
		int comparison = node.getComparison(element);
		if (comparison < 0)
			node.setLeft(addElement(node.getLeft(), element));
		else if (comparison > 0)
			node.setRight(addElement(node.getRight(), element));
		return node;
	}
	
	public boolean containsElement(T element) {
		return containsElement(root, element);
	}
	
	private boolean containsElement(TreeNode node, T element) {
		if (node == null)
			return false;
		int comparison = node.getComparison(element);
		if (comparison == 0)
			return true;
		if (comparison < 0)
			return containsElement(node.getLeft(), element);
		return containsElement(node.getRight(), element);
	}
	
	public void deleteElement(T element) {
		root = deleteElement(root, element);
	}
	
	private TreeNode deleteElement(TreeNode node, T element) {
		if (node == null)
			return null;
		int comparison = node.getComparison(element);
		if (comparison == 0) {
			if (node.getLeft() == null)
				return node.getRight();
			if (node.getRight() == null)
				return node.getLeft();
			TreeNode nextLargest = node.getLeft().getLargest();
			node.setLabel(nextLargest.getLabel());
			nextLargest.setLabel(element);
			node.setLeft(deleteElement(node.getLeft(), element));
		}
		else if (comparison < 0)
			node.setLeft(deleteElement(node.getLeft(), element));
		else
			node.setRight(deleteElement(node.getRight(), element));

		return node;
	}
	
	public void printInOrder() {
		printInOrder(root);
	}
	
	private void printInOrder(TreeNode node) {
		if (node != null) {
			printInOrder(node.getLeft());
			System.out.println(node.getLabel());
			printInOrder(node.getRight());
		}
	}
	
	public void printPostOrder() {
		printPostOrder(root);
	}
	
	private void printPostOrder(TreeNode node) {
		if (node != null) {
			printInOrder(node.getLeft());
			printInOrder(node.getRight());
			System.out.println(node.getLabel());
		}
	}
	
	
}
