import java.io.*;
import java.util.*;
//0 가장 뒤
//1-4 N-해당 번호 인덱스에 저장
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] tempArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			int V = Integer.parseInt(st.nextToken());
			if(V == 0) {
				tempArr[i] = i+1;
			}else if(V > 0) {
				tempArr = arr.clone();
				for(int j = i-V;j<N-1;j++) {
					tempArr[j+1] =arr[j];
				}
				tempArr[i-V] = i+1;
			}
			arr = tempArr.clone();
		}
		for(int e : tempArr ) {
			System.out.print(e+" ");
		}
	}
}