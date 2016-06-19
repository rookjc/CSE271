import java.util.List;
import java.util.Stack;

public class ExpressionEvaluator {
	static interface BinaryExpressionTree {
		public void printRPN();
		public void printInfix();
		public int evaluate();
	}
	
	static class ExpressionTreeBranch implements BinaryExpressionTree {
		private String operator;
		private BinaryExpressionTree left;
		private BinaryExpressionTree right;
		
		public ExpressionTreeBranch(String operator) {
			this.operator = operator;
		}
		
		public BinaryExpressionTree getLeft() {
			return left;
		}
		
		public void setLeft(BinaryExpressionTree left) {
			this.left = left;
		}
		
		public BinaryExpressionTree getRight() {
			return right;
		}
		
		public void setRight(BinaryExpressionTree right) {
			this.right = right;
		}
		
		public void printRPN() {
			getLeft().printRPN();
			getRight().printRPN();
			System.out.print(operator + " ");
		}

		public void printInfix() {
			System.out.print("(");
			getLeft().printInfix();
			System.out.print(" " + operator + " ");
			getRight().printInfix();
			System.out.print(")");
		}

		public int evaluate() {
			int lhs = getLeft().evaluate();
			int rhs = getRight().evaluate();
			switch (operator) {
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
				return lhs / rhs;
			case "%":
				return lhs % rhs;
			default:
				// This code should never be reached, since cases exist for all
				// symbols classified as operators.
				return 0;
			}
		}
		
	}
	
	static class ExpressionTreeLeaf implements BinaryExpressionTree {
		private int value;
		
		public ExpressionTreeLeaf (String symbol) {
			value = Integer.valueOf(symbol);
		}

		public void printRPN() {
			System.out.print(value + " ");
		}

		public void printInfix() {
			System.out.print(value);
		}

		public int evaluate() {
			return value;
		}
		
	}
	
	
	
	public static void process(List<String> expr) {
		BinaryExpressionTree tree = generateTree(expr);
		tree.printRPN();
		System.out.println();
		tree.printInfix();
		System.out.println();
		System.out.println(tree.evaluate());
	}
	
	private static BinaryExpressionTree generateTree(List<String> expr) {
		Stack<String> s = new Stack<>();
		for (String symbol : expr)
			s.push(symbol);
		return generateTree(s);
	}
	
	private static BinaryExpressionTree generateTree(Stack<String> s) {
		String symbol = s.pop();
		if (isOperator(symbol)) {
			ExpressionTreeBranch tree = new ExpressionTreeBranch(symbol);
			tree.setRight(generateTree(s));
			tree.setLeft(generateTree(s));
			return tree;
		}
		return new ExpressionTreeLeaf(symbol);
	}
	
	/**
	 * Determine whether a string represents one of five operators:
	 * +, -, *, /, or %.
	 * 
	 * @param symbol the string to check
	 * @return true iff the string represents one of the operators
	 */
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
