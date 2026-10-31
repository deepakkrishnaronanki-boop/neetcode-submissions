class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        

        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length, index = 0;
        int[] res = new int[n - k + 1];

        for(int r = 0; r < n; r++) {

            while(!dq.isEmpty() && nums[r] > nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(r);

            if(r - dq.peekFirst() >= k) {
                dq.pollFirst();
            }

            if(r >= k - 1) {
                res[index++] = nums[dq.peekFirst()];
            }

        }

        return res;
    }
}
