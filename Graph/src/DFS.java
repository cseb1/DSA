import java.util.Iterator;
import java.util.Stack;

class Dept_first extends Graph {
    public Dept_first(int v) {
        super(v);
    }

    public void dfs(int s) {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[getVertex()];

        visited[s] = true;
        stack.push(s);
        while (!stack.isEmpty()) {
            s = stack.pop();
            System.out.print(s + " ");
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    stack.push(n);
                }
            }
        }
    }
}

public class DFS {

    public static void main(String[] args) {
        Dept_first g = new Dept_first(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 4);
        g.addEdge(3, 1);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 2);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 3);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 5);

        g.dfs(0);

    }
}
