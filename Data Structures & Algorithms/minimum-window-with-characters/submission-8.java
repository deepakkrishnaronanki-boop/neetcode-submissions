class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length()) return "";

        int[] arr = new int[128];

        for(int i = 0;i < t.length();i++) {
            arr[t.charAt(i)]++;
        }

        int l = 0, r = 0, count = t.length(), minLength = Integer.MAX_VALUE, start = 0;

        while (r < s.length()) {

            if(arr[s.charAt(r)] > 0){
                count--;
            }
            arr[s.charAt(r)]--;

            while(count <=0) {
                if(r-l+1 < minLength) {
                    minLength = r-l+1;
                    start = l;
                }
                arr[s.charAt(l)]++;
                if(arr[s.charAt(l)] > 0) count++;
                l++;
            }

            r++;

        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
