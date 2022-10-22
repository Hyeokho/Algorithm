/**
 * Algorithm 15. BOJ 1026, 적록색약, G5
 * @java Main_BOJ_10026_적록색약_G5_권혁호_92ms.java
 * @author 권혁호
 * @since 2022.02.23
 * @url https://www.acmicpc.net/problem/10026
 * 
 * 분류 : dfs, 사방탐색
 * 
 * 참고
 * @url
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_10026_적록색약_G5_권혁호_92ms {
	
	private static char[][] pic;
	private static boolean[][] isVsited;
	private static int N;

	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int cnt;
	private static int nomal;


	private static void dfs(int row, int col) {

		
		if(isVsited[row][col]) {
			return;
		}
//		System.out.println("row : " + row + "  col : " + col);
		
		isVsited[row][col]=true;
		
		// 사방탐색
		for (int i = 0; i < 4; i++) {
			
			int nRow = row + dr[i];
			int nCol = col + dc[i];
			
			// 다음으로 이동이 불가능하면
			if( nRow < 0 || nRow >= N || nCol < 0 || nCol >= N)
				continue;
			
			// 다음으로 방문한적이 있으면 
			if( isVsited[nRow][nCol] )
				continue;
			
			// 다음 컬러가 현재와 같으면
			if ( pic[row][col] == pic[nRow][nCol] ) {
				
				// 이동
				dfs(nRow, nCol);
			}
				
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1 ≤ N ≤ 100
		N = Integer.parseInt(br.readLine());
		
		pic = new char[N][N];
		isVsited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			
			pic[i] = br.readLine().toCharArray();
			
		}
		
		// 입력 확인
//		for (int i = 0; i < pic.length; i++) {
//			System.out.println(Arrays.toString(pic[i]));
//		}
		
		// 일반인의 경우
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 다음으로 방문한 적이 없으면
				if(!isVsited[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		
		// 일반인의 경우 결과 저장
		nomal = cnt;
		
		// 초기화
		cnt = 0;
		isVsited = new boolean[N][N];
		
		// G를 R로 변경
		for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(pic[i][j]=='G'){
                	pic[i][j] = 'R';
                }
            }
        }
		
		// 색약의 경우
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!isVsited[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		
		// Solution
		System.out.println(nomal + " " + cnt);

	}

}
