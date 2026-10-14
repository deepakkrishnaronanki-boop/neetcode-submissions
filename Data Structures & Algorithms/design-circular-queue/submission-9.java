class MyCircularQueue {

    int size;
    int capacity;
    ListNode head;
    ListNode tail;
    public MyCircularQueue(int k) {
        head = new ListNode(-1);
        tail = head;
        size = 0;
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        if(size >= capacity) return false;
        ListNode node = new ListNode(value);
        tail.next = node;
        tail = node;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(size == 0) return false;

        if(head.next == tail) {
            head.next = null;
            tail = head;
        } else {
            head.next = head.next.next;
        }
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;

        return head.next.val;
    }
    
    public int Rear() {
        if(isEmpty()) return -1;

        return tail.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }


}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */