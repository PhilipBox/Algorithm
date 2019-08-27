package _solving;

import java.util.Scanner;

public class d3_1873_상호의배틀필드 {
	static char[][] map;
	static int posR;
	static int posC;
	static int dir;

	static int R;
	static int C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			R = sc.nextInt();
			C = sc.nextInt();
			map = new char[R][C];

			// 필드 입력
			for (int i = 0; i < R; i++) {
				String s = sc.next();
				for (int j = 0; j < C; j++) {

					// 처음 시작 좌표 get
					switch (s.charAt(j)) {
					case '^':
						posR = i;
						posC = j;
						dir = 1;
						break;

					case 'v':
						posR = i;
						posC = j;
						dir = 2;
						break;
					case '<':
						posR = i;
						posC = j;
						dir = 3;
						break;
					case '>':
						posR = i;
						posC = j;
						dir = 4;
						break;
					}
					map[i][j] = s.charAt(j);
				}
			}
			map[posR][posC]='.';
			// 명령어 개수
			int N = sc.nextInt();

			// 명령어
			String cmd = sc.next();

			// 행동개시
			for (int i = 0; i < cmd.length(); i++) {
				action(cmd.charAt(i));
			}
			
			switch(dir) {
				case 1:
					map[posR][posC] = '^';
					break;
				case 2:
					map[posR][posC] = 'v';
					break;
				case 3:
					map[posR][posC] = '<';
					break;
				case 4:
					map[posR][posC] = '>';
					break;
			}
			System.out.print("#"+tc+" ");
			printMAP();
		} // end test cases
	}// end main

	// 맵 map
	// posR, posC
	// 상하좌우 1234
	static void printMAP() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	static void action(char c) {
		/*
		 * 문자 의미 . 평지(전차가 들어갈 수 있다.) 벽돌로 만들어진 벽 # 강철로 만들어진 벽 - 물(전차는 들어갈 수 없다.)
		 */
		switch (c) {
		case 'U':
			// 배열범위 체크
			dir = 1;
			if (posR - 1 < 0)
				return;
			else {
				if (map[posR - 1][posC] == '.') {
					posR = posR-1;
				} else {
					return;
				}
			}
			break;
		case 'D':
			// 배열범위 체크
			dir = 2;
			if (posR + 1 >= R)
				return;
			else {
				if (map[posR + 1][posC] == '.') {
					posR = posR+1;
				} else
					return;
			}
			break;
		case 'L':
			// 배열범위 체크
			dir = 3;
			if (posC - 1 < 0)
				return;
			else {
				if (map[posR][posC - 1] == '.') {
					posC =posC-1;
				} else
					return;
			}
			break;
		case 'R':
			// 배열범위 체크
			dir = 4;
			if (posC + 1 >= C) {
				return;
			}
			else {
				if (map[posR][posC + 1] == '.') {
					posC = posC+ 1;
				} else
					return;
			}
			break;
		case 'S':
			// 방향
			// 강철만나면 return
			// 벽만나면 평지로 만들고 return
			switch (dir) {
			case 1:
				for (int i = posR - 1; i >= 0; i--) {
					// 강철 만나면 바로 종료
					if (map[i][posC] == '#')
						return;
					// 벽 만나면 평지로 바꿔
					else if (map[i][posC] == '*') {
						map[i][posC] = '.';
						return;
					}
				}
				break;
			case 2:
				for (int i = posR + 1; i < R; i++) {
					// 강철 만나면 바로 종료
					if (map[i][posC] == '#')
						return;
					// 벽 만나면 평지로 바꿔
					else if (map[i][posC] == '*') {
						map[i][posC] = '.';
						return;
					}
				}
				break;
			case 3:
				for (int i = posC - 1; i >= 0; i--) {
					// 강철 만나면 바로 종료
					if (map[posR][i] == '#')
						return;
					// 벽 만나면 평지로 바꿔
					else if (map[posR][i] == '*') {
						map[posR][i] = '.';
						return;
					}
				}
				break;
			case 4:
				for (int i = posC + 1; i < C; i++) {
					// 강철 만나면 바로 종료
					if (map[posR][i] == '#')
						return;
					// 벽 만나면 평지로 바꿔
					else if (map[posR][i] == '*') {
						map[posR][i] = '.';
						return;
					}
				}
				break;
			}
			break;
		}// end switch
	}// end action method
}
