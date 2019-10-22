import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class 게리맨더링T {
    static int N; // 선거구의 수
    static int[] voters; // 각 선거구별 유권자의 수
    static int[][] adj; // 각 선거구 간 연결을 표현하는 인접행렬
    static boolean[] sel; // 각 선거구가 True 팀인지 False 팀인지 구분
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        voters = new int[N+1];
        sel = new boolean[N+1];
        for(int i = 1; i <= N; i++)
            voters[i] = sc.nextInt();
        adj = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            int cnt = sc.nextInt();
            for(int j = 0; j < cnt; j++)
                adj[i][sc.nextInt()] = 1;
        }
        powerSet(1);
        System.out.println(ans == 987654321 ? -1 : ans);
    }
    static int ans = 987654321;
    static void powerSet(int idx) {
        if(idx == N+1) {
            if( check() ) {
                int sumT = 0;
                int sumF = 0;
                for(int i = 1; i <= N; i++){
                    if(sel[i])
                        sumT += voters[i];
                    else
                        sumF += voters[i];
                }
                ans = Math.min(ans, Math.abs(sumT - sumF));
            }
            return;
        }
        sel[idx] = true;
        powerSet(idx+1);
        sel[idx] = false;
        powerSet(idx+1);
    }
    static boolean check() {
        boolean[] visited = new boolean[N+1];
        //큐에 true편 아무거나 하나 넣고 BFS 고
        //큐에 false편 아무거나 하나 넣고 BFS 고
         
        int teamTrue = -1;
        int teamFalse = -1;
        //true로 배정된 첫번째 놈을 찾으면 break
        for(int i = 1; i <= N; i++) {
            if( sel[i] ) {
                teamTrue = i;
                break;
            }
        }
        //false로 배정된 첫번째 놈을 찾으면 break
        for(int i = 1; i <= N; i++) {
            if( !sel[i] ) {
                teamFalse = i;
                break;
            }
        }
        //둘중 한팀이 하나도 존재하지 않는다면 잘못된 팀배정
        if( teamTrue == -1 || teamFalse == -1)
            return false;
        Queue<Integer> queue = new LinkedList<>();
        //true팀 탐색
        queue.add(teamTrue);
        visited[teamTrue] = true;
        while( !queue.isEmpty() ) {
            int node = queue.poll();
            for(int i = 1; i <= N; i++) {
                //true팀 이면서,  경록가 존재하고 ,     아직 방문하지 않았다면
                if( sel[i] && adj[node][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        //false팀 탐색
        queue.add(teamFalse);
        visited[teamFalse] = true;
        while( !queue.isEmpty() ) {
            int node = queue.poll();
            for(int i = 1; i <= N; i++) {
                //false팀 이면서,  경록가 존재하고 ,     아직 방문하지 않았다면
                if( !sel[i] && adj[node][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        //한 선거구 라도 방문을 못했다면, 연결이 다 되있지 않은 상태이므로 return false;
        for(int i = 1; i <= N; i++) {
            if(!visited[i])
                return false;
        }
        return true;
    }
}