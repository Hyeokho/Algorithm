/**
 * Algorithm 05. SWEA 1210, Ladder1, D4
 * @java Solution_SWEA_1210_Ladder1_D4_권혁호_154ms.java
 * @author 권혁호
 * @since 2022.02.09
 * @url https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh
 * 
 * 1. 가장 마지막 행에서 시작할 위치 "2" 를 찾는다.
 * 2. 왼쪽 경계가 아니고, 왼쪽으로 이동 가능하고, 이전에 위쪽이나 왼쪽으로 움직였는지 체크
 * 2-1. 왼쪽으로 이동, 이동 방향 갱신
 * 2-2. 2번이 불가능하면 3번으로 이동
 * 3. 오른쪽 경계가 아니고, 오른쪽으로 이동 가능하고, 이전에 위쪽이나 오른쪽으로 움직였는지 체크
 * 3-1. 오른쪽으로 이동, 이동 방향 갱신
 * 3-2. 3번이 불가능하면 4번으로 이동
 * 4. 위쪽 경계가 아니고, 위쪽으로 이동 가능한지 체크
 * 4-1. 위쪽으로 이동, 이동 방향 갱신
 * 5. 가장 위쪽으로 올 때까지 2~4번 반복
 *  
 * 참고
 * @url 
 * 
 */

package com.ssafy.day5.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1210_Ladder1_D4_권혁호_154ms {
	
	/** 총 테스트 케이스 갯수 */
	private static int TC = 10;

	/** 입력 받은 테스트 케이스의 순서 */
	private static int numTestCase;
	
	/** 매트릭스 크기 */
	private static int size = 100;

	/** 행 관련 인덱스 */
	private static int row;

	/** 열 관련 인덱스 */
	private static int col;

	/** 직전에 이동한 방향 */
	private static String flagMove;
	
	/** 사다리를 저장할 매트릭스 */
	private static int[][] ladder = new int[size][size];
	
	public static void main(String[] args) throws Exception, IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		for (int testCase = 1; testCase <= TC; testCase++) {
						
			// n번째 테스트 케이스 저장
			numTestCase = Integer.parseInt(br.readLine());
			
			// 100 x 100 배열에 모두 저장 
			for (int i = 0; i < size; i++) {
				
				st = new StringTokenizer(br.readLine(), " ");
				
				for (int j = 0; j < size; j++) {		
					
					ladder[i][j] = Integer.parseInt(st.nextToken());
				
				}

			}

			// "2" 찾기
			for (int i = 0; i < size; i++) {
				
				if (ladder[size-1][i] == 2) {
					
					// 인덱스 설정 및 초기화
					row = size-1;
					col = i;
				}
				
			}
			
			// 최근 이동 변수 초기화
			flagMove = "";

			// 가장 위쪽으로 올때까지 반복
			while (row > 0) {
			
				if( col-1 >= 0 && ladder[row][col-1] == 1 && 
						(flagMove.equals("up") ||flagMove.equals("left")) ) {
					// 왼쪽으로 이동
					// 이전에 왼쪽으로 이동했으면 갈 수 있는만큼 왼쪽으로 이동
					// 이전에 위쪽으로 이동했으면 여기서 왼쪽으로 회전 가능하므로 이동
					
					col = col-1;
					flagMove = "left";
				
				} else if ( col+1 < size && ladder[row][col+1]==1 && 
						(flagMove.equals("up") ||flagMove.equals("right")) ) {
					// 오른쪽으로 이동
					// 이전에 오른쪽으로 이동했으면 갈 수 있는만큼 오른쪽으로 이동
					// 이전에 위쪽으로 이동했으면 여기서 오른쪽으로 회전 가능하므로 이동
					
					col = col+1;
					flagMove = "right";
					
				} else if ( row-1 >= 0 && ladder[row-1][col]==1 ) {
					// 위쪽으로 이동
					
					row = row-1;
					flagMove = "up";
				}
				
			}
			
			// 출력 
			sb.append("#").append(numTestCase).append(" ").append(col).append("\n");
			
		} // end of testCase
		
		// 정답 출력
		System.out.print(sb.toString());
		
	}

}
