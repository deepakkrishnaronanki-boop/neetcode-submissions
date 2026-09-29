class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String str : strs) {
            int[] arr = new int[26];

            for(int i = 0;i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();

            for(int i : arr) {
                sb.append(i).append("#");
            }

            anagramMap.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }
}
