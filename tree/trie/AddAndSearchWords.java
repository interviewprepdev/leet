class WordDictionary {
    TrieNode root = null;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        
        TrieNode cur = root;
        for (char c : word.toCharArray())
        {
            if (cur.children[c - 'a'] == null)
            {
                cur.children[c -'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return recFindWord(word, 0, root);
    }
    
    private boolean recFindWord(String word, int idx, TrieNode root)
    {
        if (idx == word.length() && root.isWord)
        {
            return true;
        }
        else if (idx == word.length())
        {
            return false;
        }

        if (word.charAt(idx) != '.')
        {
            if (root.children[word.charAt(idx) - 'a'] != null)
                return recFindWord(word, idx + 1, root.children[word.charAt(idx) - 'a']);
            else 
                return false;
        }
        //else if (word.charAt(idx) == '.' && idx == 0)
        //{
       //     return recFindWord(word, idx + 1, root);
       // }
        else
        {
            for (int i = 0; i < 26; i++)
            {
                if (root.children[i] != null)
                {
                    if (recFindWord(word, idx + 1, root.children[i]))
                        return true;
                }
            }
        }
        
        return false;
    }
}

class TrieNode
{
    TrieNode[] children;
    boolean isWord;
    public TrieNode()
    {
        children = new TrieNode[26];
        isWord = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
