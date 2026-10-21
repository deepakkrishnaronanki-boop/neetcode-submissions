class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones) {
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1) {
            int stoneA = maxHeap.poll(), stoneB = maxHeap.poll();
            if(stoneA != stoneB) {
                maxHeap.offer(Math.abs(stoneA-stoneB));
            } 
        }

        return maxHeap.size() > 0 ? maxHeap.poll() : 0;
    }
}
