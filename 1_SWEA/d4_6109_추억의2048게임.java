import java.util.Scanner;

public class Solution {
    static int N;
    static String command;
    static int[][] map;
    public static void main(String[] args) throws Exception{
    	Scanner sc = new Scanner(System.in);
    	
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            N = sc.nextInt();
            command = sc.next();
            map = new int[N][N];
            
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            sum();
            System.out.println("#"+tc);
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                	System.out.print(map[i][j]+" ");
                }System.out.println();
            }
        }//end test cases
    }//end main
    
    static void move() {
        int index;
        if(command.equals("up")) {
            for(int j=0; j<N; j++) {
                for(int i=1; i<N; i++) {
                    if(map[i][j] != 0) {
                        index = -1;
                        for(int k=i-1; k>=0; k--) {
                            if(map[k][j] != 0) {
                                break;
                            }
                            index = k;
                        }
                        if(index != -1) {
                            map[index][j] = map[i][j];
                            map[i][j] = 0;
                        }
                    }            
                }
            }
        }else if(command.equals("down")) {
            for(int j=0; j<N; j++) {
                for(int i=N-2; i>=0; i--) {
                    if(map[i][j] != 0) {
                        index = -1;
                        for(int k=i+1; k<N; k++) {
                            if(map[k][j] != 0) {
                                break;
                            }
                            index = k;
                        }
                        if(index != -1) {
                            map[index][j] = map[i][j];
                            map[i][j] = 0;
                        }
                    }
                }
            }
        }else if(command.equals("left")) {
            for(int i=0; i<N; i++) {
                for(int j=1; j<N; j++) {
                    if(map[i][j] != 0) {
                        index = -1;
                        for(int k=j-1; k>=0; k--) {
                            if(map[i][k] != 0) {
                                break;
                            }
                            index = k;
                        }
                        if(index != -1) {
                            map[i][index] = map[i][j];
                            map[i][j] = 0;
                        }
                    }                    
                }
            }
        }else if(command.equals("right")) {
            for(int i=0; i<N; i++) {
                for(int j=N-1; j>=0; j--) {
                    if(map[i][j] != 0) {
                        index = -1;
                        for(int k=j+1; k<N; k++) {
                            if(map[i][k] != 0) {
                                break;
                            }
                            index = k;
                        }
                        if(index != -1) {
                            map[i][index] = map[i][j];
                            map[i][j] = 0;
                        }
                    }                    
                }
            }
        }
        
    }
    
    static void sum() {
        if(command.equals("up")) {
            for(int j=0; j<N; j++) {
                for(int i=0; i<N-1; i++) {
                    if(map[i][j] != 0) {
                        for(int k=i+1; k<N; k++) {
                            if(map[k][j] != 0) {
                                if(map[i][j] == map[k][j]) {
                                    map[i][j] *= 2;
                                    map[k][j] = 0;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }else if(command.equals("down")) {
            for(int j=0; j<N; j++) {
                for(int i=N-1; i>0; i--) {
                    if(map[i][j] != 0) {
                        for(int k=i-1; k>=0; k--) {
                            if(map[k][j] != 0) {
                                if(map[i][j] == map[k][j]) {
                                    map[i][j] *= 2;
                                    map[k][j] = 0;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }else if(command.equals("left")) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N-1; j++) {
                    if(map[i][j] != 0) {
                        for(int k=j+1; k<N; k++) {
                            if(map[i][k] != 0) {
                                if(map[i][j] == map[i][k]) {
                                    map[i][j] *= 2;
                                    map[i][k] = 0;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }else if(command.equals("right")) {
            for(int i=0; i<N; i++) {
                for(int j=N-1; j>0; j--) {
                    if(map[i][j] != 0) {
                        for(int k=j-1; k>=0; k--) {
                            if(map[i][k] != 0) {
                                if(map[i][j] == map[i][k]) {
                                    map[i][j] *= 2;
                                    map[i][k] = 0;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        move();
    }
}