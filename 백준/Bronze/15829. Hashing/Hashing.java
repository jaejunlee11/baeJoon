import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String temp = br.readLine();
        int answer = 0;
        for(int i = 0;i<N;i++){
            answer += (int)Math.pow(31, i)*((temp.charAt(i)-'a')+1);
            answer = answer % 1234567891;
        }
        System.out.println(answer);
    }
}