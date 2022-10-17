class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> in = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        for(int i: nums) {
            in.add(i);
        }
        solve(in, op);
        return res;
    }
    
    public void solve(List<Integer> in, List<Integer> op) {
        if(in.size() == 0) { //base condition
            res.add(op);
            return;
        }
        
        List<Integer> output1 = new ArrayList<>(op);
        List<Integer> output2 = new ArrayList<>(op);
        
        output1.add(in.get(0));
        
        List<Integer> input = new ArrayList<>(in);
        input.remove(0);
        solve(input, output1);
        solve(input, output2);
        
        return;
    }
}