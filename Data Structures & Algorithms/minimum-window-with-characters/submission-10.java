class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length() < t.length()) return "";

        int[] arr = new int[128];

        for(int i = 0; i< t.length(); i++) {
            arr[t.charAt(i)]++;
        }

        int count = t.length(), minLen = Integer.MAX_VALUE, start = 0, l = 0;

        for(int r = 0; r < s.length(); r++) {

            if(arr[s.charAt(r)] > 0) {
                count--;
            }

            arr[s.charAt(r)]--;

            while(count <= 0) {
                if(r - l + 1 < minLen) {
                    start = l;
                    minLen = r-l+1;
                }
                arr[s.charAt(l)]++;
                if(arr[s.charAt(l)] > 0) {
                    count++;
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}
