/*
문제
1. 숫자를 입력 또는 출력
2. 출력시 가장 큰 수를 출력

풀이
1. prority que 사용
2. 0이 아닌 경우 넣기
3. 0인 경우 꺼내고 출력
 */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0){
                if(pq.isEmpty()){
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll() + "\n");
                }
            } else {
                pq.add(n);
            }
        }
        System.out.println(sb);
    }
}
