/*
문제
1. 피보나치 계산기 존재
2. p(n) = p(n-1) + p(n-2)
3. p(1) = 1, p(0) = 0
4. 각 1, 0 호출 갯수 구하기
5. N은 최대 40

풀이
1. arr[41][2] 생성
2. arr[0][0] = 1, arr[1][1] = 1
3. for문 돌리기
    3.1. arr[i][0] = arr[i-1][0] + arr[i-2][1], ..
4. for 문 돌면서 출력
 */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        long[][] arr = new long[41][2];
        arr[0][0] = 1;
        arr[1][1] = 1;
        for(int i=2;i<arr.length;i++) {
            arr[i][0] = arr[i-1][0] + arr[i-2][0];
            arr[i][1] = arr[i-1][1] + arr[i-2][1];
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<t;i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n][0]);
            sb.append(" ");
            sb.append(arr[n][1]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
