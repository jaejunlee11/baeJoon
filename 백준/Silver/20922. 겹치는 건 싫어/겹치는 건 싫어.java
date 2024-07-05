import java.io.*;
import java.nio.Buffer;
import java.util.*;
/*
문제
1. 숫자가 존재
2. 숫자들 중 k번만 중복을 허용
3. 최장 수열 구하기

풀이
1. n, k 입력
2. arr[n]생성, count[100001]생성
3. arr채우기
4. for문 돌기, start = 0, end = 0
    4.1. count[arr[end]]++
    4.2. cont 값 > k 이면 end- start로 answer 갱신 => start가 arr[end]인 것을 찾아서 이동
5. answer 출력
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] count = new int[100001];
        int start = 0;
        int answer = 0;
        for(int i = 0; i < n; i++){
            count[arr[i]]++;
            if(count[arr[i]] > k){
                for(int j = start; j < i; j++){
                    if(arr[i]==arr[j]){
                        start = j+1;
                        count[arr[i]]--;
                        break;
                    }
                }
            }
            answer = Math.max(answer, i-start+1);
        }
        System.out.println(answer);
    }
}
/*
10 1
5 2 3 4 5 5 7 8 9 10
 */