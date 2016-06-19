import java.util.List;
import java.util.Stack;

/**
 * A simple class defining the static method evaluate, for computing the values
 * of integer expressions entered in Reverse Polish notation, along with helper
 * methods.
 * 
 * @author Jayson Rook
 * @version 1.0
 */
public class ExpressionEvaluator1 {
	
	/**
	 * Computes an integer value from a list of strings, representing operators
	 * and operands of Reverse Polish notation assumed to be syntactically
	 * correct.
	 * 
	 * @param expr the List<String> representing the expression
	 * @return the computed integer value
	 */
	public static int evaluate(List<String> expr) {
		Stack<Integer> s = new Stack<>();
		// Iterate over symbols in forward order.
		for (String symbol : expr) {
			if (isOperator(symbol)) {
				// The current symbol is an operator, so pop the two most
				// recent numbers (assuming for now there will always be at
				// least two) off the stack, perform the operation, and push
				// the result back onto the stack.
				int rhs = s.pop();
				int lhs = s.pop();
				s.push(applyOperation(lhs, rhs, symbol));
			} else {
				// Symbol is a number, so simply push it onto the stack.
				s.push(toInteger(symbol));
			}
		}
		// At the end of the expression, the expressions's value should be the
		// only number left on the stack, so pop and return it.
		return s.pop();
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
	
	/**
	 * Convert a String symbol to the integer it represents. For now, it is
	 * assumed a represented integer will always exist.
	 * 
	 * @param symbol the String to convert
	 * @return the integer value
	 */
	private static int toInteger(String symbol) {
		// Since syntactic correctness is assumed, the valueOf method is
		// assumed to work properly and not throw a NumberFormatException.
		return Integer.valueOf(symbol);
	}
	
	/**
	 * Takes two integers, and applies the binary operation specified by the
	 * String symbol. Returns the integer result.
	 * 
	 * @param lhs the first integer
	 * @param rhs the second integer
	 * @param operator the String specifying the operation
	 * @return the result of the operation
	 */
	private static int applyOperation(int lhs, int rhs, String operator) {
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
