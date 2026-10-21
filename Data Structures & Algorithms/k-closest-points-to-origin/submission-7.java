class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);

        for(int[] point : points) {
            int x = point[0], y = point[1];
            maxHeap.offer(new int[]{x*x + y*y, x, y});

            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int index = 0;
        while(!maxHeap.isEmpty()) {
            int[] point = maxHeap.poll();
            res[index++] = new int[]{point[1], point[2]};
        }

        return res;
        
    }
}
