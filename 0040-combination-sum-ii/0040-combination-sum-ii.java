class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> ds = new ArrayList<>();
        findCombinations(0, candidates, target, ds, ans);
        return ans;
    }

    public void findCombinations(int index, int[] candidates, int target, List<Integer> ds, List<List<Integer>> ans) {
            if(target == 0) {
                ans.add(new ArrayList<>(ds));
                return;
            }      
        
        for(int i=index; i<candidates.length; i++) {
            if(i>index && candidates[i] == candidates[i-1])
                continue;
            if(candidates[i] > target) 
                break;
            ds.add(candidates[i]);
            findCombinations(i+1, candidates, target - candidates[i], ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
}