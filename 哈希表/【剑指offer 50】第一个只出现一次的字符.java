class Solution {
    public char firstUniqChar(String s) {
        Map<Character,Boolean> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for(char c:chars){
            map.put(c,!map.containsKey(c));
        }

        //遍历有序哈希表
        for(Map.Entry<Character,Boolean> es:map.entrySet()){
            if(es.getValue()) return es.getKey();
        }
        return ' ';
    }
}
