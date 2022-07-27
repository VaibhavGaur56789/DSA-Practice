class Solution {
    public int countPrimes(int n) {
        
        boolean isPrime[] = new boolean[n];
        Arrays.fill(isPrime, true);
        
        //isPrime[0] = false;
        //isPrime[1] = false;
        
        for(int i=2; i*i<n; i++) {
            for(int j=2*i; j<n; j+=i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for(int i=2; i<n; i++) {
            if(isPrime[i]) {
                count++;
            }
        }
        return count;
        /*
        int count = 0;
        for(int i=2; i<=n; i++) {
            if(isPrime(i) == true) {
                count++;
            }
        }
        return count;
    }
    public static boolean isPrime(int n) {
        for(int i=2; i*i<=n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
        */
        
       
    }
}