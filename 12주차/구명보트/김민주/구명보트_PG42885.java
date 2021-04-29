package com.ssafy.programmers;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int end = people.length - 1;
        int start = 0;
        while(start <= end){
            if(people[start] + people[end] > limit){
                answer++;
                end--;
            }
            else{
                answer++;
                end--;
                start++;
            }
        }
        return answer;
    }
}