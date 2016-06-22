// An interface used by ExpressionEvaluator to represent expression trees
public interface BinaryExpressionTree {
	// Print the reverse Polish notation for the tree
	public void printRPN();

	// Print the infix notation for the tree
	public void printInfix();

	// Compute the integer value of the tree
	public int evaluate();
}
