package _1113;

import java.util.Scanner;

public class bj_16987_계란으로계란치기 {
	static class Egg {
		int life;
		int weight;

		public Egg() {
			this.life = 0;
			this.weight = 0;
		}

		public Egg(int l, int w) {
			this.life = l;
			this.weight = w;
		}
	}

	static int N;
	static boolean[] visited;
	static int left;
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Egg[] eggArr = new Egg[N];
		for(int i=0; i<N; i++) {
			eggArr[i] = new Egg(sc.nextInt(), sc.nextInt());
		}
		visited = new boolean[N];
		
		dfs(0, visited, 0, eggArr);
		
		System.out.println(ans);
	}// end main

	static void dfs(int idx, boolean[] visited, int c, Egg[] eggs) {
		// 모든 계란을 확인했으면 끝
		if (idx == N) {
			ans = Math.max(ans, c);
			return;
		}

		// 계란이 깨진거면 다음으로 넘어감
		if (visited[idx]) {
			dfs(idx + 1, visited, c, eggs);
		} 
		else {
			boolean noEgg = true;
			for (int i = 0; i < N; i++) {
				//칠 수 있는 계란이 존재한다면  False
				if (!visited[i])
					noEgg = false;
				
				//계란이 깨지지 안았고, 잡고있는 계란이 아니라면 
				if (!visited[i] && i != idx) {
					// 잡고있는 계란의 내구도 감소
					eggs[idx].life -= eggs[i].weight;
					// 타겟 계란의 내구도 감소
					eggs[i].life -= eggs[idx].weight;
					
					
					int brokenEggs = 0;
					// 잡고있던 계란 상태 확인
					if (eggs[idx].life <= 0) {
						visited[idx] = true;
						brokenEggs++;
					}
					// 타겟 계란 상태 확인
					if (eggs[i].life <= 0) {
						visited[i] = true;
						brokenEggs++;
					}
					
					// 쳐서 보낸다음에 다시 원상복귀 - 백 트래킹
					dfs(idx + 1, visited, c + brokenEggs, eggs);
					
					if (eggs[idx].life <= 0) {
						visited[idx] = false;
					}
					if (eggs[i].life <= 0) {
						visited[i] = false;
					}
					// 쳐보기 전으로 되돌리자
					eggs[idx].life += eggs[i].weight;
					eggs[i].life += eggs[idx].weight;
				}
			}
			//칠수있는 계란이 없음. 다시 재귀 돌리면 기저조건으로 보내서 끝냄.
			if (!noEgg)
				dfs(N, visited, c, eggs);
		}
	}

}