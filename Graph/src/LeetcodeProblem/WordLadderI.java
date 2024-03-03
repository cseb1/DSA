package LeetcodeProblem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderI {
    // https://www.geeksforgeeks.org/problems/word-ladder/1
    static class Pair {
        String first;
        int step;

        public Pair(String first, int step) {
            this.first = first;
            this.step = step;
        }

    }

    public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordList.length; i++) {
            set.add(wordList[i]);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startWord, 1));
        set.remove(startWord);
        while (!queue.isEmpty()) {
            String word = queue.peek().first;
            int step = queue.peek().step;
            queue.remove();
            if (word.equals(targetWord) == true) {
                return step;
            }
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedArray[] = word.toCharArray();
                    replacedArray[i] = ch;
                    String replacedWord = new String(replacedArray);
                    // it exist in the set
                    if (set.contains(replacedWord) == true) {
                        set.remove(replacedWord);
                        queue.add(new Pair(replacedWord, step + 1));
                    }
                }
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        System.out.println(wordLadderLength("der", "dfs", new String[] { "des", "der", "dfr", "dgt", "dfs" }));
    }
}
