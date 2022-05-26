class Solution {
    public boolean isUgly(int n) {
        if(n < 1)
            return false;
        
        n = uglySol(n, 2);
        n = uglySol(n, 3);
        n = uglySol(n, 5);
        
        return n == 1;
    }
    
    public int uglySol(int n, int b) { //a --> num, b --> 2, 3, 5
        while(n % b == 0) {
            n = n/b;
        }
        return n;
    }
}