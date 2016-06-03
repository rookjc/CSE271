/**
 * A simple class defining a main method to compute and output the sum of all
 * the multiples of 3 or 5 below 1000, along with a helper method for it
 * 
 * @author Jayson Rook
 * @version 1.0
 */
public class Puzzle1a {
	/**
	 * Utilizing the sumInts() method, compute the sum of multiples of 3 or 5
	 * below 1000.
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// The sum of all the multiples of 3 below 1000 is given by
		int threeSum = 3 * sumInts(999 / 3);
		// because 999 / 3 (integer division) gives the number of multiples n,
		// sumInts(999 / 3) gives the sum of n multiples of 1,
		// and 3 * sumInts(999 / 3) scales the result to multiples of 3 instead
		
		// Likewise, the sum of all the multiples of 5 below 1000 is given by
		int fiveSum = 5 * sumInts(999 / 5);
		
		// Likewise, the sum of all numbers divisible by both 3 and 5
		// (or divisible by lcm(3,5) = 15) is given by
		int fifteenSum = 15 * sumInts(999 / 15);
		
		// Since fifteenSum is accounted for twice (once in threeSum and once
		// in fiveSum), subtract it from their sum to get the result
		int result = threeSum + fiveSum - fifteenSum;
		System.out.println(result);
	}
	 
	/** A formula for adding together integers from 1 to n, inclusive
	 * 
	 * @param n the highest number to add
	 * @return the sum of the integers in [1,n]
	 */
	public static int sumInts(int n) {
		return n * (n + 1) / 2;
	}
	
}
