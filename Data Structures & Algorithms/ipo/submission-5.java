class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        PriorityQueue<int[]> minCapital = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> maxProfit = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));

        for(int i = 0; i < profits.length; i++) {
            minCapital.offer(new int[]{capital[i], profits[i]});
        }

        for(int i = 0; i < k; i++) {
            while(!minCapital.isEmpty() && w >= minCapital.peek()[0]) {
                maxProfit.offer(minCapital.poll());
            }

            if(maxProfit.isEmpty()) break;

            w += maxProfit.poll()[1];
        }

        return w;
    }
}