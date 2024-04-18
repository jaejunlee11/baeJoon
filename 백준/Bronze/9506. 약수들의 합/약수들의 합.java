/*
 * 문제
 * 1. N입력
 * 2. K입력
 * 3. N을 K개로 만들 => 0도 포함됨
 * 
 * 풀이
 * 1.
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==-1) break;
			int temp =0;
			List<Integer> list = new ArrayList();
			for(int i =1;i<N;i++) {
				if(N%i==0) {
					temp+=i;
					list.add(i);
				}
			}
			if(temp==N) {
				sb.append(N+" = ");
				for(int i = 0;i<list.size()-1;i++) {
					sb.append(list.get(i)+" + ");
				}
				sb.append(list.get(list.size()-1)+"\n");
			}else {
				sb.append(N+" is NOT perfect.\n");
			}
		}
		System.out.println(sb);
		
		
	}
}