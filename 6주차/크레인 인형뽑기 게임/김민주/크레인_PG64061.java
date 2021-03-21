package com.ssafy.programmers;

import java.util.Stack;
class 크레인_PG64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = moves.length;
        Stack<Integer> basket = new Stack<Integer>();
        
        for(int i = 0; i<n; i++){
            int m = moves[i]-1;
            for(int j = 0; j<board.length; j++){
                if(board[j][m] != 0){
                    basket.add(board[j][m]);
                    board[j][m] = 0;
                    break;
                }
                else continue;
            }
            if(basket.size()>=2){
                if(basket.peek() == basket.get(basket.size()-2)){
                    basket.pop();
                    basket.pop();
                    answer+=2;
                }
            }
        }
        return answer;
    }
}