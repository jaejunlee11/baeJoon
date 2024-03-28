/*
 * 문제
 * 1. 블록이 존재
 * 2. 가스관은 전부 연결 => + 가스관은 4방향 다 연결
 * 3. M,Z로 가스가 흘러야함
 * 4. 지워진 블록을 찾기
 * 
 * 풀이
 * 1. N,M입력
 * 2. char arr[N][M]생성
 * 4. arr입력 받기
 * 5. for문 돌리기
 *     5.1. Z에서 시작
 *     5.2. 갈 블록 방향을 저장(arrow)
 *         5.2.1. +,1,4, | => 위쪽 방향
 *         5.2.2. +,3,4, - => 우측 방향
 *         5.2.3. +,2,3, | => 아래쪽 방향
 *         5.2.4. +, 1,2, - => 좌측 방향
 * 6. 해당 방향으로 while로 이동
 *     6.1. 다음 블록에 따라서 방향 전환
 *         6.1.1. |, +, - 유지
 *         6.1.2. 위쪽 => 1 => 우측, 4 => 좌측
 *         6.1.3. 아래쪽 => 2 => 우측, 3=> 좌측
 *         6.1.4. 우측 => 3 => 위쪽, 4 => 아래쪽
 *         6.1.5. 좌측 => 1 => 아래쪽, 2 => 위쪽
 *     6.2. .을 만나는 경우 => 해당 좌표 + 방향 저장
 * 7. M에서 시작 => 방향 저장
 * 8. 2개의 방향에 맞춰서 출력
 *     8.1. 
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; // 상, 하, 좌, 우
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr= new char[N][M];
        int mr = 0;
        int mc = 0;
        int zr = 0;
        int zc = 0;
        for(int i = 0;i<N;i++) {
            String temp = br.readLine();
            for(int j = 0;j<M;j++){
                arr[i][j] = temp.charAt(j);
                if(arr[i][j]=='M') {
                    mr = i;
                    mc = j;
                }
                if(arr[i][j]=='Z') {
                    zr = i;
                    zc = j;
                }
            }
        }
        int startMr = mr;
        int startMc = mc;
        int marrow = 0;
        for(int k = 0;k<4;k++) {
            int nmr = mr +dir[k][0];
            int nmc = mc +dir[k][1];
            if(nmr<0 || nmc<0 || nmr>=N || nmc>=M) continue;
//            System.out.println("m" + nmr +" " +nmc);
            if(k==0) {
                if(arr[nmr][nmc]=='|' || arr[nmr][nmc]=='+' ||arr[nmr][nmc]=='1' ||arr[nmr][nmc]=='4') {
                    marrow = 0;
                    break;
                }
            }
            if(k==1) {
                if(arr[nmr][nmc]=='|' || arr[nmr][nmc]=='+' || arr[nmr][nmc]=='2' || arr[nmr][nmc]=='3') {
                    marrow=1;
                    break;
                }
            }
            if(k==2) {
                if(arr[nmr][nmc]=='-' || arr[nmr][nmc]=='+' || arr[nmr][nmc]=='1' || arr[nmr][nmc]=='2') {
                    marrow=2;
                    break;
                }
            }
            if(k==3) {
                if(arr[nmr][nmc]=='-' || arr[nmr][nmc]=='+' || arr[nmr][nmc]=='3' || arr[nmr][nmc]=='4') {
                    marrow=3;
                    break;
                }
            }
        }
        while(true) {
            mr = mr +dir[marrow][0];
            mc = mc +dir[marrow][1];
            if(arr[mr][mc]=='|' || arr[mr][mc]=='-' || arr[mr][mc]=='+') continue;
            if(marrow==0) {
                if(arr[mr][mc]=='1') {
                    marrow = 3;
                    continue;
                }
                if(arr[mr][mc]=='4') {
                    marrow = 2;
                    continue;
                }
            }
            if(marrow==1) {
                if(arr[mr][mc]=='2') {
                    marrow=3;
                    continue;
                }
                if( arr[mr][mc]=='3') {
                    marrow =2;
                    continue;
                }
            }
            if(marrow==2) {
                if(arr[mr][mc]=='1') {
                    marrow=1;
                    continue;
                }
                if(arr[mr][mc]=='2') {
                    marrow=0;
                    continue;
                }
            }
            if(marrow==3) {
                if(arr[mr][mc]=='3') {
                    marrow=0;
                    continue;
                }
                if(arr[mr][mc]=='4') {
                    marrow=1;
                    continue;
                }
            }
            if(arr[mr][mc]=='.') {
                break;
            }
        }
        int zarrow = 0;
        for(int k = 0;k<4;k++) {
            int zmr = zr +dir[k][0];
            int zmc = zc +dir[k][1];
            if(zmr<0 || zmc<0 || zmr>=N || zmc>=M) continue;
            if(k==0) {
                if(arr[zmr][zmc]=='|' || arr[zmr][zmc]=='+' ||arr[zmr][zmc]=='1' ||arr[zmr][zmc]=='4') {
                    zarrow = 0;
                    break;
                }
            }
            if(k==1) {
                if(arr[zmr][zmc]=='|' || arr[zmr][zmc]=='+' || arr[zmr][zmc]=='2' || arr[zmr][zmc]=='3') {
                    zarrow=1;
                    break;
                }
            }
            if(k==2) {
                if(arr[zmr][zmc]=='-' || arr[zmr][zmc]=='+' || arr[zmr][zmc]=='1' || arr[zmr][zmc]=='2') {
                    zarrow=2;
                    break;
                }
            }
            if(k==3) {
                if(arr[zmr][zmc]=='-' || arr[zmr][zmc]=='+' || arr[zmr][zmc]=='3' || arr[zmr][zmc]=='4') {
                    zarrow=3;
                    break;
                }
            }
        }
        while(true) {
            zr = zr +dir[zarrow][0];
            zc = zc +dir[zarrow][1];
            if(arr[zr][zc]=='|' || arr[zr][zc]=='+' || arr[zr][zc]=='-') continue;
            if(zarrow==0) {
                if(arr[zr][zc]=='1') {
                    zarrow = 3;
                    continue;
                }
                if(arr[zr][zc]=='4') {
                    zarrow = 2;
                    continue;
                }
            }
            if(zarrow==1) {
                if(arr[zr][zc]=='2') {
                    zarrow=3;
                    continue;
                }
                if( arr[zr][zc]=='3') {
                    zarrow =2;
                    continue;
                }
            }
            if(zarrow==2) {
                if(arr[zr][zc]=='1') {
                    zarrow=1;
                    continue;
                }
                if(arr[zr][zc]=='2') {
                    zarrow=0;
                    continue;
                }
            }
            if(zarrow==3) {
                if(arr[zr][zc]=='3') {
                    zarrow=0;
                    continue;
                }
                if(arr[zr][zc]=='4') {
                    zarrow=1;
                    continue;
                }
            }
            if(arr[zr][zc]=='.') {
                break;
            }
        }
        System.out.print((zr+1) +" " + (zc+1)+" ");
//        System.out.println();
        char answer = 0;
        if(zarrow==0) {
            if(marrow==1) {
                int zmr = zr +dir[3][0];
                int zmc = zc +dir[3][1];
                if(zmr<0 || zmc<0 || zmr>=N || zmc>=M) {
                    
                }else {
                    if(arr[zmr][zmc]=='-' || arr[zmr][zmc]=='+' || arr[zmr][zmc]=='3' || arr[zmr][zmc]=='4') {
                        System.out.println('+');
                        return;
                    }
                }
//                System.out.println("|");
                answer = '|';
                arr[zr][zc]=answer;
            }
            if(marrow==2) {
//                System.out.println("1");
                answer = '1';
                arr[zr][zc]=answer;
            }
            if(marrow==3) {
//                System.out.println("4");
                answer = '4';
                arr[zr][zc]=answer;
            }
        }
        if(zarrow==1) {
            if(marrow==0) {
                int zmr = zr +dir[3][0];
                int zmc = zc +dir[3][1];
                if(zmr<0 || zmc<0 || zmr>=N || zmc>=M) {
                    
                }else {
                    if(arr[zmr][zmc]=='-' || arr[zmr][zmc]=='+' || arr[zmr][zmc]=='3' || arr[zmr][zmc]=='4') {
                        System.out.println('+');
                        return;
                    }
                }
//                System.out.println("|");
                answer = '|';
                arr[zr][zc]=answer;
            }
            if(marrow==2) {
//                System.out.println("2");
                answer = '2';
                arr[zr][zc]=answer;
            }
            if(marrow==3) {
//                System.out.println("3");
                answer = '3';
                arr[zr][zc]=answer;
            }
        }
        if(zarrow==2) {
            if(marrow==0) {
//                System.out.println("1");
                answer = '1';
                arr[zr][zc]=answer;
            }
            if(marrow==1) {
//                System.out.println("2");
                answer = '2';
                arr[zr][zc]=answer;
            }
            if(marrow==3) {
                int zmr = zr +dir[1][0];
                int zmc = zc +dir[1][1];
                if(zmr<0 || zmc<0 || zmr>=N || zmc>=M) {
                    
                }else {
                    if(arr[zmr][zmc]=='|' || arr[zmr][zmc]=='+' || arr[zmr][zmc]=='2' || arr[zmr][zmc]=='3') {
                        System.out.println('+');
                        return;
                    }
                }
//                System.out.println("-");
                answer = '-';
                arr[zr][zc]=answer;
            }
        }
        if(zarrow==3) {
            if(marrow==0) {
//                System.out.println("4");
                answer = '4';
                arr[zr][zc]=answer;
            }
            if(marrow==1) {
//                System.out.println("3");
                answer = '3';
                arr[zr][zc]=answer;
            }
            if(marrow==2) {
                int zmr = zr +dir[1][0];
                int zmc = zc +dir[1][1];
                if(zmr<0 || zmc<0 || zmr>=N || zmc>=M) {
                    
                }else {
                    if(arr[zmr][zmc]=='|' || arr[zmr][zmc]=='+' || arr[zmr][zmc]=='2' || arr[zmr][zmc]=='3') {
                        System.out.println('+');
                        return;
                    }
                }
//                System.out.println("-");
                answer = '-';
                arr[zr][zc]=answer;
            }
        }
//        for(int i = 0;i<N;i++) {
//        	System.out.println(Arrays.toString(arr[i]));
//        }
        mr = startMr;
        mc = startMc;
        marrow = 0;
        for(int k = 0;k<4;k++) {
            int nmr = mr +dir[k][0];
            int nmc = mc +dir[k][1];
            if(nmr<0 || nmc<0 || nmr>=N || nmc>=M) continue;
//            System.out.println("m" + nmr +" " +nmc);
            if(k==0) {
                if(arr[nmr][nmc]=='|' || arr[nmr][nmc]=='+' ||arr[nmr][nmc]=='1' ||arr[nmr][nmc]=='4') {
                    marrow = 0;
                    break;
                }
            }
            if(k==1) {
                if(arr[nmr][nmc]=='|' || arr[nmr][nmc]=='+' || arr[nmr][nmc]=='2' || arr[nmr][nmc]=='3') {
                    marrow=1;
                    break;
                }
            }
            if(k==2) {
                if(arr[nmr][nmc]=='-' || arr[nmr][nmc]=='+' || arr[nmr][nmc]=='1' || arr[nmr][nmc]=='2') {
                    marrow=2;
                    break;
                }
            }
            if(k==3) {
                if(arr[nmr][nmc]=='-' || arr[nmr][nmc]=='+' || arr[nmr][nmc]=='3' || arr[nmr][nmc]=='4') {
                    marrow=3;
                    break;
                }
            }
        }
        while(true) {
        	if(!(arr[mr][mc]=='+')) {
        		arr[mr][mc]='.';
        	}
            mr = mr +dir[marrow][0];
            mc = mc +dir[marrow][1];
            if(arr[mr][mc]=='|' || arr[mr][mc]=='-' || arr[mr][mc]=='+') continue;
            if(marrow==0) {
                if(arr[mr][mc]=='1') {
                    marrow = 3;
                    continue;
                }
                if(arr[mr][mc]=='4') {
                    marrow = 2;
                    continue;
                }
            }
            if(marrow==1) {
                if(arr[mr][mc]=='2') {
                    marrow=3;
                    continue;
                }
                if( arr[mr][mc]=='3') {
                    marrow =2;
                    continue;
                }
            }
            if(marrow==2) {
                if(arr[mr][mc]=='1') {
                    marrow=1;
                    continue;
                }
                if(arr[mr][mc]=='2') {
                    marrow=0;
                    continue;
                }
            }
            if(marrow==3) {
                if(arr[mr][mc]=='3') {
                    marrow=0;
                    continue;
                }
                if(arr[mr][mc]=='4') {
                    marrow=1;
                    continue;
                }
            }
            if(arr[mr][mc]=='Z') {
            	for(int i = 0;i<N;i++) {
            		for(int j = 0;j<M;j++) {
            			if(arr[i][j]!='.' && arr[i][j]!='+' && arr[i][j]!='Z') {
            				System.out.println("+");
            				return;
            			}
            		}
            	}
                System.out.println(answer);
                return;
            }
            break;
        }
//        System.out.println(mr+" " + mc);
        System.out.println("+");
    }
}