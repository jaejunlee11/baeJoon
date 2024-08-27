import java.io.*;
import java.util.*;
/*
문제
1. 사람이 존재 (키 순서 대로 숫자)
2. 자신 보다 큰 사람의 숫자를 저장
3. 순서 출력해주기

풀이
1. N 입력
2. arr[N] 생성
3. for문 돌리기
    3.0. pos = arr[i]-1
    3.1.while(answer[pos] != 0) => pos++
    3.2. answer[pos] = i+1
4. answer 출력
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[N];
        for(int i  = 0;i<N;i++){
            int pos = arr[i];
            int count = 0;
            for(int j = 0;j  < N;j++) {
                if(answer[j]==0) count++;
                if(count==pos+1) {
                    answer[j] = i+1;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<N;i++){
            sb.append(answer[i]+" ");
        }
        System.out.println(sb);
    }
}