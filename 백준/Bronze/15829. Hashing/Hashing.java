import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        String temp = br.readLine();
        long answer = 0;
        for(int i = 0;i<N;i++){
            long an = 1;
            for(int j = 0;j<i;j++){
                an = (an * 31)% 1234567891;
            }
            answer += (an*((temp.charAt(i)-'a')+1)% 1234567891);
            answer = answer % 1234567891;
        }
        System.out.println(answer);
    }
}