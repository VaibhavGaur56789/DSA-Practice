class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        HashMap<Character, Character> hmap = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char p1 = s.charAt(i);
            char p2 = t.charAt(i);
            
            if(hmap.containsKey(p1)) {
                if(hmap.get(p1) != p2) 
                    return false;
            }
            else if(hmap.containsValue(p2)) {
                return false;
            }
            else {
                hmap.put(p1, p2);
            }
        }
        return true;
    }
}