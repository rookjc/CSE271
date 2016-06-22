// Used by ExpressionEvaluator to represent a leaf in an expression tree,
// consisting only of an integer value.
public class ExpressionTreeLeaf implements BinaryExpressionTree {
	private int value;

	// Constructor for initializing the leaf with a certain value
	public ExpressionTreeLeaf(String symbol) {
		value = Integer.valueOf(symbol);
	}

	// Print out reverse Polish notation for the tree, which is just the value
	// and a space for a leaf node
	public void printRPN() {
		System.out.print(value + " ");
	}

	// Print out the infix notation for the tree, which is just the value for
	// a leaf node.
	public void printInfix() {
		System.out.print(value);
	}

	// Compute the value represented by this tree, given simply by value for a
	// leaf node
	public int evaluate() {
		return value;
	}

}
