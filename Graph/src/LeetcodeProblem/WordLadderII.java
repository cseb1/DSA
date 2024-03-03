package LeetcodeProblem;

//https://www.geeksforgeeks.org/problems/word-ladder-ii/1
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
    public static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Set<String> st = new HashSet<>();
        for (int i = 0; i < wordList.length; i++) {
            st.add(wordList[i]);
        }
        ArrayList<String> usedOn = new ArrayList<>();
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        usedOn.add(startWord);
        q.add(ls);
        int level = 0;
        while (!q.isEmpty()) {
            ArrayList<String> vec = q.peek();
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
                        ArrayList<String> temp = new ArrayList<>(vec);
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
        System.out.println(findSequences("bat", "coz", new String[] { "pat", "bot", "pot", "poz", "coz" }));
    }
}
