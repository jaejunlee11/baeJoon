/*
 * 문제
 * 1. 학생 생일이 주어짐
 * 2. 나이가 가장 작은 사람과 많은 사람 출력
 * 
 * 풀이
 * 1. N입력
 * 2. String[N] 생성
 * 3. arr을  3,2,1 순으로 정렬
 * 4. N-1, 0의 값 출력
 */
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [][] arr = new String[N][4];
        for(int i =0;i<N;i++) {
            StringTokenizer st  = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
            arr[i][2] = st.nextToken();
            arr[i][3] = st.nextToken();
        }
        
        Arrays.sort(arr,(o1,o2)->{
            if(o1[3].equals(o2[3])) {
                if(o1[2].equals(o2[2])) {
                    return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                }
                return Integer.parseInt(o1[2])- Integer.parseInt(o2[2]);
            }
            return o1[3].compareTo(o2[3]);
        });
//        for(int i = 0;i<N;i++) {
//        	System.out.println(Arrays.toString(arr[i]));
//        }
        System.out.println(arr[N-1][0]);
        System.out.println(arr[0][0]);
    }

}