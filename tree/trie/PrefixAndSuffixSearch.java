// https://leetcode.com/problems/prefix-and-suffix-search/

class WordFilter {
    TrieNode trie;
    public WordFilter(String[] words) {
      trie = new TrieNode();
        for (int wt = 0; wt < words.length; wt++)
        {
            String word = words[wt] + "{";        
            for (int i = 0; i < word.length(); i++)
            {
                TrieNode cur = trie;
                cur.weight = wt;
                for (int j = i; j < word.length() * 2  - 1; j++)
                {
                    int k = word.charAt(j % word.length()) - 'a';
                    if (cur.children[k] == null)
                    {
                        cur.children[k] = new TrieNode();
                    }
                    cur = cur.children[k];
                    cur.weight = wt;
                }
            }
        }
    }
    public int f(String prefix, String suffix) {
        TrieNode cur = trie;
        String toSearch = suffix +"{"+ prefix;
        for (char c : toSearch.toCharArray())
        {
            if (cur.children[c - 'a'] == null) 
            {
                return -1;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.weight;
    }
    
    class TrieNode
    {
        TrieNode[] children;
        int weight;
        public TrieNode()
        {
            children = new TrieNode[27];
            weight = 0;
        }
    }
}
