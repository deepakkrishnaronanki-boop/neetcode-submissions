class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> res = new ArrayList<>();

        int l = 0, r = arr.length-1;

        while(r - l + 1 > k) {

            int a = Math.abs(arr[l] - x), b = Math.abs(arr[r] - x);

            if(a < b || (a == b && arr[l] < arr[r])){
                r--;
            } else { 
                l++;
            }
        }

        for( int i = l; i <=r; i++){
            res.add(arr[i]);
        }

        return res;
    }
}