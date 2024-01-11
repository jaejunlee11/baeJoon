import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N ; i++) {
			for(int j = 0; j <(2*N);j++) {
				if(j<i+1) {
					System.out.print("*");
				}else if(j<N+(N-i-1)){
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
				
			}
			System.out.println();
		}
		for (int i = 0; i < N-1 ; i++) {
			for(int j = 0; j <(2*N);j++) {
				if(j<(N-i-1)) {
					System.out.print("*");
				}else if(j<N+i+1){
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
				
			}
			System.out.println();
		}
	}

}