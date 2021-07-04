
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
         Map<Character, Integer> hmChCount = new HashMap<>();
        int begin = 0, end = 0, counter = 0;
        int max = 0;
        while (end < s.length())
        {
            char cur = s.charAt(end);
            hmChCount.put(cur, hmChCount.getOrDefault(cur, 0) + 1);
            if (hmChCount.get(cur) > 1)
            {
                counter = 1;
            }
            end++;
            
            while (counter == 1)
            {
                cur = s.charAt(begin);
                int c = hmChCount.get(cur);
                if (c > 1)
                {
                    counter = 0;
                }
                hmChCount.put(cur, c - 1);
                begin++;
            }
            max = Math.max(max, end - begin);            
        }
        
        return max;
    }
}
