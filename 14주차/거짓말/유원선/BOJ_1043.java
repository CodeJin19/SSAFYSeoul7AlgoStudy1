import java.io.*;
import java.util.*;

class Main {

    static int n, m, num, cnt;
    static int[] parents;
    static List<Integer> truth = new ArrayList<>();
    static List<Integer>[] partyList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parents[i] = i;

        partyList = new ArrayList[m];
        for (int i = 0; i < m; i++)
            partyList[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        for (int i = 0; i < num; i++)
            truth.add(Integer.parseInt(st.nextToken()));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int partyNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partyNum; j++) {
                int person = Integer.parseInt(st.nextToken());
                partyList[i].add(person);
            }
        }

        cnt = m;

        for (int i = 0; i < m; i++) {
            int p1 = partyList[i].get(0);
            for (int j = 1; j < partyList[i].size(); j++) {
                int p2 = partyList[i].get(j);
                union(p1, p2);
            }
        }

        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int j = 0; j < partyList[i].size(); j++) {
                if (!flag) break;

                int p1 = partyList[i].get(j);
                for (int k = 0; k < truth.size(); k++) {
                    int p2 = truth.get(k);
                    if (isSameParents(p1, p2)) {
                        flag = false;
                        break;
                    }
                }
            }
            
            if (!flag)
                cnt--;
        }

        System.out.println(cnt);
    }

    static void union(int a, int b) {
        a = findParents(a);
        b = findParents(b);
        if (a != b) parents[b] = a;
    }

    static int findParents(int a) {
        if (a == parents[a]) return a;
        else return parents[a] = findParents(parents[a]);
    }

    static boolean isSameParents(int a, int b) {
        return findParents(a) == findParents(b);
    }
}