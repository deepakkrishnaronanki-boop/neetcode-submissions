class Solution {
    public boolean isAnagram(String s, String t) {
        int slen = s.length(), tlen = t.length();

        if(slen != tlen) return false;

        int[] sarr = new int[26];
        int[] tarr = new int[26];

        for(int i = 0; i < slen; i++) {
            sarr[s.charAt(i)-'a']++;
            tarr[t.charAt(i)-'a']++;
        }

        return Arrays.equals(sarr, tarr);
    }
}
