class WordDictionary {

    private Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie cur = root;

        for(char c : word.toCharArray()) {
            if(cur.node[c - 'a'] == null) {
                cur.node[c - 'a'] = new Trie();
            }
            cur = cur.node[c - 'a'];
        }
        cur.leaf = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, Trie root) {
        Trie cur = root;

        for(int j = i;j < word.length(); j++) {
            char c = word.charAt(j);

            if(c == '.') {
                if(cur == null) return false;
                for(Trie child : cur.node) {
                    if(child != null && dfs(word, j+1, child)) return true;
                }
                return false;
            } else {
                if(cur.node[c-'a'] == null) return false;
                cur = cur.node[c-'a'];
            }
        }
        return cur.leaf;
    }
}


class Trie {
    Trie[] node;
    boolean leaf;

    public Trie() {
        node = new Trie[26];
        leaf = false;
    }
}