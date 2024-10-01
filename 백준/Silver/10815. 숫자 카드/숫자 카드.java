import java.util.*;
import java.io.*;
/*
문제
1. 상근이의 카드가 존재
2. 상근이가 해당 카드를 가졌는지 판단

풀이
1. n입력
2. arr[n] 생성 => 채우기 => 정렬
3. for문 돌리기
    3.1. 이분탐색으로 해당 값 있는지 확인
    3.2. builder에 담기
4. 출력
 */
public class Main {
    private static boolean now;
    private static int[] arr;
    private static int n;
    private static int t;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<m;i++){
            t = Integer.parseInt(st.nextToken());
            now = false;
            recur(0,n-1);
            if(now) sb.append(1+" ");
            else sb.append(0+ " ");
        }
        System.out.println(sb);
    }
    private static void recur(int start, int end) {
        if(start>end) return;
        int mid = start + (end - start)/2;
        if(arr[mid]>t) {
            recur(start,mid-1);
        } else if(arr[mid]==t){
            now = true;
        } else {
            recur(mid+1,end);
        }
    }
}