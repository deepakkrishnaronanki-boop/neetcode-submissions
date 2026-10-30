class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String first = strs[0];

        for(int i = 0;i < first.length();i++) {
            for(int j = 1;j < strs.length;j++) {

                if(strs[j].length() == i || strs[j].charAt(i) != first.charAt(i)) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }
}