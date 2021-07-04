class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right)
        {
            int mid = (left + right)/2;
            if (x - arr[mid] > arr[mid + k] - x)
            {
                left = mid + 1; // having left first is important -- have to figure out corner cases
            }
            else
            {
                right = mid;
            }
        }
        List<Integer> al = new ArrayList<Integer>();
        for (int i = left; i < (left + k); i++)
        {
            al.add(arr[i]);
        }
        
        return al;
    }
}
