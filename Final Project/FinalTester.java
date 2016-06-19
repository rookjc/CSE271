import java.util.ArrayList;
import java.util.List;

public class FinalTester {

	public static void main(String[] args) {
		List<String> l = L("34+5-917**+");
		ExpressionEvaluator.process(l);
		System.out.println(ExpressionEvaluator1.evaluate(l));
	}
	
	public static List<String> L(String s) {
		List<String> res = new ArrayList<>();
		for (char c : s.toCharArray()) {
			res.add(c + "");
		}
		return res;
	}

}
