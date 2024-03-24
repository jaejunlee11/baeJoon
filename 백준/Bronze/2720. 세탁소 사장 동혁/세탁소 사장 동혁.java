import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int T = Integer.parseInt(br.readLine());
		 for(int t =0 ;t<T;t++) {
			 int n = Integer.parseInt(br.readLine());
			 int c = (int)n/25;
			 System.out.print(c+" ");
			 n = n - c * 25;
			 c = (int) n/10;
			 System.out.print(c+" ");
			 n = n - c * 10;
			 c = (int) n/5;
			 System.out.print(c+" ");
			 n = n - c * 5;
			 System.out.println(n+" ");
		 }
	}
}