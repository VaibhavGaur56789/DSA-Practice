class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findCombinations(0, candidates, target, ds, ans);
        return ans;
    }
    
    public void findCombinations(int index, int[] candidates, int target, List<Integer> ds, List<List<Integer>> ans) {
        if(index == candidates.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        if(candidates[index] <= target) {
            ds.add(candidates[index]); //remove ds while coming back
            findCombinations(index, candidates, target - candidates[index], ds, ans); //recursion for pick
            ds.remove(ds.size() - 1);
        }
        findCombinations(index + 1, candidates, target, ds, ans); //recursion for not-pick
    }
}