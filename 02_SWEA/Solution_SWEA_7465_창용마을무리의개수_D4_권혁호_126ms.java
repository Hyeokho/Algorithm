/**
 * Algorithm 14. SWEA 7465, 창용 마을 무리의 개수, D4
 * @java Solution_SWEA_7465_창용마을무리의개수_D4_권혁호_126ms.java
 * @author 권혁호
 * @since 2022.02.22
 * @url https://swexpertacademy.com/main/code/problem/problemSolver.do?contestProbId=AWngfZVa9XwDFAQU
 * 
 * 분류 : union-find
 * 
 * 참고
 * @url
 * 
 */

package com.ssafy.day14.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_7465_창용마을무리의개수_D4_권혁호_126ms {
	
	private static int[] rprsn;
	private static int[] rank;
	private static int sol=0;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			/** 대표자 */
			rprsn = new int[N+1];
						
			/** 깊이 지정 */
			rank = new int[N+1];
			
			// 유일한 멤버 x를 포함하는 새로운 집합 생성
			for(int x = 1; x <= N; x++) {
				makeSet(x);
			}
			
			// 합치기
			for (int i = 0; i < M; i++) {
				
				st = new StringTokenizer(br.readLine(), " ");

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
				
			}
			
			for (int i = 1; i <= N; i++) {
				
				if (rprsn[i] == i) {
					sol++;
					
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(sol).append("\n");
			
			sol=0;

		}
		
		System.out.println(sb);
		
	}
	

	// rprsn = representative
	public static void makeSet(int x) {
		rprsn[x] = x; // 대표자를 자신의 index로 표기
		rank[x] = 0; // 깊이 
	}
	
	/** 일반멤버 x를 포함하는 집합의 대표자 index 를 리턴 */
	public static int findSet(int x) {
		
		if(rprsn[x] == x) {
			
			return x;
			
		} else {
			
			rprsn[x] = findSet(rprsn[x]); // Path Compression
			
			return rprsn[x];			
			
		}
	}
	
	/** 일반 멤버 x, 일반 멤버 y를 포함하는 두 집합을 합침 
	 * 깊은 쪽을 대표자로 설정하기 위해 rank 사용*/
	public static void union(int x, int y) {
		
		int rprsnX = findSet(x);
		int rprsnY = findSet(y);
		
		 // 다른 집합일 때만 합치기
		if(rprsnX != rprsnY) {
			
			// 랭크 값이 더 깊은 값을 대표자로 설정
			if(rank[rprsnX] > rank[rprsnY]) {
				// x의 랭크가 더 깊으면
				rprsn[rprsnY] = rprsnX;
				
			} else {
				
				// y의 랭크가 더 깊으면
				rprsn[rprsnX] = rprsnY;
				
				// 깊이가 같은 경우 깊이 증가
				if(rank[rprsnX] == rank[rprsnY]) { 
					rank[rprsnY]++;
				}
			}
		}
	}

}
