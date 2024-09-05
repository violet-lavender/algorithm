package TreeNode.Trie;

// 字典树, 前缀树
public class Trie {
    // 指向子节点的数组指针. 这里长度为26, 即小写英文字母的数量
    private Trie[] children;
    // 该节点是否为字符串的结尾
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    // 向前缀树中插入字符串 word
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    // 如果字符串 word 在前缀树中, 返回 true(即在检索之前已经插入); 否则, 返回 false
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    // 如果之前已经插入的字符串 word 的前缀之一为 prefix, 返回 true; 否则, 返回 false
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
