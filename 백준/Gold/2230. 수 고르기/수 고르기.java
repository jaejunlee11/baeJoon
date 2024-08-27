import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
/*
문제
1. N,M 존재
2. N개의 숫자들 중 차이가 M 이상인 것 첫기
3. 그 중 가장 작은 차이를 갖는것

풀이
1. N,M입력
2. arr[N] 생성 => 채우기 => 정렬
3. for문 돌리기 => N
    3.1. arr[i] 이분 탐색으로 M 이상인 것 찾기
    3.2. answer가 M인 경우 탈출
4. answer 출력

이분 탐색(start, end, now)
1. mid = (start + end) / 2
2. if(now-arr[mid] >= M ) answer 갱신 recur(start, mid-1,now)
3. recur(mid+1, end, now)
 */
public class Main {
    static int M;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            recur(0, N - 1, arr[i]);
            if (answer == M) break;
        }
        System.out.println(answer);
    }
    private static void recur(int start, int end ,int now) {
        if(start>end) return;
        int mid = (start + end) / 2;
        if(Math.abs(arr[mid]-now)>=M){
            answer = Math.min(answer,Math.abs(arr[mid]-now));
            if(arr[mid]-now>0){
                recur(start,mid-1,now);
            } else {
                recur(mid+1,end,now);
            }
        } else {
            recur(start,mid-1,now);
        }
    }
}