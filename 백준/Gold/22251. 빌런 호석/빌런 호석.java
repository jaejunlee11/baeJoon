import java.io.*;
import java.util.*;
/*
문제
1. N,K,P,X 입력 => 최대 층수, 최대 자리수, 바꿀 수 있는 led 갯수, 현재 층수
2. 반전 시켜서 만들 수 있는 숫자 갯수 구하기

아이디어
1. N까지 순회
2. 이때 각 자리수를 확인하면서 기존 자리수에서 변경된 숫자에 따라 바뀐 led갯수 구하기
3. led 갯수가 P를 초과하면 pass
4. 아니면 answer++

풀이
1. N,K,P,X입력
2. num[11][7] 만들기 => led가 켜진 것  true, 아닌 것 false
3. arr[10][10] 만들기
    3.1. for문 돌리기 => 7
        3.1.1. num[i][k] != num[j][k]이면 count++
    3.2. arr[i][j] = count
4. origin[K] 채우기
4. for문 돌리기  N
    4.0. count = 0
    4.1. for문 돌리기 K
        4.1.1. count += arr[origin[i]][N%pow(10,i+1)]
    4.3. count<= P => answer++
5. answer 출력


고려해야할 것
1. 시간 복잡도 : 10^6 * 2 => 충분
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[][] num = {
                // 0
                {1,1,1,0,1,1,1},
                // 1
                {0,0,0,0,0,1,1},
                // 2
                {0,1,1,1,1,1,0},
                // 3
                {0,0,1,1,1,1,1},
                // 4
                {1,0,0,1,0,1,1},
                // 5
                {1,0,1,1,1,0,1},
                // 6
                {1,1,1,1,1,0,1},
                // 7
                {0,0,1,0,0,1,1},
                // 8
                {1,1,1,1,1,1,1},
                // 9
                {1,0,1,1,1,1,1}
        };
        int[][] arr = new int[10][10];
        for(int i = 0;i < 10;i++){
            for(int j = 0;j < 10;j++){
                int count = 0;
                for(int k = 0;k < 7;k++){
                    if(num[i][k]!=num[j][k]) count++;
                }
                arr[i][j] = count;
            }
        }
        int answer = 0;
        for(int i = 1;i<=N;i++) {
            int count = 0;
            for(int k = 0; k<K;k++){
                count += arr[(i/((int) Math.pow(10,k)))%10][(X/((int) Math.pow(10,k)))%10];
            }
            if(count<=P && i != X) answer++;
        }
        System.out.println(answer);
    }
}