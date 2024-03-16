import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		for(int i = 0;i<temp.length()/2;i++) {
			if(temp.charAt(i)!=temp.charAt(temp.length()-i-1)) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
	}
}