import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		int max = -1;
		int x =0;
		int y =0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0;i<9;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j<9;j++) {
				int temp =Integer.parseInt(st.nextToken());
				if(max<temp) {
					x=i;
					y=j;
					max=temp;
				}
			}
		}
		System.out.println(max);
		System.out.println((x+1)+" "+(y+1));
	}
}