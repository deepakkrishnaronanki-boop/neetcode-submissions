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
        
        int l = 0, r = mountainArr.length()-1, pivot = 0;

        while(l < r) {
            int m = l + (r-l) / 2;

            if(mountainArr.get(m) < mountainArr.get(m + 1)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        pivot = l;
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