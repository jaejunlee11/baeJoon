import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int target = arr[i] + M; // M 이상 차이가 나야하므로 arr[i] + M 이상인 값을 찾아야 함
            int j = binarySearch(i + 1, N - 1, target); // i+1 부터 N-1 까지 이분 탐색

            if (j != -1) {
                answer = Math.min(answer, arr[j] - arr[i]);
            }

            if (answer == M) break; // 최소 차이가 M이면 바로 종료
        }

        System.out.println(answer);
    }

    private static int binarySearch(int start, int end, int target) {
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                result = mid; // 조건을 만족하는 첫 번째 위치를 찾는다
                end = mid - 1; // 더 작은 index에서 만족하는 값을 찾기 위해 end를 줄인다
            } else {
                start = mid + 1; // 만족하지 않으면 더 큰 index로 범위를 이동
            }
        }
        return result; // 조건을 만족하는 가장 작은 index를 반환, 없으면 -1
    }
}