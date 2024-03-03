package LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Wordladder {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int len = wordList.size();
        String[] word = new String[len];
        for (int i = 0; i < len; i++) {
            word[i] = wordList.get(i);
        }
        return findSequences(beginWord, endWord, word);
    }

    public static List<List<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> st = new HashSet<>();
        for (int i = 0; i < wordList.length; i++) {
            st.add(wordList[i]);
        }
        List<String> usedOn = new ArrayList<>();
        Queue<List<String>> q = new LinkedList<>();
        List<String> ls = new ArrayList<>();
        ls.add(startWord);
        usedOn.add(startWord);
        q.add(ls);
        int level = 0;
        while (!q.isEmpty()) {
            List<String> vec = q.peek();
            q.remove();

            // erase all the previous checking word
            if (vec.size() > level) {
                level++;
                for (String it : usedOn) {
                    st.remove(it);
                }
                usedOn.clear();
            }

            String currWord = vec.get(vec.size() - 1);// last word
            // check this is target word or not
            if (currWord.equals(targetWord)) {
                if (ans.size() == 0) { // first time we reached our destinaion path
                    ans.add(vec);
                } else if (ans.get(0).size() == vec.size()) {
                    ans.add(vec);
                }
            }
            // check the all sub query
            for (int i = 0; i < currWord.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedArray[] = currWord.toCharArray();
                    replacedArray[i] = ch;
                    String replacedWord = new String(replacedArray);
                    // it exist in the set
                    if (st.contains(replacedWord) == true) {
                        vec.add(replacedWord);
                        // java works by reference
                        List<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        // mark as visited n the level
                        usedOn.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("pat");
        list.add("bot");
        list.add("pot");
        list.add("poz");
        list.add("coz");
        System.out.println(findLadders("bat", "coz", list));
    }
}
