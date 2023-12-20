package leetCodeProblem;

import java.util.Arrays;
import java.util.Scanner;

public class GamesOfTwoStacks {
    static int twoStacks(int s, int x[], int[] y) {
        return twoStacks(s, x, y, 0, 0) - 1;
    }

    private static int twoStacks(int s, int[] x, int[] y, int sum, int count) {

        // Base case

        if (sum > s) {
            return count;
        }

        if (x.length == 0 || y.length == 0) {
            return count;
        }
        int ans1 = twoStacks(s, Arrays.copyOfRange(x, 1, x.length), y, sum + x[0], count + 1);
        int ans2 = twoStacks(s, x, Arrays.copyOfRange(y, 1, y.length), sum + y[0], count + 1);
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the games no:::");
            int t = sc.nextInt();
            for (int i = 0; i < t; i++) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int s = sc.nextInt();
                int[] a = new int[n];
                int[] b = new int[m];
                for (int j = 0; j < n; j++) {
                    a[j] = sc.nextInt();
                }

                for (int j = 0; j < b.length; j++) {
                    b[j] = sc.nextInt();
                }

                System.out.println("Ans::" + twoStacks(s, a, b));
            }
        }

    }
}
