class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String i : strs){
            char[] c = i.toCharArray();
            Arrays.sort(c);

            String key = new String(c);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(i);
        }
        return new ArrayList<>(map.values());
    }
}
