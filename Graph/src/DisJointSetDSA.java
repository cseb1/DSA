import java.util.ArrayList;
import java.util.List;

public class DisJointSetDSA {
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

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);
        // if 3 and 7 are same component or not

        if (ds.findUlParent(3) == ds.findUlParent(7)) {
            System.out.println("same component");
        } else {
            System.out.println("Not Same component");
        }
        ds.unionByRank(3, 7);
        if (ds.findUlParent(3) == ds.findUlParent(7)) {
            System.out.println("same component");
        } else {
            System.out.println("Not Same component");
        }
    }
}
