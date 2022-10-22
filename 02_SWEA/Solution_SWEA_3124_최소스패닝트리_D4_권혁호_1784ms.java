/**
 * Algorithm2 01. SWEA 3124, 최소 스패닝 트리, D4
 * @java Solution_SWEA_3124_최소스패닝트리_D4_권혁호_1784ms.java
 * @author 권혁호
 * @since 2022.03.30
 * @url https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb
 * 
 * 분류 : MST알고리즘, 최소신장트리
 * 
 * 참고
 * @url https://lu-coding.tistory.com/92
 * @url https://velog.io/@fldfls/%EC%B5%9C%EC%86%8C-%EC%8B%A0%EC%9E%A5-%ED%8A%B8%EB%A6%AC-MST-%ED%81%AC%EB%A3%A8%EC%8A%A4%EC%B9%BC-%ED%94%84%EB%A6%BC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 * 크루스칼은 간선 위주의 알고리즘, 프림은 정점 위주의 알고리즘
 * 간선의 개수가 적은 경우에는 크루스칼, 
 * 간선의 개수가 많은 경우에는 프림을 사용하는게 효율적
 * 
 * 프림은 사이클 검사가 필요 없음
 * 
 * 크루스칼 Union-Find 알고리즘으로 품
 * 프림 알고리즘, 크루스칼 Disjoint Set으로도 풀어보기!
 * ※ 백준에서 에러남 확인해보기 백준 1197
 */

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_SWEA_3124_최소스패닝트리_D4_권혁호_1784ms {
	
	
	private static int[] parent;

	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testCase; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			// 정점의 수
			int V = Integer.parseInt(st.nextToken());
			
			// 간선의 수
			int E = Integer.parseInt(st.nextToken());
			
			// 출발지, 목적지, 가중치
			int[][] map = new int[E][3];
			
			parent = new int[V+1];
			
			// 간선의 수 만큼
			for (int i = 0; i < E; i++) {
				
				st = new StringTokenizer(br.readLine(), " ");
				
				map[i][0] = Integer.parseInt(st.nextToken());
				
				map[i][1] = Integer.parseInt(st.nextToken());
				
				map[i][2] = Integer.parseInt(st.nextToken());
					
			}
			
			
			
			Arrays.sort(map, new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					int i = a[2] - b[2];
					return i;
				}
			});
//			for (int i = 0; i < map.length; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			int cnt = 0;
			long sol = 0;
			
			for (int i = 0; i < E; i++) {
				
				boolean uni = union(map[i][0], map[i][1]);
				
				if(uni) {
					sol += map[i][2];
					cnt++;
				}
				if(cnt==V-1){
					break;
				}
				
			}
			
			sb.append("#").append(tc).append(" ").append(sol).append("\n");
//			sb.append(sol);
			
		}
		System.out.println(sb);
		
		
		
		
		
		
	}
	
	private static boolean union(int a, int b) {
//		System.out.println(a + " " + b);
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot) {
			parent[bRoot] = aRoot;
			return true;
		}
		
		return false;
		
		
	}
	
	private static int find(int a) {
//		System.out.println(a);
		if( parent[a] <= 0) {
			return a;			
		}
		else {
			return (parent[a] = find(parent[a]));
		}
		
	}
	
	

}
