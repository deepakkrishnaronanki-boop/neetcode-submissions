class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int major1 = 0, count1 = 0, major2 = 0, count2 = 0;

        for(int num : nums) {
            if(major1 == num) {
                count1++;
            } else if(major2 == num) {
                count2++;
            } else if(count1 == 0) {
                count1++;
                major1 = num;
            } else if (count2 == 0) {
                count2++;
                major2 = num;
            } else {
                count1--;
                count2--;
            }
        }

        int n = nums.length;

        List<Integer> res = new ArrayList<>();

        count1 = 0; count2 = 0;

        for(int i = 0;i < n; i++) {
            if(nums[i] == major1) {
                count1++;
            } else if(nums[i] == major2) {
                count2++;
            }
        }

        if(count1 > n / 3) res.add(major1);
        if(count2 > n / 3) res.add(major2);

        return res;
    }
}