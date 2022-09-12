class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int paranthesis = 0;
        for(char c: s.toCharArray()) {
            if(c == '(')
                paranthesis++;
            if(c == ')')
                paranthesis--;
            maxDepth = Math.max(maxDepth, paranthesis);
        }
        return maxDepth;
    }
}