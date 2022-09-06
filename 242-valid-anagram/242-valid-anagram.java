class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1); //put frequency of character in hashmap
        }
        
        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            if(hmap.containsKey(ch) == false) { //if ch is not present in hashmap
                return false;
            }
            else if(hmap.get(ch) == 1) { //if ch frequency is 1, remove it
                hmap.remove(ch);
            }
            else {
                hmap.put(ch, hmap.get(ch) - 1); //else decrease ch frequency by 1
            }
        }
        return hmap.size() == 0; //if size of hashmap is 0
    }
}