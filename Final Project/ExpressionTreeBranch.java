// Used by ExpressionEvaluator to represent a branch in an expression tree,
// consisting of a string operator label and left and right subtrees. Certain
// cases are ignored in tree traversal methods, under the assumption that a
// syntactically correct expression always yields branches with well-defined
// left and right subtrees.
public class ExpressionTreeBranch implements BinaryExpressionTree {
	private String operator;
	private BinaryExpressionTree left;
	private BinaryExpressionTree right;

	// Initialize this tree with an operator
	public ExpressionTreeBranch(String operator) {
		setOperator(operator);
	}

	public String getOperator() { // accessor for the operator
		return operator;
	}

	public void setOperator(String operator) { // mutator for the operator
		this.operator = operator;
	}

	public BinaryExpressionTree getLeft() { // accessor for the left subtree
		return left;
	}

	public void setLeft(BinaryExpressionTree left) { // mutator for the left
														// subtree
		this.left = left;
	}

	// accessor for the right subtree
	public BinaryExpressionTree getRight() {
		return right;
	}

	// mutator for the right subtree
	public void setRight(BinaryExpressionTree right) {
		this.right = right;
	}

	// Print out reverse Polish notation for the tree. For a branch node, this
	// is the left subtree, the right subtree, and the operator printed
	// consecutively.
	public void printRPN() {
		getLeft().printRPN();
		getRight().printRPN();
		System.out.print(operator + " ");
	}
	
	// Print out the infix notation for the tree
	public void printInfix() {
		BinaryExpressionTree lhs = getLeft();
		// If the left subtree is another branch, wrap it in parentheses
		if (lhs instanceof ExpressionTreeBranch) {
			System.out.print("(");
			lhs.printInfix();
			System.out.print(")");
		} else
			lhs.printInfix();
		
		// Print the operator between the two sides
		System.out.print(" " + getOperator() + " ");
		
		BinaryExpressionTree rhs = getRight();
		// If the right subtree is another branch, wrap it in parentheses
		if (rhs instanceof ExpressionTreeBranch) {
			System.out.print("(");
			rhs.printInfix();
			System.out.print(")");
		} else
			rhs.printInfix();
	}
	
	// Compute the value represented by this tree, by performing the labeled
	// operation on the left and right subtrees
	public int evaluate() {
		// Preemptively compute subtree values
		int lhs = getLeft().evaluate();
		int rhs = getRight().evaluate();
		
		// Perform the operation indicated by getOperator() and return the value
		switch (getOperator()) {
		case "+":
			return lhs + rhs;
		// Break statements omitted, since returns end the method entirely
		case "-":
			return lhs - rhs;
		case "*":
			return lhs * rhs;
		case "/":
			// Use integer division, since this class is designed for integer
			// expressions only.
			if (rhs == 0) // check domain
				throw new ArithmeticException("/ by zero: " + lhs + " / " + rhs + " is undefined.");
			return lhs / rhs;
		case "%":
			if (rhs == 0) // check domain
				throw new ArithmeticException("/ by zero: " + lhs + " % " + rhs + " is undefined.");
			return lhs % rhs;
		default:
			// This code should never be reached, since cases exist for all
			// symbols classified as operators.
			return 0;
		}
	}
	
}
