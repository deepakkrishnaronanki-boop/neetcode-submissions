class MyHashMap {
    Node[] buckets;
    public MyHashMap() {
        buckets = new Node[1000];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Node(-1, -1);
        }
    }

    private int hash(int key) {
        return key % buckets.length;
    }

    public void put(int key, int value) {
        Node cur = buckets[hash(key)];

        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next.value = value;
                return;
            }
            cur = cur.next;
        }
        cur.next = new Node(key, value);
    }

    public int get(int key) {
        Node cur = buckets[hash(key)];

        while (cur.next != null) {
            if (cur.next.key == key) {
                return cur.next.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        Node cur = buckets[hash(key)];
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
}

class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */