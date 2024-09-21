package TreeNode.Trie;

import java.util.List;

// 单词替换
// 在字典中 dictionary 中找出最短的前缀, 替换原句中的单词
public class ReplaceWords {

    static class Trie {
        Trie[] children;
        boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public String shortestPrefixOf(String query) {
            Trie node = this;
            for (int i = 0; i < query.length(); i++) {
                int index = query.charAt(i) - 'a';
                if (node.children[index] == null) {
                    break;
                }
                if (node.children[index].isEnd) {
                    return query.substring(0, i + 1);
                }
                node = node.children[index];
            }
            // 实际查询最短前缀时, 没有应该返回 null, 这里按照题意返回单词本身
            return query;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String prefix : dictionary) {
            trie.insert(prefix);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(trie.shortestPrefixOf(word)).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
