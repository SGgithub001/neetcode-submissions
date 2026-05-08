class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        int n = strs.length;
        for(int i = 0; i < strs.length; i++){
            String temp = strs[i];
            char[] ch = temp.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
           map.get(key).add(temp);
        }
        return new ArrayList<>(map.values());
    }
}
