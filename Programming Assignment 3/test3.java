import java.io.FileNotFoundException;

public class test3 {

	public static void main(String[] args) throws FileNotFoundException {
		TextAnalyzer t = new TextExaminer();
		System.out.println(t.analyzeFile("testfile.txt"));
		System.out.println("asdf");
		System.out.println(ElementaryConcordance.generateConcordanceFromFile("testfile.txt"));
	}

}
