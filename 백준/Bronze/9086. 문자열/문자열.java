import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0;i<N;i++) {
			        String temp = br.readLine();
        System.out.print(temp.charAt(0)+""+temp.charAt(temp.length()-1));
        System.out.println();
		}

	}
}