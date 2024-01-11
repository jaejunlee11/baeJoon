import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max =  -1000000;
		int min =  1000000;
		for (int i =0;i<N;i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp>max) {
				max = temp;
			}
			if(temp<min) {
				min = temp;
			}
		}
		System.out.println(min+" "+max);
	}

}