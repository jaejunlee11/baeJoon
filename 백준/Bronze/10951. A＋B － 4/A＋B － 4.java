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
			StringTokenizer st = new StringTokenizer(tempLine);
//			if(st.hasMoreTokens()==false) {
//				break;
//			}
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			System.out.println(A+B);
		}
	}

}