/**************************************************************
    Problem: 1103
    User: kdd021144
    Language: Java
    Result: Success
    Time:200 ms
    Memory:10640 kb
****************************************************************/
 
 
import java.util.*;
 
public class Main {
 
    static int R, C, minDist;
    static int d_Dir, d_Dist; // 동근이 좌표
     
    // 1,2,3,4 : 북남서동
    // 좌측상단을 기준으로 잡고, 목적지까지 시계방향으로 가는데 소요되는 거리 반환
    // 상점이 블록의 북쪽 또는 남쪽에 위치한 경우 블록의 왼쪽 경계로부터의 거리를 나타내고,
    // 상점이 블록의 동쪽 또는 서쪽에 위치한 경우 블록의 위쪽 경계로부터의 거리를 나타낸다.
    static final int distCW(int dir, int dist) {
        int ret = 0;
        if (dir == 1) {
            ret = dist;
        } else if (dir == 2) {
            ret = 2*C + R - dist;
        } else if (dir == 3) {
            ret = 2*(C+R) - dist;
        } else if (dir == 4) {
            ret = C + dist;
        }
        return ret;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        R = sc.nextInt();
        int N = sc.nextInt();
        int storeDist[] = new int[N];
        for (int i = 0; i < N; i++) {
            int dir = sc.nextInt();
            int dist = sc.nextInt();
            storeDist[i] = distCW(dir, dist);
        }
        d_Dir = sc.nextInt();
        d_Dist = sc.nextInt();
        int dDist = distCW(d_Dir, d_Dist);
 
        for (int i = 0; i < N; i++) {
            int distCW = Math.abs(dDist - storeDist[i]);
            int distCCW = 2*(R+C) - distCW;
            // 시계방향으로 가는게 빠른지, 아니면 반시계 방향으로 가는게 빠른지.
            minDist += Math.min(distCW, distCCW);
        }
        System.out.println(minDist);
    }
}