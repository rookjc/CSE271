/**
 * A simple class defining an evenFibSum method to compute the sum of all
 * even-valued Fibonacci terms below four million, along with a helper method,
 * and a main method to run the computation and output the result.
 * 
 * @author Jayson Rook
 * @version 1.0
 */
public class Puzzle1b {
	
	/**
	 * Runs the evenFibSum computation for values below four million, starting
	 * with one and two. Then outputs the result.
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.out.println(evenFibSum(1, 2, 4000000));
	}
	
	/**
	 * An algorithm for computing the desired sum of even-valued Fibonacci
	 * terms in the sequence starting with f1 and f2. The summation ends once
	 * a term reaches or exceeds upperBound. It it not necessarily very
	 * efficient, but runs quickly enough for the given problem.
	 * 
	 * @param f1 the first number in the Fibonacci sequence to use
	 * @param f2 the second number in the Fibonacci sequence to use
	 * @param upperBound the algorithm stops adding when a value reaches this
	 * @return the computed sum
	 */
	public static int evenFibSum(int f1, int f2, int upperBound) {
		int fPrevious = f1;
		int fCurrent = f2;
		int sum = 0;
		while (fCurrent < upperBound) {
			// If the current term is even, add it to the ongoing sum.
			if (fCurrent % 2 == 0)
				sum += fCurrent;
			
			// Find the next term, then update fPrevious and fCurrent.
			int fNext = nextFib(fPrevious, fCurrent);
			fPrevious = fCurrent;
			fCurrent = fNext;
		}
		return sum;
	}
	
	/**
	 * Compute the next Fibonacci number, given the two before it.
	 * 
	 * @param n1 the term before the previous term
	 * @param n2 the previous term
	 * @return the newly computed term
	 */
	public static int nextFib(int n1, int n2) {
		return n1 + n2;
	}

}
