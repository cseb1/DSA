import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
public class Dijikstras {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int ans[] = new int[V];
        Arrays.fill(ans, (int) 1e9);
        Queue<Pair> q = new PriorityQueue<Pair>((x, y) -> x.first - y.first);
        ans[S] = 0;
        q.add(new Pair(0, S));

        // just simple bfs
        while (!q.isEmpty()) {
            int node = q.peek().second;
            int dis = q.peek().first;
            q.remove();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeweight = adj.get(node).get(i).get(1);
                int adjnode = adj.get(node).get(i).get(0);

                if (dis + edgeweight < ans[adjnode]) {
                    ans[adjnode] = dis + edgeweight;
                    q.add(new Pair(ans[adjnode], adjnode));
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
