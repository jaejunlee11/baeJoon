import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N ; i++) {
			for(int j = 0; j <N;j++) {
				if(j<N-i-1) {
					System.out.print(" ");
				}else{
					System.out.print("*");
				}
				
			}
			System.out.println();
		}
		for (int i = 1; i < N ; i++) {
			for(int j = 0; j <N;j++) {
				if(j<i) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
				
			}
			System.out.println();
		}
	}

}