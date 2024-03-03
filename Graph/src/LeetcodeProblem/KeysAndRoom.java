package LeetcodeProblem;

//https://leetcode.com/problems/keys-and-rooms/submissions/?envType=study-plan-v2&envId=leetcode-75
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRoom {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.peek();
            queue.remove();
            for (int it : rooms.get(node)) {
                if (visited[it] == false) {
                    visited[it] = true;
                    queue.add(it);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        list.get(0).add(1);
        list.get(0).add(3);
        list.get(1).add(3);
        list.get(1).add(0);
        list.get(1).add(1);
        list.get(2).add(2);
        list.get(3).add(0);

        System.out.println(canVisitAllRooms(list));
    }
}
