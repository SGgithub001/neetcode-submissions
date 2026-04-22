class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String words = strs[i];
            char[] letters = words.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(words);
        }
         return new ArrayList<>(map.values());
    }
}
