package org.example;

import java.util.HashMap;
import java.util.Map;

public class HashTrie {
    public static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            isWord = false;
        }

        public TrieNode(boolean isWord) {
            children = new HashMap<Character, TrieNode>();
            this.isWord = isWord;
        }
    }

    TrieNode root;

    public HashTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return false;
            }
        }

        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (char c : prefix.toCharArray()) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return false;
            }
        }

        return true;
    }
}
