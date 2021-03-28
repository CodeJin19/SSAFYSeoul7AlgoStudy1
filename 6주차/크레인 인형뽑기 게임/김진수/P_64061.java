package com.ssafy.algoStudy_06;

import java.util.Stack;

public class P_64061 {
	public int solution(int[][] board, int[] moves) {
        Stack<Integer> stck = new Stack<Integer>();
        int topIdx[] = new int[board[0].length];
        int num;
        int answer = 0;
        
        for(int i = 0; i < board[0].length; i++) {
            topIdx[i] = -1;
            
            for(int j = 0; j < board.length; j++) {
                if(board[j][i] != 0) {
                    topIdx[i] = j;
                    break;
                }
            }
        }
        
        for(int idx = 0; idx < moves.length; idx++) {
            if(topIdx[moves[idx] - 1] != -1) {
                num = board[topIdx[moves[idx] - 1]][moves[idx] - 1];
                
                topIdx[moves[idx] - 1]++;
                
                if(topIdx[moves[idx] - 1] == board.length)
                    topIdx[moves[idx] - 1] = -1;
                
                if(stck.isEmpty()) {
                   stck.push(num); 
                } else if(stck.peek() == num) {
                    stck.pop();
                    answer += 2;
                } else {
                    stck.push(num);
                }
            }
        }
        
        return answer;
    }
}
