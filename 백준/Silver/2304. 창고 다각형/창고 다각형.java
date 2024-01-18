/*
 * 1. 기둥 갯수 입력
 * 2. 기둥 위치와 높이 입력
 * 3. 가장 높은 빌딩 위치 파악
 * 4. 가장 왼쪽 빌딩 높이 파악
 * 5. 오른쪽으로 가장 높은 빌딩까지 이동
 *     5.1. 자신 보다 큰 빌딩을 만나면 (높이*이동 거리) 더해주기
 * 6. 가장 오른쪽 빌딩 높이 파악
 * 7. 왼쪽으로 이동하면서 가장 높은 빌딩 까지 이동
 *     7.1 자신 보다 큰 빌딩을 만나면 (높이*이동 거리) 더해주기
 * 8. 왼쪽 오른쪽 둘 중 높은 크기 구하기
 * 9. 가장 높은 빌딩 크기 - 둘중높은 크기 더해주기
 * 10. 출력
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] buildingArr = new int[N][2];
        int maxBuilingHeight = 0;
        int maxIndex = 0;
        for(int i = 0; i < N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildingArr[i][0] = Integer.parseInt(st.nextToken());
            buildingArr[i][1] = Integer.parseInt(st.nextToken());
            if(maxBuilingHeight<buildingArr[i][1]) {
                maxBuilingHeight = buildingArr[i][1];
                maxIndex = buildingArr[i][0];
            }
        }	
        Arrays.sort(buildingArr,(o1,o2)->{return o1[0]-o2[0];});
        int answer = 0;
        int tempHeight = buildingArr[0][1];
        int tempIndex = buildingArr[0][0];
        int leftHeight = 0;
        for(int i = 1; i< N;i++) {
            if(buildingArr[i][0] == maxIndex) {
                answer += tempHeight*(buildingArr[i][0]-tempIndex);
                break;
            }
            if(buildingArr[i][1]>tempHeight) {
                answer += tempHeight*(buildingArr[i][0]-tempIndex);
                tempHeight =buildingArr[i][1];
                tempIndex = buildingArr[i][0];
            }
        }
        tempHeight = buildingArr[N-1][1];
        tempIndex = buildingArr[N-1][0];
        for(int i = N-1; i>=0;i--) {
            if(buildingArr[i][0] == maxIndex) {
                answer += tempHeight*(tempIndex-buildingArr[i][0]);
                break;
            }
            if(buildingArr[i][1]>tempHeight) {
                answer += tempHeight*(tempIndex-buildingArr[i][0]);
                tempHeight =buildingArr[i][1];
                tempIndex = buildingArr[i][0];
            }
        }
         answer += maxBuilingHeight;
        System.out.println(answer);
    }
}