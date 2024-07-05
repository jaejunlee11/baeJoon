import java.util.*;
import java.io.*;
/*
문제
1. 숫자 배열 2개가 존재 => 50
2. 두 배열의 곱의 합이 최대가 되도록 조절
3. 최대값 출력하기

풀이
1. n입력
2. arrA[n], arrB[n]생성
3. arr채우기
4. 순열 돌리기
5. answer 최대값 출력

순열 (depth)
1. depth == n
    1.1. for문 돌리기
        1.1.1. arrA[i] * arrB[i]의 합 구하기
        1.1.2. answer 갱신
    1.2. return
2. for문 돌리기 n
    2.1. visited 확인
    2.2. visited체크, picked에 넣기
    2.3. recur(depth+1)
    2.4. visted해제
시간초과 남
풀이
1. n입력
2. arrA[n], arrB[n]생성
3. arrB 정렬
4. arrA 역정렬
5. 두 배열 곱의 합 출력
 */
public class Main {
    private static int n;
    private static int[] arrA;
    private static int[] arrB;
    private static int[] picked;
    private static boolean[] visited;
    private static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arrA = new int[n];
        arrB = new int[n];
        picked = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        for(int i = 0; i < n; i++){
            answer += (arrA[i] *arrB[n-i-1]);
        }
        System.out.println(answer);
    }
}