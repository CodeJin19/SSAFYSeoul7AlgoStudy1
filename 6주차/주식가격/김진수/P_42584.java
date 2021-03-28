package com.ssafy.algoStudy_06;

public class P_42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int cnt, idx;
        
        for(int i = 0; i < prices.length; i++) {
            cnt = 0;
            idx = i;
            
            while(idx < prices.length && prices[i] <= prices[idx]) {
                cnt++;
                idx++;
            }
            
            if(idx == prices.length)
                cnt--;
            
            answer[i] = cnt;
        }
        
        return answer;
    }
}
