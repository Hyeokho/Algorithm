
/**
 * Algorithm2 08. SWEA 4014, 활주로 건설
 * @java Solution_SWEA_4014_활주로건설_권혁호_120ms.java
 * @author 권혁호
 * @since 2022.04.08
 * @url https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeW7FakkUDFAVH
 * 
 * 분류 : 구현 시뮬레이션?
 * 
 * 같은 문제
 * @url https://www.acmicpc.net/problem/14890
 *  
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_4014_활주로건설_권혁호_120ms {

	private static int X;
	private static int N;
	private static int cnt;

	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());

			X = Integer.parseInt(st.nextToken());

			cnt = 0;

			int[][] horiMap = new int[N][N];
			int[][] verticalMap = new int[N][N];

			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < N; j++) {

					int temp = Integer.parseInt(st.nextToken());

					horiMap[i][j] = temp;
					verticalMap[j][i] = temp;

				}

			}

			// for (int i = 0; i < horiMap.length; i++) {
			// System.out.println(Arrays.toString(horiMap[i]));
			// }
			// System.out.println();
			// for (int i = 0; i < horiMap.length; i++) {
			// System.out.println(Arrays.toString(verticalMap[i]));
			// }
			//
			// for (int i = 0; i < horiMap.length; i++) {
			// for (int j = 0; j < horiMap.length; j++) {
			//
			// System.out.print(horiMap[j][i]);
			// }
			// System.out.println();
			// }

			boolean[][] isVisited = new boolean[N][N];
			run(horiMap, isVisited);

			// for (int i = 0; i < N; i++) {
			// System.out.println(Arrays.toString(isVisited[i]));
			// }

			isVisited = new boolean[N][N];
			run(verticalMap, isVisited);

			sb.append("#").append(t).append(" ").append(cnt).append("\n");

		}
		System.out.print(sb);

	}

	private static void run(int[][] Map, boolean[][] isVisited) {

		// 가로, 왼쪽에서 오른쪽으로 탐색

		for (int i = 0; i < N; i++) {

			Loop1: for (int j = 0; j < N - 1; j++) {

				// 현재 칸과 다음 칸의 차이에 따라서 선택
				// slct = select
				int slct = Map[i][j] - Map[i][j + 1];

				if (Math.abs(slct) > 1) {
					// 2이상 이면 경사로 건설 못함
					// System.out.println("2 이상 차이");
					break Loop1;

				} else if (slct == 0) {
					// 같으면 다음으로 넘어감
					// System.out.println( i + " "+ j +" 같음");
				} else if (slct > 0) {

					// 양수이면
					// 다음칸이 아래

					// 다음 칸에 경사로를 넣을지 말지 여부
					boolean isWay = true;

					// 현재의 다음 다음칸부터 k개 까지 조건 탐색
					for (int k = 2; k <= X; k++) {

						// 경사로를 놓을 수 있으면
						if (j + k < N && (Map[i][j + 1] == Map[i][j + k])
								&& !isVisited[i][j + k]) {

							// 범위 안에 있고
							// 높이가 같고
							// 이전에 경사로를 건설하지 않았어야 함

						} else {

							// System.out.println( i + "행에 아래 경사로 건설 불가능");
							isWay = false;
							break Loop1;

						}

					}

					if (isWay) {

						// System.out.print(i + "행 경사로 건설 / ");
						// System.out.println(j+1 + "열 경사로 건설");

						// 현재의 높이를 맞춰줌
						Map[i][j]--;

						for (int k = 1; k <= X; k++) {

							// 경사로 건설 여부 체크
							isVisited[i][j + k] = true;

						}

					} // end of 위 방향 경사로

				} else if (slct < 0) {
					// 음수이면
					// 다음칸이 위

					// 다음 칸에 경사로를 넣을지 말지 여부
					boolean isWay = true;

					// 현재의 이전칸부터 k-1개 까지 조건 탐색
					for (int k = 1; k <= X - 1; k++) {

						// 경사로를 놓을 수 있으면
						if (j - k >= 0 && (Map[i][j] == Map[i][j - k])
								&& !isVisited[i][j - k]) {

							// 범위 안에 있고
							// 높이가 같고
							// 이전에 경사로를 건설하지 않았어야 함

						} else {

							// System.out.println( i + "행에 아래 경사로 건설 불가능");
							isWay = false;
							break Loop1;

						}

					}

					if (isWay) {

						// System.out.print(i + "행 경사로 건설 / ");
						// System.out.println(j-X+1 + "열 경사로 건설");

						// 높이를 맞춰줌

						Map[i][j]++;
						for (int k = 0; k < X; k++) {

							// 경사로 건설 여부 체크
							isVisited[i][j - k] = true;

						}

					}

				} // end of 아래 방향 경사로

				// 끝까지 탐색 했는지 체크
				if (j >= N - 1) {
					// System.out.println(i + "행 통과");
					cnt++;
				} else if (j == N - 2) {
					if (Map[i][j] - Map[i][j + 1] == 0) {
						// System.out.println(i + "행 통과");
						cnt++;
					}
				}

			} // 행 끝

		} // 행 전체 탐색 끝

	}

}
