/*
문제
1. 색종이가 있음
2. 1, 0 으로 이루어져있음
3. 만약 1또는 0으로만 채워져있음 하나의 색종이
4. 색종이의 갯수는?

풀이
1. N입력
2. arr[N][N]생성
3. arr 채우기
4. check 함수 생성(r1,r2,h1,h2)
    4.0. arr[r1][h1] 확인
    4.1. for문 돌리기 r1~r2
        4.2. for문 돌리기 h1~h2
            4.3. 전부 arr[r1][h1]과 동일하면 ans 올리기 return
    4.4. 아닌 경우 check()함수 호출
 */
import java.util.*;
import java.io.*;
public class Main {
    public static int ans1 = 0;
    public static int ans2 = 0;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check(0,N,0,N,N/2);
        System.out.println(ans1);
        System.out.println(ans2);
    }
    public static void check(int r1, int r2, int h1, int h2, int size) {
        int temp = arr[r1][h1];
        for(int i = r1;i<r2;i++) {
            for(int j = h1;j<h2;j++) {
                if(temp != arr[i][j]) {
                    check(r1,r2-size, h1, h2-size, size/2);
                    check(r1,r2-size, h1 + size, h2, size/2);
                    check(r1 + size,r2, h1 + size, h2, size/2);
                    check(r1 + size,r2, h1, h2-size, size/2);
                    return;
                };
            }
        }
        if(temp == 0) ans1++;
        if(temp == 1) ans2++;
    }
}
