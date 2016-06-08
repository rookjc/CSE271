import java.io.FileNotFoundException;

public interface TextAnalyzer {
	public TextInfo analyzeFile(String fileName) throws FileNotFoundException;
}
