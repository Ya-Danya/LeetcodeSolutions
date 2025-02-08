package org.example;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        root.insert(word, 0);
    }

    public boolean search(String word) {
        return root.search(word, 0);
    }

    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }

    static class TrieNode {
        TrieNode[] trieNodes;
        boolean isEnd;

        public TrieNode() {
            trieNodes = new TrieNode[26];
        }

        public void insert(String word, int idx) {
            if (idx >= word.length()) return;
            int i = word.charAt(idx) - 'a';
            if (trieNodes[i] == null) trieNodes[i] = new TrieNode();
            if (idx == word.length()-1) trieNodes[i].isEnd = true;
            trieNodes[i].insert(word, idx+1);
        }

        public boolean search(String word, int idx) {
            if (idx >= word.length()) return false;
            TrieNode trieNode = trieNodes[word.charAt(idx) - 'a'];
            if (trieNode == null) return false;
            if (idx == word.length() - 1 && trieNode.isEnd) return true;
            return trieNode.search(word, idx+1);
        }

        public boolean startsWith(String prefix, int idx) {
            if (idx >= prefix.length()) return false;
            TrieNode trieNode = trieNodes[prefix.charAt(idx) - 'a'];
            if (trieNode == null) return false;
            if (idx == prefix.length() - 1) return true;
            return trieNode.startsWith(prefix, idx+1);
        }
    }
}