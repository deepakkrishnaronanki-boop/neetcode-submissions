class FreqStack {
    Map<Integer, Stack<Integer>> stackMap;
    Map<Integer, Integer> freqMap;
    int max;

    public FreqStack() {
        stackMap = new HashMap<>();
        freqMap = new HashMap<>();
        max = 0;
    }
    
    public void push(int val) {
        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        int count = freqMap.get(val);
        max = Math.max(count, max);
        stackMap.computeIfAbsent(count, k -> new Stack<>()).push(val);

    }
    
    public int pop() {
        int val = stackMap.get(max).pop();
        freqMap.put(val, freqMap.get(val) - 1);
        if(stackMap.get(max).isEmpty()) max--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */