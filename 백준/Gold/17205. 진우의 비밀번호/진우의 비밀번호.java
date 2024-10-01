import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
문제
1. 비밀번호가 존재
2. 비밀번호를 노가다로 사전순으로 도전
3. 비밀번호를 맞추는데 얼마나 소요되는지?

아이디어
1. a00, aa0, aaa, aab, aac, aad, ...aaz, ab0, aba, abb, ... ac0, ... az0,..., azz, b00, ba => (27*26+1) * 26
2. a000, aa00, aaa0, aaaa,  => ((27*26 +1) * 26 +1)
2. a00000, aa0000, aaa000,aaaa00,aaaaa0,aaaaaa,

풀이
1. N입력
2. answer 문자열 입력
3. for문 돌기 글자수 -1
    3.1. num
    3.2. for문 돌리기 (N-1-i) => temp = 27
        3.2.1. temp * 26 + 1
    3.3. answer += (num-1) * temp
4. 마지막 파트
    4.1. answer += num+1
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String temp = br.readLine();
        long answer = 0;
        for(int i=0;i<temp.length();i++){
            long num = 0;
            for(int j = 0;j < N-i; j++) {
                num *= 26;
                num++;
            }
            num = (temp.charAt(i)-'a') * num;
            num++;
            answer += num;
        }
        System.out.println(answer);
    }
}