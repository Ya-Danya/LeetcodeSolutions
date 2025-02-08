package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashTrie trie = new HashTrie();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            trie.insert(sc.next());
        }

        System.out.println("Sus");
    }
}
