import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        
        for (int i = 3; i <= Math.sqrt(sum); i++) {
            if (sum % i != 0) continue;
            int j = sum / i;
            if (i*2 + (j-2)*2 == brown) {
                return new int[]{j,i};
            }
        }
        
        return answer;
    }
}