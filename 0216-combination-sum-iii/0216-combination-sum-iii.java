class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findCombinations(1, ans, ds, k, n); //index -> 1 to 9
        return ans;
    }
    
    public void findCombinations(int index, List<List<Integer>> ans, List<Integer> ds, int combination, int target) {
        if(target == 0 && combination == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=index; i<=9; i++) {
            ds.add(i);
            findCombinations(i+1, ans, ds, combination-1, target - i); //pick
            ds.remove(ds.size() - 1);
        }
    }
}