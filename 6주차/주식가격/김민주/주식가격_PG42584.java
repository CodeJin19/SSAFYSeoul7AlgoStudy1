package com.ssafy.programmers;

class 주식가격_PG42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            int cnt = 0;
            for(int j = i+1; j<prices.length; j++){
                if(prices[i]>prices[j]){
                    cnt++;
                    break;
                } 
                else cnt++;
            }
            answer[i] = cnt;
        }  
        return answer;
    }
}