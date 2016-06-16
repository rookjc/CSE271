import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CharCounter {
	public static int countChars(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader(fileName));
		
		int count = 0;
		
		while (reader.read() != -1)
			count++;
		
		reader.close();
		return count;
	}
}
