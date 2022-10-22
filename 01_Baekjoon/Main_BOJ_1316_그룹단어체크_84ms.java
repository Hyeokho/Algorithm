/**
 * Algorithm. BOJ 1316, 그룹 단어 체커, S5
 * @java Main_BOJ_1316_그룹단어체크_84ms.java
 * @author 권혁호
 * @since 2022.06.09
 * @url https://www.acmicpc.net/problem/1316
 * 
 */

import java.util.*;
import java.io.*;

public class Main_BOJ_1316_그룹단어체크_84ms {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 단어의 개수 N
        int N = Integer.parseInt(br.readLine());
        
        // 정답
        int sol = 0;
        
        // 단어의 개수 만큼 반복
        for(int i=1; i<=N; i++){

        	// 입력 받은 문자열
            String input = br.readLine();
            
            // 해당 알파벳이 이전에 나온적 있는지 체크하기 위한 배열
            boolean[] check = new boolean[26];
            
            // 입력 문자열의 길이가 "1"일 경우 무조건 그룹 단어
            if(input.length() == 1) {
            	sol++;
            	continue;
            }
            
            // 맨 처음 알파벳 사용 체크
            check[input.charAt(0)-97] = true;
            
            // 알파벳의 끝까지 탐색
            for (int j = 1; j < input.length(); j++) {
            	
            	
            	if( input.charAt(j) == input.charAt(j-1) ) {
            		
            		// 연속 단어 이면 넘어감 
            		// NOP
            		
            	} else if( check[input.charAt(j)-97] == false ) {
            		
            		// 연속 단어가 아니고 이전에 나온적이 없으면
            		// 해당 알파벳 사용 체크
            		check[input.charAt(j)-97] = true;
            		
            	} else {
            		
            		// 이전에 알파벳이 나온적이 있으면
            		break;
            	}
            	
            	// 마지막 문자까지 왔으면
            	if( j == input.length()-1) {
            		sol++;
            	}
				
			}

        }
        
        // 정답 출력
        System.out.println(sol);

    }
    
}
