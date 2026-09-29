class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];

        for(int i = 0; i < first.length();i++) {
            for(String str : strs) {
                if(i == str.length() || first.charAt(i) != str.charAt(i)) {
                    return first.substring(0, i);
                }
            }
        }

        return first;
    }
}