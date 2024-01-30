
/*
 * 어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.
"재귀함수가 뭔가요?"
"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
출력
1. N입력 받기
2. N만큼 재귀돌기
3. ____"재귀함수가 뭔가요?"
____"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
____마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
____그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
 */
import java.util.*;
public class Main {
	public static void recur(int count,int Finish) {
		if(count==(Finish)) {
			for(int i = 0 ; i < count;i++) {
				System.out.print("____");
			}
			System.out.println("\"재귀함수가 뭔가요?\"");
			for(int i = 0 ; i < count;i++) {
				System.out.print("____");
			}
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			return;
		}
		for(int i = 0 ; i < count;i++) {
			System.out.print("____");
		}
		System.out.println("\"재귀함수가 뭔가요?\"");
		for(int i = 0 ; i < count;i++) {
			System.out.print("____");
		}
		System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		for(int i = 0 ; i < count;i++) {
			System.out.print("____");
		}
		System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		for(int i = 0 ; i < count;i++) {
			System.out.print("____");
		}
		System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		recur(++count,Finish);
		for(int i = 0 ; i < count;i++) {
			System.out.print("____");
		}
		System.out.println("라고 답변하였지.");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recur(0,N);
		System.out.println("라고 답변하였지.");
	}
}
