import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String tempLine = br.readLine();
			if(tempLine == null) {
				break;
			}
			System.out.println(tempLine);
		}
	}

}