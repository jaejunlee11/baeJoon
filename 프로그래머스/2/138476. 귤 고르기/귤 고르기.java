/*
문제
1. 귤들이 있음
2. 크기가 각각 다름 => 10000000
3. 귤을 K개를 고를 때 같은 종류의 과일이 가장 적게 담기
4. 종류의 수를 출력

풀이
1. arr[10000001]생성
2. tnagerine 순회
    2.1. 값에 해당하는 것을 배열값을 ++
3. 내림차순 arr 정렬
4. for문으로 순회하면서 합이 K가 같거나 넘어가면 i출력
*/
import java.io.*;
import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] arr = new int[10000001];
        for(int i : tangerine){
            arr[i]++;
        }
        Arrays.sort(arr);
        int sum =0;
        for(int i=10000000; i>=0;i--){
            sum+=arr[i];
            if(sum>=k) return 10000001-i;
        }
        return answer;
    }
}