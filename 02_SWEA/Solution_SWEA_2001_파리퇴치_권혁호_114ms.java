/**
 * Algorithm 02. SWEA 2001, 파리 퇴치
 * @java Solution_SWEA_2001.java
 * @author 권혁호
 * @since 2022.02.04
 * @url https://swexpertacademy.com/main/code/problem/problemDetail.do
 * 
 * 참고
 * @url https://codechasseur.tistory.com/88
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_2001_파리퇴치_권혁호_114ms {
	
	 public static void main(String[] args) throws Exception, IOException {
		 
		 
		 /** 입력, 문자열 처리를 위한 객체 생성 */
		 StringBuilder sb = new StringBuilder();
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 /** 테스트 케이스 수 */
		 int T = Integer.parseInt(br.readLine());
		 
		 // 테스트 케이스 만큼 반복
		 for (int testCase = 1; testCase <= T; testCase++) {
			
			 // 공백 문자를 기준으로 N, M 구분
			 StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			 
			 /** 배열 크기 */
			 // 5 <= N <= 15
			 int N = Integer.parseInt(st.nextToken());
			 
			 /** 영역 크기*/
			 // 2 <= M <= N
			 int M = Integer.parseInt(st.nextToken());
			 
			 /** 배열 인덱싱을 위한 변수 */
			 int row = 0;

			 /** 배열 인덱싱을 위한 변수*/
			 int col = 0;
			 			 
			 /** 최대값을 구하기 위한 합계 변수*/
			 int sum = 0;
			 
			 /** 최대값*/
			 int max = 0;
			 
			 int[][] arr = new int[N][N];
			 
			 // 입력을 매트릭스로 만듦
			 for (int i = 0; i < N; i++) {
				 
				 st = new StringTokenizer(br.readLine(), " ");
				 
				 for (int j = 0; j < N; j++) {
					 
					 arr[i][j]= Integer.parseInt(st.nextToken());
					 
				 }
			 }
			 
			 // 
			 for (row = 0; row <= N-M; row++) {
				 
				 for (col = 0; col <= N-M; col++) {
					 
					 for (int r = 0; r < M; r++) {
						 
						 for (int c = 0; c < M; c++) {
							 
							 sum = sum + arr[row+r][col+c];
							 
//						 	 System.out.print((row+r));
//						 	 System.out.print(" : ");
//							 System.out.print((col+c));
//							 System.out.print(" : ");
//							 System.out.print(arr[row+r][col+c]);
//							 System.out.println();
						 }
						 
//						 System.out.println(sum);
						 
					 }
					 
					 // 최대값 보다 크면 갱신 
					 if (sum > max) {
						 max = sum;
					 }
					 
					 // 합계 초기화
					 sum=0;
					
				 }
				 
			 }
			 
			 // 매트릭스 전체 확인
//			 for (int x = 0; x < N; x++) {
//				 for (int y = 0; y < N; y++) {
//					 
//					 System.out.print(arr[x][y] +" ");
//					 
//				 }
//				 System.out.println();
//				 
//			 }
			 
			 // 출력 문자열 저장
			 sb.append("#").append(testCase).append(" ").append(max).append("\n");
			 
		}
		 
		System.out.println(sb.toString());
	}

}