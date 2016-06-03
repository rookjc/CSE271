import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A simple class for representing an interval, a sequence of consecutive
 * integers from a lower bound (inclusive) to an upper bound (exclusive)
 * 
 * @author Jayson Rook
 * @version 1.0
 */

public class Interval {
	private int lowerBound;
	private int upperBound;
	
	/**
	 * Constructor for an Interval, from bounds
	 * 
	 * @param m the lower, inclusive bound
	 * @param n the upper, exclusive bound
	 */
	public Interval(int m, int n) {
		lowerBound = m;
		upperBound = n;
	}
	 
	/**
	 * Accessor method for the interval's upper bound
	 * 
	 * @return the upper bound
	 */
	public int getUpperBound() {
		return upperBound;
	}
	 
	/**
	 * Accessor method for the interval's lower bound
	 * 
	 * @return the lower bound
	 */
	public int getLowerBound() {
		return lowerBound;
	}
	
	/**
	 * Create a string representation of the interval, showing both the
	 * interval notation and the enumeration of all elements
	 * 
	 * @return the string representation
	 */
	public String toString() {
		// start with the interval notation
		String result = "[" + lowerBound + ", " + upperBound + ") = [";
		// sequentially add elements into the enumeration
		for (int i = lowerBound; i < upperBound; i++) {
			result = result + i;
			if (i < upperBound - 1) // add a comma if more elements follow
				result += ", ";
		}
		// add the end bracket
		result += "]";
		return result;
	}
	
	/**
	 * Get the i-th (zero-indexed) element in the interval
	 * 
	 * @param i the integer to index the sequence with
	 * @return the indexed element
	 * @throws NoSuchElementException
	 */
	public int get(int i) throws NoSuchElementException {
		if (i < 0 || i >= count())
			throw new NoSuchElementException();
		return lowerBound + i;
	}
	
	/**
	 * Multiply all the elements of the interval together. An empty interval
	 * returns a product of 1.
	 * 
	 * @return the product of all the elements
	 */
	public int product() {
		int p = 1;
		for (int i = lowerBound; i < upperBound; i++)
			p *= i;
		return p;
	}
	
	/**
	 * Add all the elements of the interval together. An empty interval
	 * returns a sum of 0.
	 * 
	 * @return the sum of all the elements
	 */
	public int sum() {
		// Use an explicit formula to compute the sum, utilizing count()
		return count() * (lowerBound + upperBound - 1) / 2;
	}
	
	/**
	 * Create a List<Integer> with all the elements of this interval that
	 * satisfy a specified condition
	 * 
	 * @param p an IntegerRelation whose satisfies() method determines whether
	 * an integer should be included in the returned list
	 * @return the list of elements in the interval satisfying p
	 */
	public List<Integer> findAll(IntegerRelation p) {
		List<Integer> result = new ArrayList<>();
		for (int i = lowerBound; i < upperBound; i++) {
			if (p.satisfies(i))
				result.add(i);
		}
		return result;
	}
	
	/**
	 * Create a List<Integer> with the images of the elements in this interval,
	 * each transformed by a specified transformation
	 * 
	 * @param f an IntegerTransformation whose transform() method will be
	 * applied to every element in the interval
	 * @return the list of elements transformed by f
	 */
	public List<Integer> transformAll(IntegerTransformation f) {
		List<Integer> result = new ArrayList<>();
		for (int i = lowerBound; i < upperBound; i++)
			result.add(f.transform(i));
		return result;
	}
	
	/**
	 * Check if the interval contains no elements
	 * 
	 * @return true iff the interval contains no elements
	 */
	private boolean isEmpty() {
		return lowerBound >= upperBound;
	}
	
	/**
	 * Find the number of elements contained in the interval
	 * 
	 * @return the number of elements
	 */
	private int count() {
		if (isEmpty()) // special case when the interval is empty
			return 0;
		// otherwise the number of elements is given by the bounds' difference
		return upperBound - lowerBound;
	}
	
}

