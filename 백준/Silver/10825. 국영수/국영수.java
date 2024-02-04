/*
 * 
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String[][] arr = new String[N][4];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
			arr[i][2] = st.nextToken();
			arr[i][3] = st.nextToken();
		}
		Arrays.sort(arr,(o1,o2) -> {
			if(Integer.parseInt(o1[1])==Integer.parseInt(o2[1])) {
				if(Integer.parseInt(o1[2])==Integer.parseInt(o2[2])) {
					if(Integer.parseInt(o1[3])==Integer.parseInt(o2[3])) {
						return o1[0].compareTo(o2[0]);
					}
					return Integer.parseInt(o2[3])-Integer.parseInt(o1[3]);
				}
				return Integer.parseInt(o1[2])-Integer.parseInt(o2[2]);
			}
			return Integer.parseInt(o2[1])-Integer.parseInt(o1[1]);
		});
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<N;i++) {
			sb.append(arr[i][0]+"\n");
		}
		System.out.println(sb);
	}
}