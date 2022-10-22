/**
 * Algorithm 08. BOJ 3040, 백설 공주와 일곱 난쟁이, B2
 * @java Main_BOJ_3040_백설 공주와 일곱 난쟁이_B2_권혁호_76ms.java
 * @author 권혁호
 * @since 2022.02.14
 * @url https://www.acmicpc.net/problem/3040
 * 
 *
 * 참고
 * @url 
 * 
 */

// 완전탐색, 조합 9C7
// 9C2로 해서 다시 해보기
// 합을 가지고 다니면서 넘겨주는 방식으로 구현해보기, 100넘으면 더 이상 하지 않기(가지치기)

package com.ssafy.day8.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main_BOJ_3040_백설공주와일곱난쟁이_B2_권혁호_76ms {
	
	
	private static int[] dwarf = new int[9];
	private static int[] sol = new int[7];
	
	private static StringBuilder sb = new StringBuilder();
	
	public static void comb(int cnt, int start) {
		
		// 일곱 난쟁이를 선택 했으면
		if(cnt == 7) {
			
			// 합 초기화
			int sum = 0 ;
			
			// 선택한 읽곱 난쟁이의 모자에 적힌 숫자 더하기 
			for (int i = 0; i < sol.length; i++) {	
				
				sum = sum + sol[i];
				
			}
			
			// 선택한 일곱 난쟁이가 맞으면 정답
			if(sum == 100) {
				
				for (int i = 0; i < 7; i++) {
					sb.append(sol[i]).append("\n");
				}
				
			}
			
			return;
		}
		
		// 난쟁이 선택
		for (int i = start; i < dwarf.length; i++) {
			
			sol[cnt] = dwarf[i];
			comb(cnt+1, i+1);
			
		}
	
	}
	
	public static void main(String[] args) throws Exception {
		

		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			
			dwarf[i] = Integer.parseInt(br.readLine());
			
		}
		
		comb(0, 0);
		
		System.out.println(sb);
	}

}
