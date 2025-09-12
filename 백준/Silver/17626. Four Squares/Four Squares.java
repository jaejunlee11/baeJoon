/*
문제
1. 제곱의 최소 갯수 합 만들기

풀이
1. arr[n+1]
3. for 문 돌리기 0 ~ n+1
    3.1. for문 돌리기 ( i + j * j<=n+1)
        3.1.1. arr[i] + 1
4. arr[n] 출력
 */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        java.util.Arrays.fill(arr, Integer.MAX_VALUE - 1);
        arr[0] = 0;
        for (int i = 0; i <= N; i++) {
            for(int j = 0 ; j*j + i <= N ; j++) {
                arr[i + j*j] = Math.min(arr[i] + 1, arr[i + j*j]);
            }
        }
        System.out.println(arr[N]);
    }
}
