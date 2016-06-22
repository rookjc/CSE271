import java.util.List;
import java.util.Stack;

/**
 * A class implementing the static method process, which converts a reverse
 * Polish notation expression into a tree to demonstrate traversal methods.
 * 
 * @author Jayson Rook
 * @version 1.0
 */
public class ExpressionEvaluator {

	/**
	 * Takes a list of strings representing a syntactically correct integer
	 * expression in reverse Polish notation, and generates a tree
	 * representation of it. This tree is then used to print out the original
	 * reverse Polish notation, the infix notation, and the computed value of
	 * the expression.
	 * 
	 * @param expr
	 *            the expression in reverse Polish notations
	 */
	public static void process(List<String> expr) {
		BinaryExpressionTree tree = generateTree(expr);

		printRPN(tree);

		printInfix(tree);

		printValue(tree);
	}

	// Helper method for generating the tree from the list. Converts the list
	// to a stack to utilize another method for generation.
	private static BinaryExpressionTree generateTree(List<String> expr) {
		Stack<String> s = new Stack<>();
		for (String symbol : expr)
			s.push(symbol);
		return generateTree(s);
	}

	// Helper method for generating the tree from a stack.
	private static BinaryExpressionTree generateTree(Stack<String> s) {
		String symbol = s.pop();
		if (isOperator(symbol)) {
			// Create a branch for the operator, calling this method recursively
			// to obtain the left and right subtrees.
			ExpressionTreeBranch tree = new ExpressionTreeBranch(symbol);
			tree.setRight(generateTree(s));
			tree.setLeft(generateTree(s));
			return tree;
		}
		// Otherwise, create a leaf node, which has only an integer value and
		// never any subtrees.
		return new ExpressionTreeLeaf(symbol);
	}

	// Helper method for printing reverse Polish notation from the tree
	private static void printRPN(BinaryExpressionTree tree) {
		tree.printRPN();
		System.out.println();
	}

	// Helper method for printing infix notation from the tree
	private static void printInfix(BinaryExpressionTree tree) {
		tree.printInfix();
		System.out.println();
	}

	// Helper method for computing and printing the value of the tree
	private static void printValue(BinaryExpressionTree tree) {
		System.out.println(tree.evaluate());
	}

	// Determine whether a string represents one of five operators: +, -, *, /,
	// or %.
	private static boolean isOperator(String symbol) {
		switch (symbol) {
		case "+":
		case "-":
		case "*":
		case "/":
		case "%":
			return true;
		// Break statement omitted, since return ends the method entirely
		default:
			return false;
		}
	}

}
