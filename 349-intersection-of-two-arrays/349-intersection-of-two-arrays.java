class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int count = 0;
        Set<Integer> hset1 = new HashSet<>();
        Set<Integer> hset2 = new HashSet<>();
        for(int elements : nums1) {
            hset1.add(elements);
        }
        for(int elements : nums2) {
            if(hset1.contains(elements)) {
                hset2.add(elements);
            }
        }
        int[] result = new int[hset2.size()];
        int index = 0;
        for(int elements: hset2) {
            result[index++] = elements;
        }
        return result;
    }
}