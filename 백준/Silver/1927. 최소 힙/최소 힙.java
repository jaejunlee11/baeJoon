/*
문제
1. 배열이 존재
2. 배열에 숫자 넣기 or 꺼내기
3. 꺼낼 숫자가 없으면 0 출력

풀이
1. 우선순위 que 생성
2. 숫자면 숫자 넣기
3. 0이면 que 크기 확인 후 숫자 꺼내기 or 0 출력
 */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a == 0) {
                if(pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(a);
            }
        }
        System.out.println(sb);
    }
}
