import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int idx = 0, ridx = people.length - 1, cnt = 0;
        while (true) {
            cnt++;
            if (people[idx] + people[ridx] <= limit && idx != ridx) {
                cnt++;
                idx++;
            } 
            answer++;
            ridx--;
            
            if (cnt == people.length) break;
        }
        
        return answer;
    }
}