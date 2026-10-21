class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        Queue<int[]> queue = new LinkedList<>();
        Map<Character, Integer> freq = new HashMap<>();

        for(char c : tasks) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int cycles = 0;

        for(Map.Entry<Character, Integer> entry : freq.entrySet()) {
            maxHeap.offer(new int[]{entry.getValue(), 0});
        }

        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            cycles++;
            if(!maxHeap.isEmpty()) {
                int[] task = maxHeap.poll();
                task[0]--;
                if(task[0] > 0) {
                    task[1] = cycles + n;
                    queue.offer(task);
                }
            }

            if(!queue.isEmpty() && cycles >= queue.peek()[1]){
                maxHeap.offer(queue.poll());
            }
        }

        return cycles;
    }
}
