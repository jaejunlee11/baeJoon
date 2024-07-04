import java.io.*;
import java.util.*;
/*
문제
1. moo게임

풀이
1. n입력
2. dfs(1,2) 돌리기 => count - 1, 가운데 ,count -1로 분리


dfs(현재위치, count)
1. count-1>=2 인 경우 point = dfs(현재위치, count-1), 아니면 1
2. point==n인 경우 return true
3. point += (count + 1)
4. count-1>=2 인 경우 dfs(point, count-1)


 */
public class Main {
    static int n = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(1,1000);
    }
    private static int dfs(int now, int count){
//        System.out.println(now);
        int point = now;
        if(point==n){
            System.out.println("m");
            System.exit(0);
        }
        if(count-1 >= 2){
            point = dfs(now,count-1);
            if(point==n){
                System.out.println("m");
                System.exit(0);
            }
        }
        point += (count+1);
        if(point==n){
            System.out.println("m");
            System.exit(0);
        }
        if(count-1 >= 2){
            point = dfs(point,count-1);
            if(point>n){
                System.out.println("o");
                System.exit(0);}
            if(point==n){
                System.out.println("m");
                System.exit(0);
            }
        }
        return point;
    }
}