class PrefixTree {

    private Trie root;
    public PrefixTree() {
         root = new Trie();
    }

    public void insert(String word) {
        Trie cur = root;
        for(char c : word.toCharArray()) {
            if(cur.node[c - 'a'] == null) {
                cur.node[c - 'a'] = new Trie();
            }
            cur = cur.node[c - 'a'];
        }
        cur.isLeaf = true;
    }

    public boolean search(String word) {
        Trie cur = root;
        for(char c : word.toCharArray()) {
            if(cur.node[c - 'a'] == null) return false;
            cur = cur.node[c-'a'];
        }
        return cur.isLeaf;
    }

    public boolean startsWith(String prefix) {
        Trie cur = root;
        for(char c : prefix.toCharArray()) {
            if(cur.node[c - 'a'] == null) return false;
            cur = cur.node[c-'a'];
        }
        return true;
    }
}

class Trie {
    Trie[] node;
    boolean isLeaf;

    public Trie() {
        node = new Trie[26];
        isLeaf = false;
    }
}
