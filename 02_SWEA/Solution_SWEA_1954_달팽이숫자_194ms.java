/**
 * Algorithm 01. SWEA 1954, 달팽이 숫자
 * @java Solution_SWEA_1954_달팽이숫자_194ms.java
 * @author 권혁호
 * @since 2022.02.03
 * @url https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq
 */

import java.util.Scanner;

public class Solution_SWEA_1954_달팽이숫자_194ms {
	
	public static void main(String[] args) {
		
		int[][] snail2 = new int[0][0];
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int[] N = new int[T];
		
		for (int i = 0; i < T; i++) {
			N[i] = sc.nextInt();
		} 
		
		for (int testCase = 0; testCase < T; testCase++) {

			int[][] snail = new int[N[testCase]][N[testCase]];
			
			int k = 0;
			
			int sizeRow = N[testCase];
			int sizeCol = N[testCase];
			
			int startRow = 0;
			int startCol = 0;
			
			int row = 0;
			int col = 0;
			
				
			
			 
			while (startRow < sizeRow) {	

				if (sizeRow == 1) {
					snail[0][0] = 1;
					break;
				}
				
				for (col = startCol; col <= sizeCol; col++) {
					
					if(snail[row][col]==0) {
						snail[row][col] = ++k;
					}
					
					if( col+1>=N[testCase] || snail[row][col+1]!=0 ) {
						break;
					}
					
				}
				
				for (row = startRow+1; row <= sizeRow; row++) {
					
					if(snail[row][col]==0) {
						snail[row][col] = ++k;
					}
					
					if( row+1>=N[testCase] || snail[row+1][col]!=0 ) {
						break;
					}
					
					
				}
				
				for (col = sizeCol-2; col >= startCol; col--) {
					
					if(snail[row][col]==0) {
						snail[row][col] = ++k;
					}
					if( col-1<startCol || snail[row][col-1]!=0 ) {
						break;
					}
				
					
				}
				
				for (row = sizeRow-2; row >= startRow; row--) {
					
					if(snail[row][col]==0) {
						snail[row][col] = ++k;
					}
					
					if( row-1<startRow || snail[row-1][col]!=0 ) {
						break;
					}
					
					
				}
				
				startRow++;
				startCol++;
				sizeRow--;
				sizeCol--;
				

			} 
			
			System.out.println("#"+(testCase+1));
			
			for(int i=0;i<N[testCase];i++) {
	            for(int j=0;j<N[testCase];j++) {
	                System.out.printf("%d ",snail[i][j]);
	            }
	            System.out.printf("\n");
			}
			
			snail = null;
			
		}
		
		sc.close();
	}

}
