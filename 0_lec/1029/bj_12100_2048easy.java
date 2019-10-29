import java.util.Scanner;

public class bj_12100_2048easy {
	static int N;
	static int[][] map;

	static int ans;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		ans = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				ans = Math.max(ans, map[i][j]);
			}
		}

		//조합해서 넣는다.
		int[] arr = {0,1,2,3};

		
		perm(arr, new int[5], 0);
		
//		for (int n = 0; n < 4; n++) {
//			sum(n);
//		}
		System.out.println(ans);
	}// end main

	
	static void perm(int[] arr, int[] sel, int idx) {
		if(idx == sel.length) {
			
			for(int i=0; i<sel.length; i++) {
				sum(sel[i]);
			}
			
			
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			sel[idx] = arr[i];
			perm(arr, sel, idx+1);
		}
	}
	
	static void move(int command) {
		int index;
		if (command == 0) {
			for (int j = 0; j < N; j++) {
				for (int i = 1; i < N; i++) {
					if (map[i][j] != 0) {
						index = -1;
						for (int k = i - 1; k >= 0; k--) {
							if (map[k][j] != 0) {
								break;
							}
							index = k;
						}
						if (index != -1) {
							map[index][j] = map[i][j];
							map[i][j] = 0;
						}
					}
				}
			}
		} else if (command == 1) {
			for (int j = 0; j < N; j++) {
				for (int i = N - 2; i >= 0; i--) {
					if (map[i][j] != 0) {
						index = -1;
						for (int k = i + 1; k < N; k++) {
							if (map[k][j] != 0) {
								break;
							}
							index = k;
						}
						if (index != -1) {
							map[index][j] = map[i][j];
							map[i][j] = 0;
						}
					}
				}
			}
		} else if (command == 2) {
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < N; j++) {
					if (map[i][j] != 0) {
						index = -1;
						for (int k = j - 1; k >= 0; k--) {
							if (map[i][k] != 0) {
								break;
							}
							index = k;
						}
						if (index != -1) {
							map[i][index] = map[i][j];
							map[i][j] = 0;
						}
					}
				}
			}
		} else if (command == 3) {
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (map[i][j] != 0) {
						index = -1;
						for (int k = j + 1; k < N; k++) {
							if (map[i][k] != 0) {
								break;
							}
							index = k;
						}
						if (index != -1) {
							map[i][index] = map[i][j];
							map[i][j] = 0;
						}
					}
				}
			}
		}

	}

	static void sum(int command) {
		if (command == 0) {
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N - 1; i++) {
					if (map[i][j] != 0) {
						for (int k = i + 1; k < N; k++) {
							if (map[k][j] != 0) {
								if (map[i][j] == map[k][j]) {
									map[i][j] *= 2;
									ans = Math.max(ans, map[i][j]);
									
									map[k][j] = 0;
								}
								break;
							}
						}
					}
				}
			}
		} else if (command == 1) {
			for (int j = 0; j < N; j++) {
				for (int i = N - 1; i > 0; i--) {
					if (map[i][j] != 0) {
						for (int k = i - 1; k >= 0; k--) {
							if (map[k][j] != 0) {
								if (map[i][j] == map[k][j]) {
									map[i][j] *= 2;
									ans = Math.max(ans, map[i][j]);

									map[k][j] = 0;
								}
								break;
							}
						}
					}
				}
			}
		} else if (command == 2) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1; j++) {
					if (map[i][j] != 0) {
						for (int k = j + 1; k < N; k++) {
							if (map[i][k] != 0) {
								if (map[i][j] == map[i][k]) {
									map[i][j] *= 2;
									ans = Math.max(ans, map[i][j]);

									map[i][k] = 0;
								}
								break;
							}
						}
					}
				}
			}
		} else if (command == 3) {
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j > 0; j--) {
					if (map[i][j] != 0) {
						for (int k = j - 1; k >= 0; k--) {
							if (map[i][k] != 0) {
								if (map[i][j] == map[i][k]) {
									map[i][j] *= 2;
									ans = Math.max(ans, map[i][j]);

									map[i][k] = 0;
								}
								break;
							}
						}
					}
				}
			}
		}
		move(command);
	}
}