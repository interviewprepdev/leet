// Taken from https://leetcode.com/problems/count-primes/discuss/57588/My-simple-Java-solution
Notes: Why having upper limit as sqrt(n) ?  because the factors of any number cannot be greater than sqrt(n) * sqrt(n)  n = a*b, here a and b both cannot be greater than sqrt(n)
public int countPrimes(int n) {
        if(n <= 2) return 0;
        int ans = 1;// don't forget to record 2. :-)
        boolean[] isCompositeArr = new boolean[n];
        int upper = (int) Math.sqrt(n);
        for(int i = 3;i < n;i=i+2){//1.scan only odd number
            if(isCompositeArr[i]) continue;
            ans++;
            if(i > upper) continue;//2. avoid i^2 overflow.
            for(int j = i*i; j < n;j = j + 2*i){//3. initialize j to i^2
                                                //4. increase 2i to keep j as an odd number
                
                isCompositeArr[j] = true;
            }
        }
        return ans;
    }
