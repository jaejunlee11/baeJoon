import java.io.*;
import java.util.*;
/*
문제
1. 연속 되는 날짜의 온도의 합이 가장 높은 것

풀이
1. n, m 입력
2. arr[n]생성 => 채우기
3. temp = 0
4. a= 0, b = m
5. for => a~b
    5.1. temp += arr[i]
6. for문 돌리기 => m~n
    6.1. temp += arr[i]
    6.2. temp -= arr[i-m]
    6.3. answer 갱신
7. answer 출력
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int temp = 0;
        for (int i = 0; i < m; i++) {
            temp += arr[i];
        }
        int answer = temp;
        for(int i = m; i < n; i++) {
            temp += arr[i];
            temp -= arr[i-m];
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }
}