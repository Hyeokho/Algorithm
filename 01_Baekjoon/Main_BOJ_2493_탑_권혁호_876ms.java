import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;



public class Main_BOJ_2493_탑_권혁호_876ms {
	
	
//	5
//	6 9 5 7 4
/*
 * ※ 레이저 송신은 우측탑에서 좌측탑으로 송신
 *   따라서 새로 넣을 우측 탑이 좌측에 있는 탑 보다 높으면
 *   좌측 탑 pop / 새로 넣을 탑 push 	
 * 
 * 1. 6을 스택에 넣고 시작, idx를 관리하기 위한 스택에도 추가
 * 2. 새로 넣을 탑인 9 와 6 비교
 * 2-1. 새로 넣을 9가 더 크기 때문에 6=pop 하고 9=push / top = [9]
 * 2-2. result = [0 0]
 * 
 * 3. 새로 넣을 탑인 5 와 9 비교
 * 3-1. 새로 넣을 탑(5)보다 9가 더 크기 때문에 5=push / top = [9 5]
 * 0 0 2
 * 
 * 4. 새로 넣을 탑인 7 과 5 비교
 * 4-1. 새로 넣을 탑(7)이 더 크기 때문에 5=pop 하고 7=push / top = [9 7]
 * 0 0 2 2
 * 
 * 5. 새로 넣을 탑인 4 와 7 비교
 * 5-1. 새로 넣을 탑(4)보다 7이 더 크기 때문에 4=push / top = [9 7 4 ]
 * 0 0 2 2 4
 */
	
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		/** 탑의 수 */
		// 1 <= N <= 500,000
		int T = Integer.parseInt(br.readLine());
		
		// 스택 생성
		Stack<Integer> stackTop = new Stack<Integer>();
		Stack<Integer> stackIdxTop = new Stack<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		stackTop.push(Integer.parseInt(st.nextToken()));
		stackIdxTop.push(1);
		sb.append("0 ");

		for (int i = 1 ; i < T; i++) {
			
			int tempValue = Integer.parseInt(st.nextToken());
		
			while(!stackTop.isEmpty()) {
				
				if( stackTop.peek() > tempValue ) {
//					System.out.print(i);
//					System.out.println(stackIdxTop.peek());
//					System.out.println(sb.toString());
	
					sb.append(stackIdxTop.peek() + " ");
					break;					
				}
				
				stackTop.pop();
				stackIdxTop.pop();
				
				
			}
		
			
			if(stackTop.isEmpty()) {
				sb.append("0 ");
			} 

			stackTop.push(tempValue);
			stackIdxTop.push(i+1);
			
//			System.out.print("top : ");
//			System.out.println(stackTop.toString());
//			System.out.print("idx : ");
//			System.out.println(stackIdxTop.toString());
		}
		
		System.out.println(sb.toString());
		
	}

}
