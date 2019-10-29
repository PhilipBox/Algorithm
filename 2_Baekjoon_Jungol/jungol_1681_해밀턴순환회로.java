import java.util.Scanner;

public class 해밀턴순환회로 {

    static int min = Integer.MAX_VALUE;
    
    static int[][] arr;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][N];
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		arr[i][j] = sc.nextInt();
        	}
        }
        int start = 0;
        visited[start] = true;
        // 최소값 확인 
        move(visited, start, start, 0, 1);
        System.out.println(min);
    }//end main
    
    public static void move( boolean[] visited, int start, int location, int sum, int count) {
    	if(sum > min) return;
    	
        // 마지막 위치까지 도달 
        if(count == visited.length) {
            // 시작 위치로 돌아갈 수 있는지 확인한당
            if(arr[location][start] == 0)
                return;
            
            // 돌아가는 cost추가 후 min 확인
            sum += arr[location][start];
            min = Math.min(min, sum);
            return;
        }// 앙 기저띠
        
        for(int i = 0; i < visited.length; i++) {
            // 가지 않은 곳, 갈 수 있는 곳을 확인하면서 이동
            if(visited[i] == false && arr[location][i] != 0) {
                visited[i] = true;
                move(visited, start, i, sum + arr[location][i], count + 1);
                visited[i] = false;
            } 
        }
    }
}