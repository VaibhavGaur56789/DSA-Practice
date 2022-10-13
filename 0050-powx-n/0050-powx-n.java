class Solution {
    public double myPow(double x, int n) {
        return n>0 ? recursion(x,n) : 1/recursion(x, -n);       
    }
    
    public double recursion(double x, int n) {
        if(n == 0)
            return 1.0;
        
        double result = recursion(x, n/2);
        return (n % 2 == 0) ? result * result : x * result * result;
    }
}