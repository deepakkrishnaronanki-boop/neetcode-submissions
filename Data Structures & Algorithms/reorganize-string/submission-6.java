class Solution {
    public String reorganizeString(String s) {
        
        Map<Character, Integer> charMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for(Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            maxHeap.offer(new int[]{(int) entry.getKey(), entry.getValue()});
        }

        if(maxHeap.peek()[1] > (s.length() + 1) / 2) return "";

        StringBuilder res = new StringBuilder();

        while(maxHeap.size() > 1) {
            int[] a = maxHeap.poll();
            int[] b = maxHeap.poll();
            res.append((char) a[0]).append((char) b[0]);

            a[1]--;
            b[1]--;

            if(a[1] > 0) maxHeap.offer(a);
            if(b[1] > 0) maxHeap.offer(b);
        }

        if(maxHeap.size() > 0) {
            res.append((char) maxHeap.poll()[0]);
        }

        return res.toString();

    }
}