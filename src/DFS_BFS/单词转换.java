package DFS_BFS;

import java.util.*;

/**
 * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。
 *
 * 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。
 */

public class 单词转换 {

    public static boolean check(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int flag = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i) && flag++ != 0) {
                return false;
            }
        }
        return true;
    }

    public static LinkedList<String> dfs(String beginWord, String endWord, List<String> wordList,Set<String> visited) {

        //函数出口
        if (beginWord.equals(endWord)) {
            LinkedList<String> collector = new LinkedList<>();
            collector.addFirst(beginWord);
            return collector;
        }

        visited.add(beginWord);

        for (String word : wordList) {
            if (visited.contains(word)) {
                continue;
            }
            if (check(beginWord,word)) {
                LinkedList<String> res = dfs(word,endWord,wordList,visited);
                if (!res.isEmpty()) {
                    res.addFirst(beginWord);
                    return res;
                }
            }
        }

        return new LinkedList<>();
    }

    public static List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> res = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return res = new ArrayList<>();
        }
        if (beginWord.equals(endWord)) {
            res.add(beginWord);
            return res;
        }
        return dfs(beginWord,endWord,wordList,new HashSet<>());
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("cog");
        List<String> res = new ArrayList<>();
        res = findLadders(beginWord,endWord,wordList);
        for (String re : res) {
            System.out.println(re);
        }
        System.out.println(check("hot","hit"));
    }

}
