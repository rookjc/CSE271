import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tester {

	public static void main(String[] args) {
		//List<String> l = L("34+5-917**+");
		List<String> l = L("251***");
		l.add(0, "-1");
		System.out.println(l);
		System.out.println(ExpressionEvaluator.evaluate(l));
	}
	
	public static List<String> L(String s) {
		List<String> res = new ArrayList<>();
		for (char c : s.toCharArray()) {
			res.add(c + "");
		}
		return res;
	}

}
