package GFGProblem;

//https://www.geeksforgeeks.org/problems/number-of-provinces/1
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoOfProvinces {
    static class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
            }
        }

        public int findUlParent(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUlParent(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int ulp_u = findUlParent(u);
            int ulp_v = findUlParent(v);
            if (ulp_u == ulp_v) {
                return;
            }
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        DisjointSet ds = new DisjointSet(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                // if there are connected components
                if (adj.get(i).get(j) == 1) {
                    // i and j are connected
                    ds.unionByRank(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (ds.findUlParent(i) == i)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            System.out.println("Enter the vertices:");
            int V = scanner.nextInt();

            for (int i = 0; i < V; i++) {
                System.out.println("Enter the connected components no:");
                int e = scanner.nextInt();
                ArrayList<Integer> temp = new ArrayList<>();
                System.out.println("Enter the edges 0 or 1 by one line two separted space::");
                for (int j = 0; j < e; j++) {
                    temp.add(scanner.nextInt());
                }
                list.add(temp);
            }

            System.out.println("No of provinces is =" + numProvinces(list, V));
        }

    }

}