class Solution {
  //  [2147483647,-1,2147483647]
//1
//2147483647 remember to run for this corner case, (long) t + 1 and ((long)(t+1)) makes a difference here
  // https://leetcode.com/problems/contains-duplicate-iii/submissions/ 
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
     if (k < 1 || t < 0){
         return false;
     }
        Map<Long, Long> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            long n = (long) nums[i] - Integer.MIN_VALUE;
            long b  = n /((long)t + 1);
            if (hm.containsKey(b) || 
                (hm.containsKey(b + 1) && ((hm.get(b + 1) - n) <= t)) || 
                 (hm.containsKey(b - 1) && (n - hm.get(b - 1) <= t)))
                {
                    return true;
                }
            if (hm.entrySet().size() >= k) {
                long removeKey = ((long)nums[i - k] - Integer.MIN_VALUE) / ((long) t+ 1);
                hm.remove(removeKey);
            }
                hm.put(b, n);
        }   
        return false;
     
    }
}

