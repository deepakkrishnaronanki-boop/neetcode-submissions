class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        Arrays.sort(trips, (a,b) -> Integer.compare(a[1], b[1]));

        int passengers = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));

        for(int[] trip : trips) {
            while(!minHeap.isEmpty() && minHeap.peek()[2] <= trip[1]) {
                passengers -= minHeap.poll()[0];
            }

            passengers += trip[0];

            if(passengers > capacity) return false;

            minHeap.offer(trip);
        }

        return true;
    }
}