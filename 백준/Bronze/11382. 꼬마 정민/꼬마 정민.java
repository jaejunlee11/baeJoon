import java.io.*;
import java.util.*;

public class Main {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	long A = Long.parseLong(st.nextToken());
	long B = Long.parseLong(st.nextToken());
	long C = Long.parseLong(st.nextToken());
	System.out.println(A+B+C);
}
}