/**
 * Algorithm 16. JUNGOL 1681, 해밀턴 순환회로, IM
 * @java Main_JUNGOL_1681_해밀턴순환회로_IM_권혁호_2205ms.java
 * @author 권혁호
 * @since 2022.02.25
 * @url http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=954&sca=3030
 * 
 * 분류 : dfs, 백트래킹
 * 
 * 시간 줄일 수 있는 방법 찾아서 다시 해보기
 * 클래스 안쓰고 인접매트릭스?..
 * 
 * 참고
 * @url
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_JUNGOL_1681_해밀턴순환회로_IM_권혁호_2205ms {
	
	// 노드 클래스 정의
	static class Node {
		
		int node;
		
		/** 가중치 */
		int wegiht;

		public Node(int node, int wegiht) {
			super();
			this.node = node;
			this.wegiht = wegiht;
		}
		
	}
	
	// 
	private static void dfs(int depth, int current, int cost) {
		
		// 가지치기 해야 시간초과 안남
		if(cost >= min) {
			return;
		}
		
		if( current == 0 && depth == N ) {
			if(min > cost) {
				min = cost;
			}
			return;
		}
		
		
		
		// 범위 조심
		// 비용이 0인 노드는 추가하지 않았음
		for (int i = 0; i < adjList[current].size(); i++) {
			
			Node next = adjList[current].get(i);
			
			if(!isVisted[next.node]) {
				
				isVisted[next.node] = true;
				
				dfs(depth+1, next.node, cost+next.wegiht);
				
				isVisted[next.node] = false;
				
				
			}
			
		}
		
	}



	private static ArrayList<Node>[] adjList;
	private static boolean[] isVisted;
	private static int N;
	private static int min;
	
	
	
	public static void main(String[] args) throws Exception, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine());
		
		// 인접리스트로 관리
		adjList = new ArrayList[N];
		isVisted = new boolean[N];
		
		
		// 노드 추가
		for (int i = 0; i < N; i++) {
			
			adjList[i] = new ArrayList<Node>();
			
		}
		
		// 입력 처리
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < N; j++) {
				
				int cost = Integer.parseInt(st.nextToken());
				
				// 비용 0인 노드는 처리 x
				if(cost == 0) continue;
				
				adjList[i].add(new Node(j, cost));
				
			} 
		}
		
		min = Integer.MAX_VALUE;
		
		dfs(0,0,0);
		
		System.out.println(min);
		
		
	}



}
