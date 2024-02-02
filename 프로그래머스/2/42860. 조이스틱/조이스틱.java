import java.util.Arrays;

/*
 * 
 * 문제
 * 1. 이름 주어짐
 * 2. 이름 크기의 AAA생성
 * 3. 이름을 위로 아래로 이동 가능 (A~Z) -> 26개 => 그냥 아스키쓰면 될 듯 -> 14보다 작은 번째 글자는 오른쪽, 아니면 왼쪽
 * 4. 좌우로 이동 가능-> 가장 왼쪽에서 오른쪽으로 이동 가능
 * 
 * 풀이
 * 1. 이름 입력 받음
 * 2. 이름 갯수의 배열 생성 및 각 아스키 값에 맞는 숫자 입력 (chartoArray쓰고 a-'A' => 숫자로 배열 입력)
 * 3. 현재 위치 기준 연속된 0뭉치 위치 전부 확인
 * 	3.1. 0을 만나면 해당 위치 저장 -> 0이 끝나는 경우 
 * 		3.1.1. (시작점 기준) 오른쪽으로 돌기(그냥 전부 확인), 오른쪽으로 돌기(왼쪽에 박치기 하고 오른쪽으로 돌기), 왼쪽으로 돌기(오른쪽에 박치기 하고 왼쪽으로 돌기)
 * 		3.1.2. 그 중 최소 값들 중 최소값 구하기(이동 위치만 계산)
 * 5. 값 계산 -> 13 보다 작은 경우 현재값, 13보다 큰경우 26- 현재값 =>모든 문자들의 바꿔야하는 값
 * 6. 더해서 출력
 */
public class Solution {
    //좌우 조이스틱 방향
    public static int solution(String name) {
        //이름 갯수 만큼의 배열 생성 및 숫자 채우기
        int nameLength = name.length();
        int[] arr = new int[nameLength];
        for(int i = 0;i<nameLength;i++) {
            arr[i] = name.charAt(i)-'A';
        }
        //좌우 이동 계산
        //오른쪽으로 쭉 가기
        int moveMin = nameLength-1;
        for(int i = 1 ; i <nameLength;i++) {
        	if(arr[i]==0) {
        		for(int j = i+1;true;j++) {
        			if(j==nameLength) {
               			if(arr[j-1]!=0) {
            				//2가지 case
            				//오른쪽으로 가다가 돌아오기
            				int tempMove = ((i-1)*2+(nameLength-(j-1))); ;
            				if(tempMove<moveMin) moveMin = tempMove;
            				//왼쪽으로 가다가 돌아오기
            				tempMove = ((nameLength-(j-1))*2+(i-1));
            				if(tempMove<moveMin) moveMin = tempMove;
            				i=j;
            				break;
            			}else {
            				//2가지 case
            				//오른쪽으로 가다가 돌아오기
            				int tempMove = ((i-1)*2+(nameLength-(j))); ;
            				if(tempMove<moveMin) moveMin = tempMove;
            				//왼쪽으로 가다가 돌아오기
            				tempMove = ((nameLength-(j))*2+(i-1));
            				if(tempMove<moveMin) moveMin = tempMove;
            				i=j;
            				break;
            			}
        			}
        			if(arr[j]!=0) {
        				//2가지 case
        				//오른쪽으로 가다가 돌아오기
        				int tempMove = ((i-1)*2+(nameLength-j)); ;
        				if(tempMove<moveMin) moveMin = tempMove;
        				//왼쪽으로 가다가 돌아오기
        				tempMove = ((nameLength-j)*2+(i-1));
        				if(tempMove<moveMin) moveMin = tempMove;
        				i=j;
        				break;
        			}
        		}
        	}
        }
        //정답 이동 횟수
        int answer = moveMin;
        //각 위치 count 계산
        for(int i = 0; i<nameLength;i++) {
        	answer += moveCount(arr[i]);
        }   
        return answer;
    }
    //문자 바꾸기 계산 함수
    public static int moveCount(int spell) {
        if(spell<13) return spell;
        return 26-spell;
    }
}