import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_9229_한빈이와SpotMart_권혁호_D3_149ms {
	
	private static int numSnack = 2;
	
	private static int[] weightSnack;
	
	/** 과자 봉지의 개수 */
	private static int N;

	/** 과자 봉지의 무게 합 제한 */
	private static int M;
		
	/** 초기 값 */
	private static int max = -1;
	
	/**
	 * dfs 재귀함수
	 * 
	 * @param num 조합할 과자의 개수
	 * @param cnt 조합할 과자 배열의 인덱스
	 * @param sumWeight 무게 총량
	 */
	public static void dfs(int num, int cnt, int sumWeight) {
		
		// 무게 제한이 넘으면
		if ( sumWeight > M ) {
			return;
		}
		
		if( num == numSnack || cnt == N ) {
			
			// 총합이 제한보다 이하, 선택한 과자의 갯수, 총합이 최대 보다 크면 갱신
			if(M >= sumWeight && num == numSnack && max < sumWeight) { 
				max = sumWeight;
			}
			return;

		}
		
		// 선택
		dfs(num+1, cnt+1, sumWeight+weightSnack[cnt]);
		
		// 미선택
		dfs(num, cnt+1, sumWeight);
		
	}
	
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			
			M = Integer.parseInt(st.nextToken());
			
			max = -1;
			
			weightSnack = new int[N];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++) {
				
				weightSnack[i] = Integer.parseInt(st.nextToken());
				
			}
			
			dfs(0, 0, 0);
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
						
		}
		
		System.out.println(sb);
		
	}
	
}
