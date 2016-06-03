
public class Unused {
	private static boolean isInteger(String symbol) {
		try {
			// Try to parse an integer from the symbol.
			// The actual value isn't needed.
			Integer.valueOf(symbol);
		} catch (NumberFormatException e) {
			// The valueOf method threw an exception,
			// so the symbol is not an integer.
			return false;
		}
		
		// No early return (thus no NumberFormatException thrown),
		// so symbol does represent an integer.
		return true;
	}
	
	private static int toInteger(String symbol) {
		try {
			return Integer.valueOf(symbol);
		} catch (NumberFormatException e) {
			// shouldn't happen if string is syntactically correct
			System.err.println("Unknown symbol '" + symbol
					+ "', treated as zero.");
			return 0;
		}
	}
}
