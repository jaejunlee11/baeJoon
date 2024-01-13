/*
1.블록의 가로 세로 값입력 받기
2.위치 배열에 저장
3.동서남북에 따라 거리 비교
3-1. 같은 위치인 경우 -> 두 수의 차의 절대값
3-2. 바로 옆인 경우
3-2-1. 북,서 -> 북값 + 세로-서값
북,동 -> 가로 - 북값 + 세로 - 동값
남,서 -> 남값 + 서값
남,동 -> 가로 - 남값 + 동값
3-3. 반대인 경우
3-3-1. 북,남 -> 남+북>가로 -> 2* 가로 - (남+북) + 세로
-> 남+북+세로
3-3-2. 동,서 -> 동+서>세로 -> 2* 세로 - (동+서) + 가로
-> 동+서+가로
모든 거리의 합 더하기
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int height;
    static int wide;
    //3-1. 같은 위치인 경우 -> 두 수의 차의 절대값
    public static int same(int dis1, int dis2) {
        return Math.abs(dis1-dis2);
    }
    //바로 옆인 경우
    //3-2-1. 북,서 -> 북값 + 서값
    public static int NW(int disN,int disW) {
        return disN + disW;
    }
    //북,동 -> 가로 - 북값 + 동값
    public static int NE(int disN,int disE) {
        return wide - disN + disE;
    }
    //남,서 -> 남값 + 세로 - 서값
    public static int SW(int disS, int disW) {
        return disS + height - disW;
    }
    //남,동 -> 가로 - 남값 + 세로 -  동값
    public static int SE(int disS, int disE) {
        return wide - disS+ height - disE;
    }
    //반대인 경우
    // 북,남 -> 남+북>가로 -> 2* 가로 - (남+북) + 세로
    public static int SN(int disS, int disN) {
        if((disS + disN)>wide) {
            return (2*wide - (disS+disN) + height);
        } else {
            return (disS+disN +height);
        }
    }
    //동,서 -> 동+서>세로 -> 2 세로 - (동+서) + 가로
    //                    -> 동+서+가로
    public static int EW(int disE,int disW) {
        if((disE+disW)>height) {
            return 2* height - (disE+disW) + wide;
        }else {
            return disE+disW+wide;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1= new StringTokenizer(br.readLine());
        wide = Integer.parseInt(st1.nextToken());
        height = Integer.parseInt(st1.nextToken());
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i = 0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int homeDir = Integer.parseInt(st.nextToken());
        int homeDis = Integer.parseInt(st.nextToken());
        int answerDis = 0;
        switch(homeDir) {
        //북
        case 1:{
            for(int i = 0;i<N;i++) {
                switch(arr[i][0]) {
                //북
                case 1 : answerDis += same(homeDis,arr[i][1]);break;
                //남
                case 2 : answerDis += SN(homeDis,arr[i][1]);break;
                //서
                case 3 : answerDis += NW(homeDis,arr[i][1]);break;
                //동
                case 4 : answerDis += NE(homeDis,arr[i][1]);break;
                }
            }
            break;
        }
        //남
        case 2:{
            for(int i = 0;i<N;i++) {
                switch(arr[i][0]) {
                //북
                case 1 : answerDis += SN(homeDis,arr[i][1]);break;
                //남
                case 2 : answerDis += same(homeDis,arr[i][1]);break;
                //서
                case 3 : answerDis += SW(homeDis,arr[i][1]);break;
                //동
                case 4 : answerDis += SE(homeDis,arr[i][1]);break;
                }
            }
            break;
        }
        //서
        case 3:{
            for(int i = 0;i<N;i++) {
                switch(arr[i][0]) {
                //북
                case 1 : answerDis += NW(arr[i][1],homeDis);break;
                //남
                case 2 : answerDis += SW(arr[i][1],homeDis);break;
                //서
                case 3 : answerDis += same(homeDis,arr[i][1]);break;
                //동
                case 4 : answerDis += EW(homeDis,arr[i][1]);break;
                }
            }
            break;
        }
        //동
        case 4:{
            for(int i = 0;i<N;i++) {
                switch(arr[i][0]) {
                //북
                case 1 : answerDis += NE(arr[i][1],homeDis);break;
                //남
                case 2 : answerDis += SE(arr[i][1],homeDis);break;
                //서
                case 3 : answerDis += EW(homeDis,arr[i][1]);break;
                //동
                case 4 : answerDis += same(homeDis,arr[i][1]);break;
                }
            }
            break;
        }
        }
        System.out.println(answerDis);
    }
}