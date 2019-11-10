import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_2382_미생물격리 {
	static class State {
		boolean state;
		Queue<Integer> mlist;

		public State() {
			this.state = false;
			this.mlist = new LinkedList<Integer>();
		}
		
		public State(boolean s, Queue<Integer> mlist) {
			this.state = s;
			this.mlist = mlist;
		}
	}

	static class Micro {
		int r, c;
		int dir;
		int num;

		public Micro(int r, int c, int num, int dir) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.dir = dir;
		}
	}

	static State[][] map;
	static State[][] temp;
	static Micro[] micro;
	static int dr[] = { 0, -1, 1, 0, 0 };
	static int dc[] = { 0, 0, 0, -1, 1 };
	static int N;
	static int M;
	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// 맵의 크기
			M = sc.nextInt();// 격리시간
			K = sc.nextInt();// 미생물의 수
			map = new State[N][N];
			temp = new State[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = new State();
					temp[i][j] = new State();
				}
			}

			micro = new Micro[K];
			// 미생물의 정보를 미생물 배열에 담고, 그 정보를 map에 바로 표시해준다.
			// map의 state가 true면 미생물이 있는거고, false면 없는 것.
			// map의 mlist에는 현재 위치한 미생물의 index가 arraylist형태로 add되어있다.
			for (int i = 0; i < K; i++) {
				micro[i] = new Micro(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
				map[micro[i].r][micro[i].c].state = true;
				map[micro[i].r][micro[i].c].mlist.add(i);
			}
			int total=0;
			for (int t = 0; t < M; t++) {
				// 이동시키기
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						// 미생물이 없다는 것. pass
						if (!map[i][j].state)
							continue;
						else {
							// 미생물이 있다면.
							while (!map[i][j].mlist.isEmpty()) {
								int Mnum = map[i][j].mlist.poll();
								// 뽑은 미생물의 이동 방향.
								int Mdir = micro[Mnum].dir;
								// 뽑은 미생물의 다음 이동할 위치.
								int nr = micro[Mnum].r + dr[Mdir];
								int nc = micro[Mnum].c + dc[Mdir];
								// nr이니 nc에 둘중 하나라도,0이 있다면 약품처리가 된 곳이므로
								// 절반으로 처리해주고. 그 약품 위치로 넣어준다. 방향도 반대로 해준다.
								if (nr == 0 || nc == 0|| nr == N-1 || nc == N-1) {
									micro[Mnum].num /= 2;
									micro[Mnum].dir = reverseDir(Mdir);
								}
								// 미생물의 옮겨진 좌표도 업데이트.
								micro[Mnum].r = nr;
								micro[Mnum].c = nc;
								// 새로운 map에 true처리를 해주고.
								temp[nr][nc].state = true;
								// queue에 add해준다 (queue에는 미생물의 번호만 들어가므로, 직접적인 위치는 micro에서 변경해줘야함)
								temp[nr][nc].mlist.add(Mnum);
							} // end while loop
							// 다 뽑았으니까. map[i][j]의 mlist는 비어있는 상태.
							map[i][j].state = false;
						}//end else
					}
				}// end i,j loop
				// 모든 미생물들이 각자의 방향에서 
				// temp에서 합치기 작업하기.
				// 합치고 난 뒤에 temp를 map으로 바꿔주기.
				total = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (temp[i][j].state) {
							if (temp[i][j].mlist.size() >= 2) {
								int maxNum = 0;
								int maxIdx = -1;
								int sum=0;
								for (Integer e : temp[i][j].mlist) {
									if(micro[e].num > maxNum) {
										maxNum = micro[e].num;
										maxIdx = e;
									}
									sum += micro[e].num;
								}
								micro[maxIdx].num = sum;
								temp[i][j].mlist.clear();
								temp[i][j].mlist.add(maxIdx);
							}
							map[i][j].state = temp[i][j].state;
							map[i][j].mlist.clear();
							for(Integer e : temp[i][j].mlist) {
								map[i][j].mlist.add(e);
								total += micro[e].num;
							}
							//옮겨주고 지우기
							temp[i][j].state = false;
							temp[i][j].mlist.clear();
						}
					}
				}
		
			
			}
			System.out.println("#"+tc+" "+total);
		} // end test cases
	}// end main

	static int reverseDir(int dir) {
		if (dir == 1) {
			return 2;
		} else if (dir == 2) {
			return 1;
		} else if (dir == 3) {
			return 4;
		} else if (dir == 4) {
			return 3;
		}
		return 0;
	}
}
