/*
문제
1. 공집합 S 존재
2. add 시 추가, remove 시 제거, check시 존재하는지 확인, toggle 시 있으면 제거, 없으면 생성, all시 전부 체크, empty시 전부 제거

풀이
1. 배열 S 생성 => [20]
2. add시 S[i] = 1
3. remove 시 S[i] = 0
4. check시 S[i] 출력
5. togle시 전환
6. all,empty 시 배열 재성성

시간
1. 3000000 * 20 => 6천만 충분
 */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] sArr = new int[21];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int x = -1;
            switch (order) {
                case "add" :
                case "remove" :
                case "check" :
                case "toggle" :
                    x = Integer.parseInt(st.nextToken());
            }
            switch (order) {
                case "add" :
                    sArr[x] = 1;
                    break;
                case "remove" :
                    sArr[x] = 0;
                    break;
                case "check" :
                    sb.append(sArr[x] + "\n");
                    break;
                case "toggle" :
                    sArr[x] = sArr[x] == 1 ? 0 : 1;
                    break;
                case "all" :
                    Arrays.fill(sArr, 1);
                    break;
                case "empty" :
                    Arrays.fill(sArr, 0);
                    break;
            }
        }
        System.out.println(sb);
    }
}
