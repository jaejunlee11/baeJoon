import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double sum = 0;
		double sumPoint = 0;
		for(int i = 0;i<20;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			double point = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			if(grade.equals("A+")) {
				sum += point*4.5;
				sumPoint += point;
			}else if(grade.equals("A0")) {
				sum += point*4.0;
				sumPoint += point;
			}else if(grade.equals("B+")) {
				sum += point*3.5;
				sumPoint += point;
			}else if(grade.equals("B0")) {
				sum += point*3.0;
				sumPoint += point;
			}else if(grade.equals("C+")) {
				sum += point*2.5;
				sumPoint += point;
			}else if(grade.equals("C0")) {
				sum += point*2.0;
				sumPoint += point;
			}else if(grade.equals("D+")) {
				sum += point*1.5;
				sumPoint += point;
			}else if(grade.equals("D0")) {
				sum += point*1.0;
				sumPoint += point;
			}else if(grade.equals("F")) {
				sum += point*0;
				sumPoint += point;
			}
		}
		System.out.println(sum/sumPoint);
		
	}
}