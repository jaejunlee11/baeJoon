import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<T+1;test_case++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			System.out.println("Case #"+test_case+": "+A+" + "+B+" = "+(A+B));
		}
	}

}