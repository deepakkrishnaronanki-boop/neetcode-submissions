class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int l = 0, r = arr.length - 1;

        while(r - l + 1 > k) {
            int a = Math.abs(arr[l] - x);
            int b = Math.abs(arr[r] - x);

            if(a < b) {
                r--;
            } else if(a == b && arr[l] < arr[r]) {
                r--;
            } else {
                l++;
            }
        }

        List<Integer> res = new ArrayList<>();

        for(int i = l; i <= r;i++) {
            res.add(arr[i]);
        }
        return res;
    }
}