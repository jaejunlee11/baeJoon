import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] st = br.readLine().toCharArray();
		int sum = 0;
		for (int i = 0 ; i<N; i++) {
			int tempNum = Character.getNumericValue(st[i]);
			sum += tempNum;
		}
		System.out.println(sum);
	}

}