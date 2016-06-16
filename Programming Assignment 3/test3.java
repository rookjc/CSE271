import java.io.IOException;

public class test3 {

	public static void main(String[] args) throws IOException {
		TextAnalyzer t = new TextExaminer();
		TextInfo i = t.analyzeFile("testfile.txt");
		System.out.println(i.getWordCount());
		System.out.println(i.getCharacterCount());
		System.out.println(CharCounter.countChars("testfile.txt"));
		System.out.println(i.getLineCount());
		System.out.println(i.getFileName());
		System.out.println("asdf");
		System.out.println(ElementaryConcordance.generateConcordanceFromFile("testfile.txt"));
	}

}
