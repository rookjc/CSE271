import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A basic class which implements a single static method,
 * generateConcordanceFromFile(), which generates a map from words in a
 * specified file to the set of line numbers they appear on.
 * 
 * @author Jayson Rook
 * @version 1.0
 */
public class ElementaryConcordance {
	
	/**
	 * Reads a file specified by fileName, then generates a small concordance
	 * of information about the words in it. If the file cannot be opened, a
	 * blank concordance is returned.
	 * 
	 * @param fileName the name of the file to read
	 * @return a concordance that maps the words in the file to the set of line
	 * numbers on which they appear
	 */
	public static Map<String, Set<Integer>> generateConcordanceFromFile
	(String fileName) {
		try {
			// Set up a BufferedReader, potentially throwing an IOException
			BufferedReader reader = new BufferedReader(
					new FileReader(fileName));
			
			// Declare variables to be used in generating the concordance
			Map<String, Set<Integer>> result = new HashMap<>();
			String line;
			int lineNumber = 1;
			
			// Iterate over the lines in the file, using the BufferedReader
			while ((line = reader.readLine()) != null) {
				// Trim the line, so line.split() won't include empty strings
				// in its returned array in the future.
				String trimmedLine = line.trim();
				
				// Only proceed if there are words on the line (also to avoid
				// empty strings showing up in the concordance)
				if (trimmedLine.length() > 0) {
					String[] words = trimmedLine.split("\\s+");
					
					// Update the concordance with this complete array of words
					for (String word : words) {
						// If the word hasn't been seen before, add a key for
						// it initialized with an empty set
						if (!result.containsKey(word))
							result.put(word, new HashSet<>());
						
						// Add this lineNumber to the set for this word
						// (Set.add automatically avoids duplicates)
						result.get(word).add(lineNumber);
						// Since Map.get returns the pointer to the Set of
						// lineNumbers, result itself need not be updated
					}
					
				}
				// Increment lineNumber to be correct for the next iteration
				lineNumber++;
			}
			
			// Close the reader and return the generated map
			reader.close();
			return result;
			
		} catch (IOException e) {
			// If any IOException was thrown, return an empty concordance.
			return new HashMap<>();
		}
		
	}
	
}
