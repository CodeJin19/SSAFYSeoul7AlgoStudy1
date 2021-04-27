import java.util.*;

class Solution {
    
    static int answer;
    
    static Map<Character, Integer> ctoi = new HashMap<>();
    static char[] words = {'A','C','F','J','M','N','R','T'};
    
    static List<Integer>[][] info = new ArrayList[8][7]; // [단어 idx][단어로부터의 간격] : 해당 간격에 놓여질 수 있는 단어 idx들의 리스트를 저장
    static boolean[] visited = new boolean[8];
    static int[] selected = new int[8];
    
    public int solution(int n, String[] data) {
        answer = 0;
        
        for (int i = 0; i < 8; i++) {
            ctoi.put(words[i], i);
        }
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                info[i][j] = new ArrayList<>();
                for (int k = 0; k < 8; k++) {
                    if (i != k) info[i][j].add(k);
                }
            }
        }
        
        for (int i = 0; i < data.length; i++) {
            int a = ctoi.get(data[i].charAt(0));
            int b = ctoi.get(data[i].charAt(2));
            int val = Integer.parseInt(data[i].substring(4));
            process(a, b, data[i].charAt(3), val);
        }
        
        DFS(0);
        
        return answer;
    }
    
    static void DFS(int idx) {
        if (idx == 8) {
            answer++;
            return;
        }
        
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                boolean flag = true;
                
                for (int j = 0; j < idx; j++) {
                    if (!info[selected[j]][idx-j-1].contains(i)) {
                        flag = false;
                        break;
                    }
                }
                
                if (flag) {
                    visited[i] = true;
                    selected[idx] = i;
                    DFS(idx + 1);
                    visited[i] = false;
                }
            }
        }
        
    }
    
    static void process(int a, int b, char op, int val) {
        switch(op) {
            case '=':
                for (int i = 0; i < 7; i++) {
                    if (i != val) {
                        info[a][i].remove(new Integer(b));
                        info[b][i].remove(new Integer(a));
                    }
                }
                break;
            case '>':
                for (int i = 0; i < 7; i++) {
                    if (i <= val) {
                        info[a][i].remove(new Integer(b));
                        info[b][i].remove(new Integer(a));
                    }
                }
                break;
            case '<':
                for (int i = 0; i < 7; i++) {
                    if (i >= val) {
                        info[a][i].remove(new Integer(b));
                        info[b][i].remove(new Integer(a));
                    }
                }
                break;
        }
    }
}