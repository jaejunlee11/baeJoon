/*
문제
1. R은 배열 뒤집기
2. D는 가장 앞쪽꺼 버리기
3. 명령어와 배열이 주어짐
4. 해당 명령의 결과 출력

풀이
1. T 입력
2. 명령어 저장
3. 배열 크기 입력
4. trim "[,]"으로 사이드 제거 => , String Tokenizer로 쪼개서 가져오기
5. deque에 넣기
6. 명령어 for문 돌리기
    6.1. R인 경우 side변경
    6.2. D의 경우, 크기가 0이면 ERROR 출력, side == 0 이면 pop, side == 1이면 거꾸로 빼기
7. 출력
 */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        A : while (T-- > 0) {
            String order = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();
            arrStr = arrStr.substring(1, arrStr.length()-1);
            StringTokenizer st = new StringTokenizer(arrStr, ",");
            Deque<Integer> stack = new ArrayDeque<>();
            for(int i = 0; i < n; i++) {
                stack.add(Integer.parseInt(st.nextToken()));
            }
            int side = 0;
            for(int i = 0;i<order.length();i++) {
                char ch = order.charAt(i);
                if(ch == 'R') {
                    side = side == 0 ? 1 : 0;
                } else if(ch == 'D') {
                    if(stack.size() ==0 ) {
                        sb.append("error\n");
                        continue A;
                    }
                    if(side == 0) {
                        stack.pollFirst();
                    } else {
                        stack.pollLast();
                    }
                }
            }
            int stackSize = stack.size();
            sb.append('[');
            if (!stack.isEmpty()) {
                if (side == 0) {
                    while (stack.size() > 1) { sb.append(stack.pollFirst()).append(','); }
                    sb.append(stack.pollFirst());
                } else {
                    while (stack.size() > 1) { sb.append(stack.pollLast()).append(','); }
                    sb.append(stack.pollLast());
                }
            }
            sb.append("]\n");
        }
        System.out.print(sb);
    }
}
