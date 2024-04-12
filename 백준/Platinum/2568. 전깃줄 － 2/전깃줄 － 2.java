
/*
 * 문제
 * 1. 전깃줄이 겹치지않게 하기위해서 전깃줄을 제거 => 10만개
 * 2. 최소한의 전깃줄을 제거하기
 * 3. 전깃줄의 갯수와 전깃줄 출력
 * 
 * 풀이
 * 1. N입력 받기
 * 2. arr[N][2]생성
 * 3. arr채우기
 * 4. arr sort하기 => o1[0]-o2[0]
 * 5. arr[1]을 사용하여 증가하는 부분순열 구하기
 * 6. stack[N+1]생성 dpstack
 * 7. length=1으로 시작 ,dpstack[1].push(arr[0][1])
 * 8. for문 돌기 1~N
 *     8.1. 이분 탐색으로  0~length+1 사이에 dpstack.peek()값이 자신 보다 작은 가장 큰값 위치 찾기
 *     8.2. 해당 위치 값이 0인 경우 dpStack[pos-1]을 복사 => 복사 값에 push(현재 값)을 dpStack[pos]에 저장 + length++
 *     8.3. 0이 아닌 경우 dpStack[pos]를 복사 => 복사 값에 push(현재값)을 dpStack[pos+1]에 저장
 *     8.4. pos==0인 경우 dpStack[1].clear => dpstack[1].push(값)
 * 9.N-length 출력
 * 10. visited배열 생성
 * 11. dpStack[length]를 순회하면서 visited체크
 * 12. arr순회하면서 arr[N][1]이 visited가 아니면 출력
 */
import java.io.*;
import java.util.*;
public class Main {
    static int pos = 0;
    static int[] dpStack;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i = 0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
//        for(int i = 0;i<N;i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
        dpStack = new int[N+1];
        dp = new int[N+1];
        int length = 1;
        dpStack[1] = arr[0][1];
        dp[0]=1;
        for(int i = 1;i<N;i++) {
            pos = 0;
            recur(0,length+1,arr[i][1]);
            if(pos==0) {
                dpStack[1]=arr[i][1];
                dp[i] = 1;
            }else if(dpStack[pos]==0) {
                dpStack[pos]=arr[i][1];
                dp[i] = pos;
                length++;
            }else {
                dpStack[pos+1]=arr[i][1];
                dp[i]=pos+1;
            }
//            System.out.println(Arrays.toString(dpStack[length]));
        }
        StringBuilder sb = new StringBuilder();
        sb.append((N-length)+"\n");
        boolean visited[] = new boolean[500001];
//        System.out.println(Arrays.toString(dp));
        for(int i = N;i>=0;i--) {
        	if(dp[i]==length) {
//        		System.out.println(i);
        		visited[i] = true;
        		length--;
        		if(length==0)break;
        	}
        }
        for(int i = 0;i<N;i++) {
            if(!visited[i]) {
                sb.append(arr[i][0]+"\n");
            }
        }
        System.out.println(sb);
    }
    private static void recur(int start,int end, int my) {
        if(start>end) return;
        int mid = (start + end)/2;
        if(dpStack[mid]<my) {
            pos = Math.max(mid, pos);
            recur(mid+1,end,my);
        }else {
            recur(start,mid-1,my);
        }
    }
}