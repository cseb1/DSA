import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
public class KruskalsAlgorithm extends DisJointSetDSA {
    static class Edges implements Comparable<Edges> {
        int first; // src
        int second; // dest
        int third; // weight

        public Edges(int f, int s, int t) {
            this.first = f;
            this.second = s;
            this.third = t;
        }

        public int compareTo(Edges compareEdge) {
            return this.third - compareEdge.third;
        }
    };

    public static int spanningTree(int V, int E, int edges[][]) {
        List<Edges> adj = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int wt = edges[i][2];
            adj.add(new Edges(src, dest, wt));
            adj.add(new Edges(dest, src, wt));
        }
        Collections.sort(adj);
        int mstSum = 0;
        DisjointSet ds = new DisjointSet(V);
        for (int i = 0; i < adj.size(); i++) {
            int src = adj.get(i).first;
            int dest = adj.get(i).second;
            int wt = adj.get(i).third;

            if (ds.findUlParent(src) != ds.findUlParent(dest)) {
                mstSum += wt;
                ds.unionByRank(src, dest);
            }
        }
        return mstSum;
    }

    public static void main(String[] args) {
        System.out.println(spanningTree(3, 3, new int[][] { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } }));
    }
}
