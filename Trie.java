class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // a–z
        isEndOfWord = false;
    }
}

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /* ===== Insert ===== */
    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c < 'a' || c > 'z') {
                System.out.println("Only lowercase a-z allowed");
                return;
            }

            int index = c - 'a';
            if (current.children[index] == null)
                current.children[index] = new TrieNode();

            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    /* ===== Search full word ===== */
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord;
    }

    /* ===== StartsWith ===== */
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    /* ===== Delete word ===== */
    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord)
                return false;

            current.isEndOfWord = false;
            return isEmpty(current);
        }

        int c = word.charAt(index) - 'a';
        if (current.children[c] == null)
            return false;

        boolean shouldDelete = delete(current.children[c], word, index + 1);

        if (shouldDelete) {
            current.children[c] = null;
            return !current.isEndOfWord && isEmpty(current);
        }
        return false;
    }

    private boolean isEmpty(TrieNode node) {
        for (int i = 0; i < 26; i++)
            if (node.children[i] != null)
                return false;
        return true;
    }

    /* ===== Print all words ===== */
    public void print() {
        print(root, "");
    }

    private void print(TrieNode node, String word) {
        if (node.isEndOfWord)
            System.out.println(word);

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null)
                print(node.children[i], word + (char) (i + 'a'));
        }
    }

    /* ===== Helper ===== */
    private TrieNode searchNode(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c < 'a' || c > 'z')
                return null;

            int index = c - 'a';
            if (current.children[index] == null)
                return null;

            current = current.children[index];
        }
        return current;
    }
}
