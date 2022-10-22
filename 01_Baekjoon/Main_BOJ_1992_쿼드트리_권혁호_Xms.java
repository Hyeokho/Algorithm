package com.ssafy.day10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1992_쿼드트리_권혁호_Xms {
	
//	private static boolean[][] matrix;
	private static int[][] matrix;
	private static int[][] temp;
	private static int[] setRow;
	private static int[] setCol;
	
	private static StringBuilder sb;
	
	
	public static void QuadTree(int n, int row, int col) {
		
//		int n = matrix.length;
		int midSize = n/2;
		
		if(n==2) {
			
			System.out.print("(");
			
//			return;
			if(matrix[row][col] + matrix[row][col+1] + matrix[row+1][col] + matrix[row+1][col+1] == 4) {
				// 1로 압축
				System.out.print("1");
			} else if (matrix[row][col] + matrix[row][col+1] + matrix[row+1][col] + matrix[row+1][col+1] == 0) {
				// 0으로 압축
				System.out.print("0");				
			} else {
				System.out.print(matrix[row][col]);
				System.out.print(matrix[row][col+1]);
				System.out.print(matrix[row+1][col]);
				System.out.print(matrix[row+1][col+1]);
			}
			System.out.print(")");
			
				
		} else {
//			System.out.println("zz");
//			int midSize = n/2;
			System.out.print("(");
			
			int flag1 = matrix[row][col];
			boolean flag1_1 = true;
			
			for (int r = row; r < midSize; r++) {
				
				for (int c = col; c < midSize; c++) {
					
					if(matrix[r][c] == flag1) {
//						System.out.println("check1 : " +r + " " + c  );
						
					} else {
//						System.out.println("?1");
						flag1_1 = false;
						
						break;
					}
				}
			}
			if (flag1_1 == true) {
				System.out.print(flag1);				
			} else {
				QuadTree(midSize, row, col);
			}
			
			
//////////////////////
			
			int flag2 = matrix[row][col+midSize];
			boolean flag2_1 = true;
			
			for (int r = row; r < midSize; r++) {
				
				for (int c = col+midSize; c < midSize+midSize; c++) {
					
					if(matrix[r][c] == flag2) {
//						System.out.println("check2 : " +r + " " + c  );
						
					} else {
//						System.out.println("?2");
						flag2_1 = false;
						
						break;
					}
				}
			}
			if (flag2_1 == true) {
				System.out.print(flag2);				
			} else {
				QuadTree(midSize, row, col+midSize);
			}
			
			
//////////////////////
			int flag3 = matrix[row+midSize][col];
			boolean flag3_1 = true;
			
			for (int r = row+midSize; r < midSize+midSize; r++) {
				
				for (int c = col; c < midSize; c++) {
					
					if(matrix[r][c] == flag3) {
//						System.out.println("check3 : " +r + " " + c  );
						
					} else {
//						System.out.println("?3");
						flag3_1 = false;
						
						break;
					}
				}
			}
			if (flag3_1 == true) {
				System.out.print(flag3);				
			} else {
				QuadTree(midSize, row+midSize, col);
			}
			
			
//////////////////////
			int flag4 = matrix[row+midSize][col+midSize];
			boolean flag4_1 = true;
			
			for (int r = row+midSize; r < midSize+midSize; r++) {
				
				for (int c = col+midSize; c < midSize+midSize; c++) {
					
					if(matrix[r][c] == flag4) {
//						System.out.println("check4 : " +r + " " + c  );
						
					} else {
//						System.out.println("?4");
						flag4_1 = false;
						
						break;
					}
				}
			}
			if (flag4_1 == true) {
				System.out.print(flag4);				
			} else {
				QuadTree(midSize, row+midSize, col+midSize);
			}
			System.out.print(")");
			
			
//////////////////////


			
//			QuadTree(midSize, row, col);
//			QuadTree(midSize, row, col+midSize);
//			QuadTree(midSize, row+midSize, col);
//			QuadTree(midSize, row+midSize, col+midSize);
			
			/*
			int midSize = n/2;
			
			temp = new int[midSize][midSize];
			
			int flag1 = matrix[row][col];
			
			for (int r = row; r < midSize; r++) {
				
				for (int c = col; c < midSize; c++) {
					
					if(matrix[r][c] == flag1) {
						System.out.println("check1 : " +r + " " + c  );
					} else {
						System.out.println("?");
						QuadTree(midSize, row, col);
						break;
					}
				}
			}	
			System.out.println("===" + flag1);
			
//////////////////////
			
			int flag2 = matrix[row][col+midSize];
			
			for (int r = row; r < midSize; r++) {
				
				for (int c = col+midSize; c < midSize+midSize; c++) {
					
					if(matrix[r][c] == flag2) {
						System.out.println("check2 : " +r + " " + c  );
					} else {
						System.out.println("??");			
						QuadTree(midSize, row, col+midSize);
						break;
					}
				}
			}	
			System.out.println("===" + flag2);
			
//////////////////////
			
			int	flag3 = matrix[row+midSize][col];
			
			for (int r = row+midSize; r < midSize+midSize; r++) {
				
				for (int c = col; c < midSize; c++) {
					
					if(matrix[r][c] == flag3) {
						System.out.println("check3 : " +r + " " + c  );
					} else {
//						System.out.println("???");
						QuadTree(midSize, row+midSize, col);
						break;
					}
				}
			}	
			System.out.println("===" + flag3);
			
//////////////////////
			
			int flag4 = matrix[row+midSize][col+midSize];
			
			for (int r = row+midSize; r < midSize+midSize; r++) {
				
				for (int c = col+midSize; c < midSize+midSize; c++) {
					
					if(matrix[r][c] == flag4) {
						System.out.println("check4 : " +r + " " + c  );
//						System.out.println(row + " " + col + " " + midSize);
						
					} else {
//						System.out.println("????");					
						QuadTree(midSize, row+midSize, col+midSize);
						break;
					}
				}
			}	
			System.out.println("===" + flag4);
			
//////////////////////		
 * 
 */
			
			
			
			
			
			
			
////			QuadTree(matrix, 0, 2);
//			System.out.println(midSize);
			

			
		}
			
		
//		if( midSize >= r && midSize >= c ) {
//			
//		}
		
		
		
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기
		
		
		/** 행, 열의 크기 */
		// 1 ≤ N ≤ 64
		int N = Integer.parseInt(br.readLine());
		
		matrix = new int[N][N];
		
		
		for (int row = 0; row < N; row++) {
			
//			StringTokenizer st = new StringTokenizer(br.readLine(), "");
			String input = br.readLine();
			
			for (int col = 0; col < N; col++) {
				
//				matrix[row][col] = Boolean.parseBoolean(st.nextToken());
				matrix[row][col] = Integer.parseInt(input.substring(col, col+1));
			}
			
		}
		
//		for (int i = 0; i < matrix.length; i++) {
//			System.out.println(Arrays.toString(matrix[i]));
//		}
		
		QuadTree(N, 0, 0);
		


		
//		//2. 현재 상태에서 4분면으로 나눔
//		while(true) {
//
//			// 사분면 위치 찾기
//			// 3. 좌표 위치에 따라서 r, c, sum의 값 업데이트
//			if( midSize >= r && midSize >= c ) {
//				
//				// 1사분면
//				//r = r;
//				//c = c;				
//				//sum = sum;
//				
//			} else if( midSize >= r && midSize < c ) {
//				
//				// 2사분면
//				//r = r;
//				c = c-midSize;
//				sum = sum+ (midSize * midSize * 1);
//
//			} else if( midSize < r && midSize >= c ) {
//				
//				// 3사분면
//				r = r-midSize;
//				//c = c;
//				sum = sum+ (midSize * midSize * 2);
//
//			} else if( midSize < r && midSize < c ) {
//			
//				// 4사분면
//				r = r-midSize;
//				c = c-midSize;
//				sum = sum+ (midSize * midSize * 3);
//
//			}
//			
//			if (midSize == 1) {
//				
//				//(2 x 2) 크기의 매트릭스가 돼었는지 체크
//				break;
//				
//			}
//			
//			// (2 x 2) 크기의 매트릭스가 될때까지 2~3 반복
//			midSize = midSize/2;					
//			
//		}
//		
//		// 정답
//		//System.out.println(sum);
//		bw.write(sum + "\n");
//		bw.flush();   
//		bw.close();
		
	}

}
