class Solution {
    public int[] getOrder(int[][] tasks) {
        
        for(int i = 0; i < tasks.length; i++) {
            tasks[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }

        Arrays.sort(tasks, (a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0] - b[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

        int index = 0;
        int time = 0;
        int i = 0;

        int[] res = new int[tasks.length];

        while(i < tasks.length || !minHeap.isEmpty()) {
            while(i < tasks.length && time >= tasks[i][0]) {
                minHeap.offer(tasks[i++]);
            }

            if(minHeap.isEmpty()) {
                time = tasks[i][0];
                continue;
            }

            int[] task = minHeap.poll();
            time += task[1];
            res[index++] = task[2];
        }

        return res;
    }
}