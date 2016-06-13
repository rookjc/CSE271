/**
 * Objects which implement the <code>TextInfo</code> interface correspond to
 * elementary records of information about a text file.
 * 
 * @author Gregory Gelfond
 * @version 1.0
 */
public interface TextInfo {

	/**
	 * Returns the name of the file the given <code>TextInfo</code> object
	 * corresponds to.
	 * 
	 * @return the name of the file the given <code>TextInfo</code> object
	 *         corresponds to.
	 */
	public String getFileName();

	/**
	 * Returns the number of words in a given file.
	 * 
	 * @return the number of words in a given file. A word is defined as a
	 *         consecutive sequence of alphanumeric characters.
	 */
	public long getWordCount();

	/**
	 * Returns the number of characters in a given file.
	 * 
	 * @return the number of characters in a given file.
	 */
	public long getCharacterCount();

	/**
	 * Returns the number of lines in a given file.
	 * 
	 * @return the number of lines in a given file. A line is defined by
	 *         occurrences of the newline character (<code>'\n'<code>)
	 */
	public long getLineCount();

}
