import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * A basic class implementing the TextAnalyzer interface, which contains a
 * single non-static method to analyze a few statistics about a file.
 * 
 * @author Jayson Rook
 * @version 1.0
 */
public class TextExaminer implements TextAnalyzer {
	
	// Empty constructor, needed since the analyzeFile method is non-static
	public TextExaminer() {};
	
	/**
	 * Returns a <code>TextInfo</code> capturing the number of words,
	 * characters, and lines in the specified file.
	 * 
	 * @param fileName
	 *            the name of the file
	 * @return a <code>TextInfo</code> capturing the number of words,
	 *         characters, and lines in the specified file
	 * @throws FileNotFoundException
	 *             if the file cannot be opened for reading
	 */
	public TextInfo analyzeFile(String fileName) throws FileNotFoundException {
		try {
			// Set up a BufferedReader, potentially throwing an IOException
			BufferedReader reader = new BufferedReader(
					new FileReader(fileName));
			
			// Declare variables to be used in processing the file
			int wordCount = 0;
			int charCount = 0;
			int lineCount = 0;
			String line;
			
			// Iterate over the lines of the file, using the BufferedReader
			while ((line = reader.readLine()) != null) {
				// Trim the line, so line.split() won't include empty strings
				// in its returned array in the future
				String trimmedLine = line.trim();
				
				// If the line contains words, increment wordCount accordingly
				if (trimmedLine.length() > 0)
					wordCount += trimmedLine.split("\\s+").length;
				
				// Increment charCount by the length of the line + 1, to
				// account for a newline character the BufferedReader discards
				charCount += line.length() + 1;
				// Increment lineCount with every iteration of the loop also
				lineCount++;
			}
			
			// Close the reader, and create and return a TextData object
			reader.close();
			return new TextData(fileName, wordCount, charCount, lineCount);
			
		} catch (IOException e) {
			// Regardless of the original IOException type,
			// throw a FileNotFoundException that the file cannot be read
			throw new FileNotFoundException("File '" + fileName + "' cannot be"
					+ " opened for reading.");
		}
	}

}
