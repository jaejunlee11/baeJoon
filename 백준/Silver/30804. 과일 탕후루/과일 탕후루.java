/*
문제
1. 과일 탕후루 존재 => 배열 [n]
2. 과일 양쪽 제거 => 2개의 과일만 있는 것
3. 가장 긴 배열 찾기

풀이
1. 배열 생성 arr[n]
2. 시작점 a, 끝점 b
3. 최대 값 ans, 측정용 map
4. for문 돌리기 0 ~ n
    4.1. for문 돌리기 i+1 ~ n
        4.1.1. map에 넣기
        4.1.2. map 순회 => 0이 아닌게 3개면 break, 아니면 ans 갱신
    4.2. map 빼기
5. ans 출력
 */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer,Integer> map = new HashMap<>();
        int b = 0;
        int ans = 0;
        for (int a = 0; a < n; a++) {
            while (b<n) {
                map.put(arr[b], map.getOrDefault(arr[b], 0) + 1);
                int count = 0;
                for(int k = 1; k <= 9; k++) {
                    if(map.getOrDefault(k,0) > 0) count++;                }
                b++;
                if(count>2) {
                    break;
                };
                ans = Math.max(ans,b-a
                );
            }
            map.put(arr[a], map.get(arr[a]) - 1);
        }
        System.out.println(ans);
    }
}
