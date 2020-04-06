import java.util.Stack;

public class Sol2 {
	public static void main(String[] args) {	
		
	}
	
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<moves.length; i++) {
			for(int j=0; j<board.length; j++) {
				/*
				 * 해당 칸에 인형이 존재하는 경우 
				 * 아래로 내려가므로, 행의 값이 바뀌어야 한다. (0,0), (1,0), (2,0) ...
				 * moves 배열에 있는 요소를 board[][]배열의 '열' 값에 넣어서 비교한다.
				 * 배열의 인덱스는 0부터 시작하므로 -1
				 */
				if(board[j][moves[i]-1] != 0) {
					
					//스택이 비어있는 경우 -> 해당 인형을 넣는다.
					if(stack.isEmpty())
						stack.push(board[j][moves[i]-1]);
					//스택이 비어있지 않은 경우 -> 인형이 동일한지 아닌지 비교를한다.
					else {
						//인형이 동일하면 제거 후 사라진 인형개수 +2
						if(stack.peek()==board[j][moves[i]-1]) {
							stack.pop();
							answer +=2;
						}
						else {
							stack.push(board[j][moves[i]-1]);
						}
					}
					// 해당 작업 후에는 인형을 빼넀으므로 0으로 만든다.(인형이 없다는 표시)
					board[j][moves[i]-1]=0;
					break;
				}
			}
		}
		return answer;
	}
}
