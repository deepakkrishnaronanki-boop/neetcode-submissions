class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int major1 = 0, major2 = 0, count1 = 0, count2 = 0, n = nums.length;

        for(int num : nums) {
            if(num == major1) {
                count1++;
            } else if(num == major2) {
                count2++;
            } else if(count1 == 0) {
                major1 = num;
                count1++;
            } else if(count2 == 0) {
                major2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0; count2 = 0;

        for(int num : nums) {
            if(num == major1) count1++;
            if(num == major2) count2++;
        }

        List<Integer> res = new ArrayList<>();

        if(count1 > n / 3) res.add(major1);
        if(count2 > n / 3) res.add(major2);

        return res;
    }
}