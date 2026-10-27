class Solution {
    public String longestDiverseString(int a, int b, int c) {
        

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((i,j) -> Integer.compare(j[1], i[1]));

        if(a > 0) maxHeap.offer(new int[]{'a', a});
        if(b > 0) maxHeap.offer(new int[]{'b', b});
        if(c > 0) maxHeap.offer(new int[]{'c', c});

        StringBuilder res = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();

            char ch = (char) first[0];

            if(res.length() >= 2 && res.charAt(res.length()-1) == ch
            && res.charAt(res.length()-2) == ch) {
                if(maxHeap.isEmpty()){
                    break;
                }

                int[] second = maxHeap.poll();
                res.append((char) second[0]);
                if(--second[1] > 0) maxHeap.offer(second);
            } else {
                res.append(ch);
                first[1]--;
            }
            if(first[1] > 0) maxHeap.offer(first);

        }

        return maxHeap.isEmpty() ? res.toString() : "";
    }
}