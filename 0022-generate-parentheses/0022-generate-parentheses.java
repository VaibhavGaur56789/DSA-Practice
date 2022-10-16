class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        String balanceParanthesis = "";
        int open = n, close = n;
        solve(open, close, output, balanceParanthesis);
        return output;
    }
    
    public void solve(int open, int close, List<String> output, String balanceParanthesis) {
        if(open == 0 && close == 0) {
            output.add(balanceParanthesis);
            return;
        }
        
        if(open > 0) {
            String openBracket = balanceParanthesis + "(";
            solve(open-1, close, output, openBracket);
        }
        
        if(close > open) {
            String closeBracket = balanceParanthesis + ")";
            solve(open, close-1, output, closeBracket);
        }
    }
}