import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		User[] arr = new User[N];
		for(int i= 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new User(Integer.parseInt(st.nextToken()),st.nextToken());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i =0 ;i<N;i++) {
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb);
	}
	public static class User implements Comparable<User>{
		public int age;
		public String name;
		public User(int age, String name) {
			this.age = age;
			this.name = name;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return age+" "+name;
		}
		
		@Override
		public int compareTo(User o) {
			// TODO Auto-generated method stub
			return this.age-o.age;
		}
	}
}