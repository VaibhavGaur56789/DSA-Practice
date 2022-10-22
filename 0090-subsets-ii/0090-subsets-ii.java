class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); //sorting else we wont be able to find duplicate
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findSubset(0, nums, ds, ansList);
        return ansList;
    }
    
    public void findSubset(int index, int[] nums,  List<Integer> ds,List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds));
        for(int i=index; i<nums.length; i++) {
            if(i != index && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            findSubset(i+1, nums,  ds, ansList);
            ds.remove(ds.size()-1);
        }
    }
}