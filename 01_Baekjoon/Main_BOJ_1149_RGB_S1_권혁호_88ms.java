/**
 * Algorithm2 02. BOJ 1149, RGB, S1
 * @java Main_BOJ_1149_RGB_S1_권혁호_88ms.java
 * @author 권혁호
 * @since 2022.03.31
 * @url https://www.acmicpc.net/problem/1149
 * 
 * 분류 : DP
 * 
 * 참고
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1149_RGB_S1_권혁호_88ms {
	
	public static void main(String[] args) thro

		BufferedReader br = new BufferedReader(new InputStreamReader(System.i

		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		// 집의 수

		
		int[][] house = new int[N+1][3];

		  
		for (int i = 1; i <=  N ; i++)

			st = new StringTokenizer(br.r

			house[i][0] = Integer.parseInt(st.nextToken()

			house[i][2] = Integer.parseInt(st.nextToken());
			
			

			

		// }
				 
				 r

			d[i][0] = Math.min(d[-1][1], 

			d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + house[i][2];
			    
		}    

			

				 stem.out.println(Math.min( Math.min(d[N][0], d[N][1]), d[N][

		

	
