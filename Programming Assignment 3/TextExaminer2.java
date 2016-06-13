// the start of an alternative algorithm, probably not used


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
@SuppressWarnings(value = {"unused"})
public class TextExaminer2 implements TextAnalyzer {

	public TextExaminer2() {};

	public TextInfo analyzeFile(String fileName) throws FileNotFoundException {
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader(fileName));
			
			TextState state = TextState.START;
			int charCount = 0;
			int wordCount = 0;
			int lineCount = 1;
			int readCharacter;
			
			while ((readCharacter = reader.read()) != -1) {
				char character = (char)readCharacter;
				charCount++;
				switch (state) {
				case START:
					if (isWordCharacter(character)) {
						state = TextState.WORD;
						wordCount++;
					} else {
						state = TextState.NONWORD;
						if (isNewLineCharacter(character))
							lineCount++;
					}
				case WORD:
					break;
				case NONWORD:
					break;
				}
			}
			
			reader.close();
			return new TextData(fileName, 0, 0, 0);
		} catch (IOException e) {
			// Regardless of the original exception type,
			// throw a FileNotFoundException that the file cannot be read
			throw new FileNotFoundException("File '" + fileName + "' cannot be"
					+ " opened for reading.");
		}
	}
	
	private static boolean isWordCharacter(char c) {
		return !Character.isWhitespace(c);
	}
	
	private static boolean isNewLineCharacter(char c) {
		return c == System.lineSeparator().charAt(0);
	}

}
