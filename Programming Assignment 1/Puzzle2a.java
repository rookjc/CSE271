/**
 * A simple class to defining a main method to compute and output the smallest
 * positive number that is evenly divisible by all of the numbers from 1 to 20.
 * 
 * @author jrook_000
 * @version 1.0
 */
public class Puzzle2a {
	/**
	 * This implementation finds the smallest integer evenly divisible by 1-20
	 * by procedurally generating its prime factorization. It starts with an
	 * array of integers 1-20 and cancels out common factors, as it multiplies
	 * them on to the resulting product.
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// Generate a 'factors' array initially holding the integers 1-20
		int[] factors = new int[20];
		for (int i = 0; i < 20; i++)
			factors[i] = i + 1;
		
		int product = 1;
		
		// multiply the factors together in increasing order
		for (int i = 0; i < 20; i++) {
			product *= factors[i];
			// if any later factor is divisible by this one,
			// divide this factor out of it
			for (int j = i + 1; j < 20; j++) {
				if (factors[j] % factors[i] == 0)
					factors[j] /= factors[i];
			}
		}
		
		// The product of the reduced factors gives the result
		System.out.println(product);
	}
	
}
