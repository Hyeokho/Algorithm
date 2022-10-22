/**
 * Algorithm2 07. SWEA 1953, 탈주범 검거
 * @java Solution_SWEA_1953_탈주범검거_권혁호_134ms.java
 * @author 권혁호
 * @since 2022.04.07
 * @url https://swexpertacademy.com/main/code/problem/problemSubmitHistory.do?contestProbId=AV5PpLlKAQ4DFAUq
 * 
 * 분류 : 구현 시뮬레이션, BFS
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1953_탈주범검거_권혁호_134ms {
	
	// 상 = 0, 하 = 1, 좌 = 2, 우 = 3
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	// 터널 구조물 타입
	// 1 = 상하좌우, 2=상하, 3=좌우, 4=상우, 5=하우, 6=하좌, 6=상좌
	private static int[][] tunnel= { {},
			{ 0, 1, 2, 3 },
			{ 0, 1 }, 
			{ 2, 3 }, 
			{ 0, 3 }, 
			{ 1, 3 }, 
			{ 1, 2 }, 
			{ 0, 2 }};
	private static boolean[][] isVisted;
	private static int[][] map;
	private static int L;
	private static int N;
	private static int M;
	private static int cnt;
	private static int R;
	private static int C;
	
	
	private static class Pos {
		
		int x;
		int y;
		
		public Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws Exception, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int x = 1; x <= T; x++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			// 맵 크기
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// 맨홀 위치
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			cnt = 0;
			
			map = new int[N][M];
			isVisted = new boolean[N][M];
			
			
			for (int i = 0; i < N; i++) {
								
				st = new StringTokenizer(br.readLine(), " ");
				
				for (int j = 0; j < M; j++) {
					
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
				
			}
			
//			for (int i = 0; i < map.length; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			
			bfs(R, C);
			
//			for (int i = 0; i < map.length; i++) {
//				System.out.println(Arrays.toString(isVisted[i]));
//			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					if (isVisted[i][j]) {
//						cnt++;
//						
//					}
//					
//				}
//			}
			
			sb.append("#").append(x).append(" ").append(cnt).append("\n");
			
			
			
			
			
		}
		
		System.out.print(sb);
		
		
	}
	
	private static void bfs(int r, int c) {
		
		// 방문체크
		isVisted[r][c] = true;
		cnt++;
		
		Queue<Pos> queue = new LinkedList<Pos>();
		
		queue.add(new Pos(r,c));
		
		for (int i = 1; i < L; i++) {
			
			int sizeQueue = queue.size();
			
//			while(!queue.isEmpty()) {
			for (int a = 0; a < sizeQueue; a++) {
			
				// 현재 위치
				Pos cur = queue.poll();
				
//				System.out.println("현위치 " + cur.x + " " + cur.y);
				
//				System.out.println(map[cur.x][cur.y]);
				
//				System.out.println(tunnel[map[cur.x][cur.y]].length);
				
				for (int j = 0; j < tunnel[map[cur.x][cur.y]].length; j++) {
					
					// next row
					int nr = cur.x + dr[tunnel[map[cur.x][cur.y]][j]];
					int nc = cur.y + dc[tunnel[map[cur.x][cur.y]][j]];
					
					
//					System.out.print("다음");
//					System.out.println(tunnel[map[cur.x][cur.y]][j]);
					
					// 범위 밖이면 pass
					if( nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					
					// 다음 위치에 터널이 없으면 pass
					if( map[nr][nc] == 0 ) continue;
					
					// 다음 위치를 방문한 적이 있으면 pass
					if( isVisted[nr][nc] == true ) continue;
					
					
					int way = tunnel[map[cur.x][cur.y]][j];
					// 현재 0이면 다음 1
					// 현재 1이면 다음 0
					// 현재 2이면 다음 3
					// 현재 3이면 다음 2 가 있어야 함
					// next way
					int nWay = way % 2 == 0 ? way + 1 : way - 1;
					boolean connect = false;
					
					for (int k = 0; k < tunnel[map[nr][nc]].length; k++) {
						if(tunnel[map[nr][nc]][k] == nWay) {
							// 연결되어 있으면
							connect = true;
							break;
						}
						
					}
						
					
					if(connect) {
						
						queue.add(new Pos(nr, nc));
//						System.out.println(nr + " "+  nc);
						
						isVisted[nr][nc] = true;
						cnt++;
					}
					
					
						
					
				}
				
				
			}
			
			

		}
		
	}

}
