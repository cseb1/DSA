import java.util.ArrayList;
import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
public class BellmanFordAlgo {
    // Gfg problem
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int dist[] = new int[V];
        // initialize all are the cell of dist[] is infinite
        Arrays.fill(dist, (int) (1e8));
        dist[S] = 0;
        // this is based on relaxation of V-1 times of edges algorithm
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                // relaxation approach
                if (dist[u] != (int) (1e8) && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // checking the Negetive edges cycle are presented or not
        // iterate N times relaxation operation and check any modify are present or not
        // in dist[] array
        // if any reduces are present then negetive edges cycle are present
        // otherwise not exists
        for (ArrayList<Integer> itr : edges) {
            int u = itr.get(0);
            int v = itr.get(1);
            int wt = itr.get(2);
            if (dist[u] != (int) (1e8) && dist[u] + wt < dist[v]) {
                return new int[] { -1 };
            }
        }
        return dist;
    }

    public static void main(String[] args) {

    }
}
