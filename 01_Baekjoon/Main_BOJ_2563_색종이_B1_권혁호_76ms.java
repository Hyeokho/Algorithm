/**
 * Algorithm 06. BOJ 2563, 색종이, B1
 * @java Main_BOJ_2563_색종이_B1_권혁호_76ms.java
 * @author 권혁호
 * @since 2022.02.10
 * @url https://www.acmicpc.net/problem/2563
 * 
 * 분류 : 구현
 * 1. 좌표계 1사분면에 올려 놓는다고 생각
 * 2. 색종이의 왼쪽 아래 좌표를 구하기
 * 3. 왼쪽 아래 좌표부터 startRow +10, startCol +10 까지 반복
 * 4. 매트릭스를 순회하면서 해당 위치의 값 1씩 증가
 * 5. 전체 매트릭스를 순회하면서 해당 좌표의 값이 1이상이면 카운팅(cnt)
 *
 * 개선안
 * 1. 시작 좌표 먼저 받아서 x, y의 최대값만 구해서 하면 더 효율적
 * 
 * 참고
 * @url 
 * 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2563_색종이_B1_권혁호_76ms {
	
	private static int lengthPaper = 100;
	private static int lengthConfetti = 10;
	
	private static int[][] paper;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		paper = new int[lengthPaper][lengthPaper];
		
		int numConfetti = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < numConfetti; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			// 매트릭스는 0부터 시작
			int startCol = Integer.parseInt(st.nextToken()) -1 ;
			int startRow = Integer.parseInt(st.nextToken()) -1 ;
			
			// n번째 색종이 영역을 순회하면서 값 1증가
			for (int row = startRow; row < startRow+lengthConfetti; row++) {
				
				for (int col = startCol; col < startCol+lengthConfetti; col++) {
					
					paper[row][col] = paper[row][col]+1;
					
				}
				
			}
			
		}
		
		// 카운팅 변수
		int cnt = 0;
		
		// 시작 위치와 종료 위치를 미리 계산하여
		// 색종이가 있는 부분에만 탐색하는것 가능
		for (int i = 0; i < lengthPaper; i++) {
			for (int j = 0; j < lengthPaper; j++) {
				
				// 해당 위치의 값이 1 이상이면 
				if (paper[i][j] >= 1) {
					
					// 카운팅
					cnt = cnt + 1;
				} 
					
			}
			
		}
		
		//정답 출력
		System.out.println(cnt);
		
	}

}
