import java.io.FileNotFoundException;

/**
 * The <code>TextAnalyzer</code> interface presents a uniform vocabulary for
 * performing rudimentary analysis of text files.
 * 
 * @author Gregory Gelfond
 * @version 1.0
 *
 */
public interface TextAnalyzer {

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
	public TextInfo analyzeFile(String fileName) throws FileNotFoundException;

}
