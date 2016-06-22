import java.util.ArrayList;
import java.util.List;

public class FinalTester {

	public static void main(String[] args) {
		//List<String> l = L("10%");
		List<String> l = L("8567++*");
		ExpressionEvaluator.process(l);
		System.out.println(ExpressionEvaluator1.evaluate(l));
		
		BinarySearchTree<String> t = new BinarySearchTree<>();
		t.addElement("aardvark");
		t.addElement("dolphin");
		t.addElement("hound");
		t.addElement("snail");
		t.addElement("cat");
		t.addElement("giraffe");
		t.addElement("giraffe");
		t.deleteElement("giraffe");
		t.printInOrder();
		System.out.println(t.containsElement("giraffe"));
	}
	
	public static List<String> L(String s) {
		List<String> res = new ArrayList<>();
		for (char c : s.toCharArray()) {
			res.add(c + "");
		}
		return res;
	}

}
