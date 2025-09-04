/*
문제
1. N개의 주소 + 비밀번호
2. M개의 주소
3. 주소의 비밀번호를 출력

풀이
1. map 생성
2. map에 주소를 key, 비밀번호를 값으로 입력
3. map에서 꺼내기
 */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(map.get(br.readLine()) + "\n");
        }
        System.out.println(sb);
    }
}
