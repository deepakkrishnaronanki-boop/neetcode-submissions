class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()) return false;

        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            s1Arr[s1.charAt(i)-'a']++;
        }

        int i = 0;
        for(int j = 0; j < s2.length(); j++) {
            
            s2Arr[s2.charAt(j)-'a']++;

            if(j - i + 1 > s1.length()) {
                s2Arr[s2.charAt(i++)-'a']--;
            }

            if(Arrays.equals(s1Arr, s2Arr)) return true;

        }

        return false;
    }
}
