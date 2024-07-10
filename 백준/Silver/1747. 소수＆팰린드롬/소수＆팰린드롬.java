import java.io.*;
import java.util.*;
/*
문제
1. 숫자 보다 크면서 소수이고 펠린드롬인 수 구하기

풀이
1. n입력 받기
2. while돌리기
    2.1. 소수 확인
    2.2. 펠림드롬 확인

펠린드롬 확인
1. 숫자 크기 확인 => size
2. size가 홀수 일때
    2.1. for문 돌리기 => size/2
        2.1.1. list에 담기 => %10 /10
    2.2. for문 돌리기 => size/2
        2.2.1. list에서 꺼꾸로 꺼내면서 비교
3. size가 짝수 일때
    3.1. for문 돌리기 => size/2
        3.1.1. list에 담기 => %10 /10
    3.2. /10
    3.3. for문 돌리기 => size/2
        3.3.1. list에서 꺼내서 비교

소수 확인
1. %2확인
2. for문돌리기 => i*i<n
    2.1. %i확인
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n--;
        while(true){
            n++;
            if(!palin(n)) continue;
            if(!gcd(n)) continue;
            System.out.println(n);
            return;
        }
    }
    private static boolean palin(int num){
        List<Integer> list = new ArrayList<>();
        while(num!=0){
            list.add(num%10);
            num /= 10;
        }
        int size = list.size();
        for(int i = 0;i<size/2;i++){
            if(list.get(i) != list.get(size-i-1)){
                return false;
            };
        }
        return true;
    }

    private static boolean gcd(int num){
        if(num==1) return false;
        if(num%2==0){
            if(num==2) return true;
            return false;
        }
        for(int i = 3;i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}