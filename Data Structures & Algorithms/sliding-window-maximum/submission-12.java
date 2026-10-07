class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {

            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            while(i - dq.peekFirst() >= k) {
                dq.pollFirst();
            }

            if(i >= k-1) {
                res[index++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}
