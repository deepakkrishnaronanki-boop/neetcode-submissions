class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        
        queue1.offer(x);

        while(!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }

        queue2 = queue1;
        queue1 = new LinkedList<>();
    }
    
    public int pop() {
        if(!queue2.isEmpty()) return queue2.poll();

        return -1;
    }
    
    public int top() {
        if(!queue2.isEmpty()) return queue2.peek();

        return -1;
    }
    
    public boolean empty() {
        return queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */