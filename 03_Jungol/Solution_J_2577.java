import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 찾아볼것 투포인터 알고리즘, 슬라이딩 윈도우
// 
public class Solution_J_2577 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        // 회전 초밥 벨트에 놓인 접시의 수, 2≤N≤3,000,000
        int N = Integer.parseInt(st.nextToken());
        
        // 초밥의 가짓수, 2≤d≤3,000
        int d = Integer.parseInt(st.nextToken());
        
        // 연속해서 먹는 접시의 수, 2≤k≤3,000 (k≤N)
        int k = Integer.parseInt(st.nextToken());
        
        // 쿠폰 번호, 1≤c≤d
        int c = Integer.parseInt(st.nextToken());

        // 원형 테이블
        // k개 만큼 먹어야 하기 때문에 뒤에 k개 만큼 추가
        int [] sushi = new int[N+k];
        
        for (int i = 0; i< N; i++) {
        	sushi[i] = Integer.parseInt(br.readLine());
        }
        
//        System.out.println(Arrays.toString(sushi));
        
        // 앞에 있는 초밥을 뒤에 붙여서 원형 링크드 리스트 구조처럼 만듦
        for (int i = N; i < N+k; i++) {
        	sushi[i] = sushi[i-N];
        }

        // 먹은 초밥
        int [] v = new int[d+1];


        int sol = -1;
        
        // 쿠폰에 해당되는 초밥 접시의 개수
        int cnt = 0;
        
        int coupon = 0;
        
        
        for (int i = 0; i < N+k; i++) {
        	
            // 접시 k개를 선택했으면
            if (i >= k){
                
            	// 맨 앞 접시 빼기
            	if (--v[sushi[i-k]] == 0) {
            		// 뺀 초밥이 먹은적이 없으면
                	cnt--;
                }
                
                if (sushi[i-k] == c) coupon--;
            }
            
            // 현재 먹은 초밥은 추가
            if (++v[sushi[i]] == 1) cnt++;
            
            // 현재 접시에서 쿠폰을 사용할 수 있으면
            if (sushi[i] == c) coupon++;
            
           
            if (i >= k)
                sol = Math.max(sol, coupon == 0 ? cnt + 1: cnt);
        }
        System.out.println(sol);
		
	}

}
