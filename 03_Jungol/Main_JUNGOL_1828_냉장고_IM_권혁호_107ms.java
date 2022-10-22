/**
 * Algorithm 09. JUNGOL 1828, 냉장고, IM
 * @java Main_JUNGOL_1828_냉장고_IM_권혁호_107ms.java
 * @author 권혁호
 * @since 2022.02.15
 * @url http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=30
 * 
 * 분류 : 그리디
 * 
 * 참고
 * @url
 * 
 */

package com.ssafy.day9.hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 1. 재료의 최고기온을 오름차순으로 정렬
// 2. 마지막 최고기온 보다 이번의 최소값이 더 낮으면 냉장고를 더 사용가능
// 3. 마지막 최고기온 보다 이번의 최소값이 더 높으면 냉장고를 교체해야됨
// 3-1. 마지막 최고기온 갱신, 냉장고 카운트 개수 1 증가
// 4. 2~3 반복

public class Main_JUNGOL_1828_냉장고_IM_권혁호_107ms {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		/** 재료의 수량 */
		// 1 ≤ N ≤ 100
		int N = Integer.parseInt(st.nextToken());
		
		/** 재료의 최저, 최고기온을 저장할 매트릭스 */
		int[][] material = new int[N][2];
		
		// 재료의 정보 입력 받음
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			material[i][0] = Integer.parseInt(st.nextToken());
			material[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		
		// 1. 재료의 최고기온을 오름차순으로 정렬
		Arrays.sort(material, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[1]-o2[1];
				//return o2[0]-o1[0]; // 내림차순				
			}
			
		});
		
		/** 필요한 냉장고 수 */
		// 초기값 설정
		int cnt = 1;
		
		/** 마지막 최고기온 */
		int max = material[0][1];
		
		// 4. 2~3 반복
		for (int i = 1; i < N; i++) {
			
			if( max >= material[i][0]) {
				
				// 2. 마지막 최고기온 보다 이번의 최소값이 더 낮으면 냉장고를 더 사용가능
				// NOP
				
			} else {
				
				// 3-1. 마지막 최고기온 갱신, 냉장고 카운트 개수 1 증가
				max = material[i][1];
				cnt++;
			}
			
		}
		// 정답 출력
		System.out.println(cnt);
		
//		bw.write(cnt+"\n");
//		bw.flush();
//		bw.close();

	} // end of Main
	
} // end of Class
