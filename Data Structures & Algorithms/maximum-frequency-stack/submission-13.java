class FreqStack {

    Map<Integer, Integer> countMap;
    Map<Integer, List<Integer>> freqMap;
    int curMax;
    public FreqStack() {
        countMap = new HashMap<>();
        freqMap = new HashMap<>();
        curMax = 0;
    }
    
    public void push(int val) {
        
        countMap.put(val, countMap.getOrDefault(val, 0) + 1);

        freqMap.computeIfAbsent(countMap.get(val), k -> new ArrayList<>()).add(val);

        curMax = Math.max(curMax, countMap.get(val));
    }
    
    public int pop() {
        
        List<Integer> list = freqMap.get(curMax);

        if(list.size() > 0) {
            int res = list.remove(list.size() - 1);

            if(list.size() == 0) {
                curMax--;
            }

            countMap.put(res, countMap.get(res) - 1);

            return res;
        } 

        return -1;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */