package com.ssafy.day04.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



// 전선길이 최소
// 코어어의 개수 1~12개



public class Solution_SWEA_1767 {
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int N;
	private static int[][] map;
	
	public static class Core {
		
		int x;
		int y;
		
		public Core(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Core [x=" + x + ", y=" + y + "]";
		}
		
		
	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			// 7 ≤  N ≤ 12
			N = Integer.parseInt(br.readLine());
			ArrayList<Core> listCore = new ArrayList<Core>();
			
			map = new int[N][N];
			boolean[][] islines = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				
				st = new StringTokenizer(br.readLine(), " ");
				
				for (int j = 0; j < N; j++) {
					
					map[i][j] = Integer.parseInt(st.nextToken( ));
					
					// 안쪽에 연결되어 있는 코어만 확인
					if( map[i][j] == 1 && 
							i != 0 && i != N-1 && 
							j != 0 && j != N-1 ) {
						
						listCore.add (new Core(i, j));

					}
					
				}
				
			}
			
			for (int i = 0; i < map.length; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			
			
			for (int i = 0; i < listCore.size(); i++) {
				
				System.out.println(listCore.toString());
				
			}
			
//			dfs();
			
			
			
			
		}
		

		
	}

	private static void dfs() {
		
		
		
		
		
		
	}
	
	// 해당 방향으로 선을 연결할 수 있는지 체크
	private static boolean enLines(Core c, int dir) {
		
		int row = c.x;
		int col = c.y;
		
		// 그 방향으로 계속 가보자
		while ( row + dr[dir] >= 0 && row + dr[dir] < N 
				&& col + dc[dir] >= 0 && col + dc[dir] < N  ) {
			
			// 가다가 코어를 만나거나 전선을 만나면 연결 못함
			if( map[row + dr[dir]][col + dc[dir]] > 0 ) {
				return false;
			}
			
			
		}
		
		return true;
		
	}
	
	
	
	
	
	
	

}
