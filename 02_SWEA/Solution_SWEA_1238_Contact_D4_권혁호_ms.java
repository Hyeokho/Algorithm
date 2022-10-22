/**
 * Algorithm 13. SWEA 1238, Contact, D4
 * @java Solution_SWEA_1238_Contact_D4_권혁호_ms.java
 * @author 권혁호
 * @since 2022.02.21
 * @url https://www.acmicpc.net/problem/2606
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 
 * 깊이 1 : 2
 * 
 * 깊이 2 : 7, 15
 * 
 * 깊이 3 : 4, 1
 * 
 * 깊이 4 : 10, 17, 8 
 * 
 */

class Solution_SWEA_1238_Contact_D4_권혁호_ms {
	


	private static boolean[][] graph;
	private static int dataStart;
	private static int sol;


	private static void bfs() {
		
		//
		Queue<Integer> queue = new LinkedList<Integer>();
		
		boolean[] isVisited = new boolean[101];
		
		// 
		queue.offer(dataStart);
		
		// 방문체크 
		isVisited[dataStart] = true;
		
		// 최대값 초기화
		int max = -1;
		
		// 
		while (!queue.isEmpty()) {
			
			int size = queue.size();
			
			max = -1;

			for (int s = 0; s < size; s++) {
				
				// 현재 위치
				int current = queue.poll();
				 
				// 현재 방문한 곳이 더 높으면 최대값 업데이트
				if( max < current ) {
					max = current;
				}
				
				
				// 이번에 방문한 곳과 연결된 곳 전부 탐색
				for (int i = 1; i < graph[current].length; i++) {
					
					// 이곳에서 방문 가능하고 이전에 방문한 적이 없으면
					if (graph[current][i] && !isVisited[i]) {
						
						// 다음 방문할곳 큐에 저장
						queue.offer(i);
//						System.out.println(queue.toString());
						
						// 다음 방문 체크
						isVisited[i] = true;
					}
				}

			}
			
			// 최대 값 없데이트
			sol = max;
		}
		
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int dataLenth = Integer.parseInt(st.nextToken());
			dataStart = Integer.parseInt(st.nextToken());
			
			// 인접행렬
			// 인원이 1~100명
			graph = new boolean[101][101];
			
			
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < dataLenth/2; i++) {
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph[from][to] = true;
				
			}
			
			bfs();
			sb.append('#').append(testCase).append(' ').append(sol).append('\n');
			
			
		}
		
		System.out.println(sb);
		
		
	}


}
