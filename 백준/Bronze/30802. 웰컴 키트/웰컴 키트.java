/*
문제
1. 티셔츠, 펜이 있음
2. 묶음으로 팜
3. 티셔츠 몇 묶음
4. 펜 몇 묶음 + 개별 갯수

풀이
1. N입력
2. a,b,c,d,e,f 입력
3. T, P 입력
4. a/T 나머지 있으면 + 1 ...
5. N/P, N%P
 */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for (int i = 0;i<6;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st1.nextToken());
        int P = Integer.parseInt(st1.nextToken());
        int ans1 = 0;
        for(int i = 0;i<6;i++) {
            ans1 += (arr[i]/T + ((arr[i]%T==0)?0:1));
        }
        System.out.println(ans1);
        System.out.println(N/P +" " + N%P);
    }
}
