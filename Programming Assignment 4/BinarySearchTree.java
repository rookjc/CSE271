/**
 * A class for storing a set of arbitrary comparable objects in a tree
 * structure, with no order or duplicates.
 * 
 * @author Jayson Rook
 * @version 1.0
 * @param <T>
 *            The type of objects stored in the tree
 */
public class BinarySearchTree<T extends Comparable<T>> {
	private TreeNode root;

	// Helper class for representing individual tree nodes
	class TreeNode {
		private T label;
		private TreeNode left;
		private TreeNode right;

		// Constructor initializes node with no children
		public TreeNode(T label) {
			setLabel(label);
		}

		public T getLabel() { // accessor for node's label
			return label;
		}

		public void setLabel(T label) { // mutator for node's label
			this.label = label;
		}

		public TreeNode getLeft() { // accessor for node's left child
			return left;
		}

		public void setLeft(TreeNode left) { // mutator for node's left child
			this.left = left;
		}

		public TreeNode getRight() { // accessor for node's right child
			return right;
		}

		public void setRight(TreeNode right) { // mutator for node's right child
			this.right = right;
		}

		// Finds the largest-labeled node descended from (or equal to) this one
		public TreeNode getLargest() {
			if (getRight() != null)
				return getRight().getLargest();
			return this;
		}
	}

	/**
	 * Creates a new tree initialized to be empty
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * Add an element into the tree. Since the tree cannot contain duplicates,
	 * nothing will happen if the tree already contains an equivalent element
	 * 
	 * @param element
	 *            the element to add
	 */
	public void addElement(T element) {
		root = addElement(root, element);
	}

	// Private version of addElement, which specifies a node to add to
	private TreeNode addElement(TreeNode node, T element) {
		// If the tree is empty, create and return a new node labeled with
		// element
		if (node == null)
			return new TreeNode(element);

		int comparison = element.compareTo(node.getLabel());
		if (comparison < 0)
			// this element is "smaller" than node, so put it on the left
			node.setLeft(addElement(node.getLeft(), element));
		else if (comparison > 0)
			// this element is "larger" than node, so put it on the right
			node.setRight(addElement(node.getRight(), element));

		return node; // node is unchanged, so return it
	}

	/**
	 * Returns true iff the element is contained in the tree
	 * 
	 * @param element
	 *            the element to search for
	 * @return true iff the element is contained in the tree
	 */
	public boolean containsElement(T element) {
		return containsElement(root, element);
	}

	// Private version of containsElement, which specifies a node to look in
	private boolean containsElement(TreeNode node, T element) {
		// If an empty subtree has been reached, the element is not in the tree.
		if (node == null)
			return false;

		int comparison = element.compareTo(node.getLabel());
		if (comparison == 0)
			// The desired element labels this node, so the tree does contain it
			return true;
		if (comparison < 0)
			// The desired element is "smaller" than node, so check the left
			// subtree
			return containsElement(node.getLeft(), element);
		// The only remaining possible location for the desired element is in
		// the right subtree
		return containsElement(node.getRight(), element);
	}

	/**
	 * Removes a specified element from the tree, or does nothing if the element
	 * is not in the tree to begin with.
	 * 
	 * @param element
	 *            the element to remove
	 */
	public void deleteElement(T element) {
		root = deleteElement(root, element);
	}

	// Private version of deleteElement, which specifies a node to delete from
	private TreeNode deleteElement(TreeNode node, T element) {
		// If the tree is empty, there is no element to delete, so nothing
		// changes
		if (node == null)
			return null;

		int comparison = element.compareTo(node.getLabel());
		if (comparison < 0)
			// this element is "smaller" than node, so delete it from the left
			// subtree
			node.setLeft(deleteElement(node.getLeft(), element));
		else if (comparison > 0)
			// this element is "larger" than node, so delete it from the right
			// subtree
			node.setRight(deleteElement(node.getRight(), element));
		else { // this node represents the element we want to delete

			// If the left subtree is empty, replace this node with its right
			// child, regardless of whether or not node.getRight() is null
			// itself
			if (node.getLeft() == null)
				return node.getRight();
			// If the right subtree is empty, replace this node with its left
			// child
			if (node.getRight() == null)
				return node.getLeft();

			// Both subtrees are nonempty, so swap the labels of node and the
			// largest-labeled node in its left subtree
			TreeNode nextLargest = node.getLeft().getLargest();
			node.setLabel(nextLargest.getLabel());
			nextLargest.setLabel(element);

			// Now, recursively delete element from the left subtree, where it
			// was swapped to
			node.setLeft(deleteElement(node.getLeft(), element));
		}

		// If this point is reached, the node object still belongs in its
		// location, so return it
		return node;
	}

	/**
	 * Print all elements in the tree to System.out using an inorder traversal
	 */
	public void printInOrder() {
		printInOrder(root);
	}

	// Private version of printInOrder, which specifies a node to print
	private void printInOrder(TreeNode node) {
		// If the tree is empty, nothing needs to be printed
		if (node != null) {
			// Inorder traversal follows this order: left, center, right
			printInOrder(node.getLeft());
			System.out.println(node.getLabel());
			printInOrder(node.getRight());
		}
	}

	/**
	 * Print all elements in the tree to System.out using a postorder traversal
	 */
	public void printPostOrder() {
		printPostOrder(root);
	}

	// Private version of printPostOrder, which specifies a node to print
	private void printPostOrder(TreeNode node) {
		// If the tree is empty, nothing needs to be printed
		if (node != null) {
			// Inorder traversal follows this order: left, right, center
			printPostOrder(node.getLeft());
			printPostOrder(node.getRight());
			System.out.println(node.getLabel());
		}
	}

}
