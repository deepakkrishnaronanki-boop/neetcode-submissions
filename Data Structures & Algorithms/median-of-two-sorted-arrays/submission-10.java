class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l = 0, r = n1;

        while(l <= r) {
            int m = l + (r - l) / 2;
            int n = (n1 + n2 + 1) / 2 - m;

            int ALeft = m == 0 ? Integer.MIN_VALUE : nums1[m-1];
            int ARight = m == n1 ? Integer.MAX_VALUE : nums1[m];

            int BLeft = n == 0 ? Integer.MIN_VALUE : nums2[n-1];
            int BRight = n == n2 ? Integer.MAX_VALUE : nums2[n];

            if(ALeft <= BRight && BLeft <= ARight) {
                if((n1 + n2) % 2 == 0) {
                    return (Math.max(ALeft, BLeft) + Math.min(BRight, ARight)) / 2.0;
                } else {
                    return Math.max(ALeft, BLeft);
                }
            } else if (ALeft > BRight) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return 0;
    }
}
