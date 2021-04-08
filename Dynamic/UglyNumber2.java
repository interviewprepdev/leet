class Solution {
    public int nthUglyNumber(int n) {
      // save all uglynumbers in array
      // always try to find the next min number that is a factor of 2, 3, 5
      // reason for min of 2, 3, 5 here is ugly number should only have 2, 3, 5 as factors
      // more explnation and ref here: https://leetcode.com/problems/ugly-number-ii/discuss/69364/My-16ms-C%2B%2B-DP-solution-with-short-explanation
         if (n <= 1) return n;
         int ptr2=0, ptr3=0, ptr5=0;
         int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++)
        {
            ugly[i] = Math.min(2 * ugly[ptr2], Math.min(3 * ugly[ptr3], 5 * ugly[ptr5]));
            if (ugly[i] == ugly[ptr2] * 2) ptr2++;
            if (ugly[i] == ugly[ptr3] * 3) ptr3++;
            if (ugly[i] == ugly[ptr5] * 5) ptr5++;
        }
        return ugly[n-1];   
    }
}
