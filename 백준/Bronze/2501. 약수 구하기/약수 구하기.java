import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int m = sc.nextInt();
		int count = 0;
		for(int i = 1;i<=N;i++) {
			if(N%i==0) count++;
			if(count==m) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}