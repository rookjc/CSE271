import java.util.List;
import java.util.Stack;

public class ExpressionEvaluator {
	interface BinaryExpressionTree {
		public void printRPN();
		public void printInfix();
		public int evaluate();
	}
	
	class ExpressionTreeBranch implements BinaryExpressionTree {
		String operator;
		BinaryExpressionTree left;
		BinaryExpressionTree right;
		
		public ExpressionTreeBranch(String operator) {
			this.operator = operator;
		}
		public void printRPN() {
			// TODO Auto-generated method stub
			
		}

		public void printInfix() {
			// TODO Auto-generated method stub
			
		}

		public int evaluate() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	class ExpressionTreeLeaf implements BinaryExpressionTree {

		@Override
		public void printRPN() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void printInfix() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int evaluate() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	
	
	public static void process(List<String> expr) {
		Stack<String> s = new Stack<>();
		for (String symbol : expr)
			s.push(symbol);
		
	}
}
