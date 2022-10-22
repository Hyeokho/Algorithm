/**
 * Algorithm2 06. SWEA 5643, 키 순서, D4
 * @java Solution_SWEA_5643_키순서_D4_권혁호_3721ms.java
 * @author 권혁호
 * @since 2022.04.06
 * @url https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo&
 * 
 * 분류 : 구현 시뮬레이션?
 * 
 * 참고
 * @url https://data-make.tistory.com/568
 * 유형별로 잘 정리되어 있음
 * 
 * 같은 문제
 * @url https://www.acmicpc.net/problem/2458
 *  
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 학생수가 N 명일때 자기보다 크거나 작은 친구가 N-1명이면 순서를 알 수 있다.

public class Solution_SWEA_5643_키순서_D4_권혁호_3721ms {
	
	// 학생 수
	private static int N;
	private static int M;
	private static int low;
	private static int high;
	private static int cnt;
	private static int sol;
	private static int T;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int TC = 1; TC <= T; TC++) {
			
			// 학생들의 수 N (2 ≤ N ≤ 500)
			// 정점 수
			N = Integer.parseInt(br.readLine());
			
			// 비교한 횟수 M (0 ≤ M ≤ N(N-1)/2)
			// 간선 수
			M = Integer.parseInt(br.readLine());
			
			
			// 인접행렬
			int[][] adj = new int[N+1][N+1];
			
			// 방문 체크 배열
			boolean[] isVisited;
			
			
			// 행 기준 더 작은쪽
			// 열 기준 더 큰쪽
			for (int i = 0; i < M; i++) {
				
				st = new StringTokenizer(br.readLine(), " ");
				
				low = Integer.parseInt(st.nextToken());
				high = Integer.parseInt(st.nextToken());
				
				adj[low][high] = 1;
				
			}
			
			// 출력 체크
//		for (int i = 0; i < adj.length; i++) {
//			System.out.println(Arrays.toString(adj[i]));
//		}
			
			
			// 모드, 기준, 전체 그래프, 방문체크 배열
			for (int i = 1; i <= N; i++) {
				
				// 카운트 변수 초기화
				cnt = 0;
				
				// 자신보다 키가 큰 친구 확인
				isVisited = new boolean[N+1];
				dfs("high", i, adj, isVisited);
				
				// 자신보다 키가 작은 친구 확인
				isVisited = new boolean[N+1];
				dfs("low", i, adj, isVisited);
				
				// 자신보다 키가 크거나 작은 친구의 숫자가
				// 전체 인원 보다 1작으면 본인의 순서를 알 수 있음
				if( cnt == (N-1) ) {
					sol++;
				}
			}
			
			sb.append("#").append(TC).append(" ").append(sol).append("\n");
			sol = 0;
		}
		
		System.out.println(sb);
		
		

		
		
	}
	
	// 기준보다 높은 친구를 찾을 건지
	// 낮은 친구를 찾을 건지
	private static void dfs(String mode, int i, int[][] adj, boolean[] isVisited) {
		
		isVisited[i] = true;
		
		for (int j = 1; j <= N; j++) {
			
			if(mode.equals("high")) {
				
				// 기준보다 크고 방문한적이 없으면
				if( adj[i][j] == 1 && !isVisited[j] ) {
					
//					System.out.println(j);
					cnt++;
					dfs("high", j, adj, isVisited );
				}
			} else if(mode.equals("low")) {
				
				// 기준보다 작고 방문한적이 없으면
				if( adj[j][i] == 1 && !isVisited[j] ) {
					
//					System.out.println(j);
					cnt++;
					dfs("low", j, adj, isVisited );
				}
				
			}
			
		}
		
	}

}
