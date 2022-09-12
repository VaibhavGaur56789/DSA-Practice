class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        hmap.put('I', 1);
        hmap.put('V', 5);
        hmap.put('X', 10);
        hmap.put('L', 50);
        hmap.put('C', 100);
        hmap.put('D', 500);
        hmap.put('M', 1000);
        
        char ch = s.charAt(s.length()-1); //last char at ch
        int res = hmap.get(ch);
        for(int i = s.length() - 2; i >= 0; i--) {
            char ch_i = s.charAt(i);
            char ch_iplusone = s.charAt(i+1);
            if(hmap.get(ch_i) < hmap.get(ch_iplusone)) {
                res = res - hmap.get(ch_i);
            }
            else {
                res = res + hmap.get(ch_i);
            }
        }
        return res;
    }
}