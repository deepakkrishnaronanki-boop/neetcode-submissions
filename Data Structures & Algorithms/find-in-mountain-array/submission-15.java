/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int l = 1, r = mountainArr.length()-2, pivot = 0;

        while(l <= r) {
            int m = l + (r-l) / 2;

            int prev = mountainArr.get(m-1), mid = mountainArr.get(m), next = mountainArr.get(m + 1);

            if(prev < mid && mid > next) {
                pivot = m;
                break;
            } else if(prev < mid && mid < next) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        l = 0; r = pivot;

        while(l <= r) {
            int m = l + (r - l) / 2;
            int val = mountainArr.get(m);
            if(val == target) {
                return m;
            } else if(val < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        l = pivot + 1; r = mountainArr.length()-1;

        while(l <= r) {
            int m = l + (r - l) / 2;
            int val = mountainArr.get(m);

            if(val == target) {
                return m;
            } else if(val > target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }
}