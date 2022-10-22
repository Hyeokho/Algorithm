// https://www.acmicpc.net/problem/1987
//https://pangsblog.tistory.com/33



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1987_알파벳_G4_권혁호_1176ms {
	
	private static boolean[][] visited;
	
	private static String visitAlphabet = "";
	private static int R;
	private static int C;
	private static int cnt;
	private static int maxCnt;
	private static char[][] matrix;
	private static boolean[] checkAlphabet;
	private static String[][] visit;
	
	//방문한 문자를 체크하는 방법?
	// 1. 문자열로 만들어서 체크 → 시간초과남
	// 2. 알파벳 전부를 저장한 배열
	
	// 상하좌우
	private static int[] dx = { -1,  1,  0,  0};
	private static int[] dy = {  0,  0, -1,  1};


	private static void dfs(int x, int y) {

//		System.out.println(matrix[x][y] + " " + x + " " + y + " " + visitAlphabet + " " + cnt);
		
		visited[x][y] = true;
		checkAlphabet[matrix[x][y]-65] = true;
		
		//시간초과2?..
//		visitAlphabet = visitAlphabet + matrix[x][y];
		
		
		// 최대 이동거리
		if (cnt >= R*C-1) {
			return;
//			break;
		}
		
		for (int i = 0; i < 4; i++) {
			// 다음 이동할 칸이 이동이 가능하면
			// 범위를 넘지 않고
			// 지나온 적이 없고, 지나온 적이 없는 알파벳이면
			
			int nextX = x+dx[i];
			int nextY = y+dy[i];

			// 시간초과1?...
//			if ( 0 <= x+dx[i] && x+dx[i] < R && 0 <= y+dy[i] && y+dy[i] < C 
//					&& !visited[x+dx[i]][y+dy[i]] && !visitAlphabet.contains(String.valueOf(matrix[x+dx[i]][y+dy[i]]))) {
			
			// 시간초과2?...
//			if ( 0 <= nextX && nextX < R && 0 <= nextY && nextY < C 
//					&& !visited[nextX][nextY] && !visitAlphabet.contains(String.valueOf(matrix[nextX][nextY]))) {
			
			// 시간초과 안남
//			if ( 0 <= nextX && nextX < R && 0 <= nextY && nextY < C 
//					&& !visited[nextX][nextY] && !checkAlphabet[matrix[nextX][nextY]-65]) {
			
			// 1번 시간초과 테스트
			if ( 0 <= x+dx[i] && x+dx[i] < R && 0 <= y+dy[i] && y+dy[i] < C 
					&& !visited[x+dx[i]][y+dy[i]] && !checkAlphabet[matrix[nextX][nextY]-65]) {
			
			
				cnt++;
				//시간초과1?..
//				dfs(x+dx[i], y+dy[i]);
				dfs(nextX, nextY);
				
//				System.out.println("zzz");
				
			}
			
			if (maxCnt < cnt) {
				maxCnt = cnt;
			}
		}
		
		
//		dfs(x, y);
		
		
		cnt--;
		visited[x][y] = false;
		checkAlphabet[matrix[x][y]-65] = false;
		//시간초과2?...
//		visitAlphabet = visitAlphabet.replace(String.valueOf(matrix[x][y]), "");
		
	}
	
		
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		visited = new boolean[R][C];
		
		matrix = new char[R][C];
		checkAlphabet = new boolean[26]; // 알파벳 개수 26개
		
		for (int row = 0; row < R; row++) {
			
			matrix[row] = br.readLine().toCharArray();
			
		}
		
//		for (int i = 0; i < matrix.length; i++) {
//			System.out.println(matrix[i]);
//		}
		
//		visitAlphabet = "ABVD";
//		visitAlphabet = visitAlphabet.replace(String.valueOf("A"), "");
//		visitAlphabet = visitAlphabet.replace("B", "");
//		System.out.println(visitAlphabet);

		
		dfs(0,0);
		System.out.println(maxCnt+1);
		
		
	}


}
