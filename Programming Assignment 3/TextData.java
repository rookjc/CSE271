/**
 * Stores elementary records of information about a file: fileName, word count,
 * character count, and line count.
 * 
 * @author Jayson Rook
 * @version 1.0
 */
public class TextData implements TextInfo {
	private String fileName;
	private long wordCount;
	private long characterCount;
	private long lineCount;
	
	public TextData (String sourceFileName, long words, long characters, long lines) {
		fileName = sourceFileName;
		wordCount = words;
		characterCount = characters;
		lineCount = lines;
	}
	
	/**
	 * Returns the name of the file this <code>TextData</code> object
	 * corresponds to.
	 * 
	 * @return the name of the file this <code>TextData</code> object
	 *         corresponds to.
	 */
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * Returns the number of words in a given file.
	 * 
	 * @return the number of words in a given file. A word is defined as a
	 *         consecutive sequence of alphanumeric characters.
	 */
	public long getWordCount() {
		return wordCount;
	}
	
	/**
	 * Returns the number of characters in a given file.
	 * 
	 * @return the number of characters in a given file.
	 */
	public long getCharacterCount() {
		return characterCount;
	}
	
	/**
	 * Returns the number of lines in a given file.
	 * 
	 * @return the number of lines in a given file. A line is defined by
	 *         occurrences of the newline character (<code>'\n'<code>)
	 */
	public long getLineCount() {
		return lineCount;
	}
	
}
