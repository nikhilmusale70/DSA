package DailyChallenge.Feb24;

import java.util.*;

public class Feb24_2092 {
    public static void main(String[] args) {
        int n = 6;
        int[][] meetings = {{1,2,5},{2,3,8},{1,5,10}};
        int firstPerson = 1;
        Feb24_2092 obj = new Feb24_2092();
        System.out.println(obj.findAllPeople(n, meetings, firstPerson));
    }
    public List<Integer> findAllPeople(int N, int[][] A, int P)
    {
        List<int[]>[] adj = new ArrayList[N];

        for(int i=0; i<N; ++i)
            adj[i] = new ArrayList<>();

        adj[0].add(new int[] { P, 0 });
        adj[P].add(new int[] { 0, 0 });

        for(int[] i: A) {
            adj[i[0]].add(new int[] { i[1], i[2] });
            adj[i[1]].add(new int[] { i[0], i[2] });
        }

        Set<Integer> res = new HashSet<>();

        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.offer(new int[] { 0, 0 });
        q.offer(new int[] { P, 0 });

        while(!q.isEmpty()) {

            int[] cur = q.poll();
            int curP = cur[0], curT = cur[1];

            if(res.contains(curP))
                continue;

            res.add(curP);

            for(int[] child: adj[curP]) {

                if(res.contains(child[0]) || child[1] < curT)
                    continue;

                q.offer(child);
            }
        }

        return new ArrayList<>(res);
    }
}
