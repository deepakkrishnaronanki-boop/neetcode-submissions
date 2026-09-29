class MyHashMap {

    Node[] buckets;
    public MyHashMap() {
        buckets = new Node[769];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new Node();
        }
    }

    private int hash(int key) {
        return key % buckets.length;
    }
    
    public void put(int key, int value) {
        Node node = buckets[hash(key)];

        while(node.next != null) {
            if(node.next.key == key) {
                node.next.value = value;
                return;
            }
            node = node.next;
        }

        node.next = new Node(key, value);
    }
    
    public int get(int key) {
        Node node = buckets[hash(key)];

        while(node.next != null) {
            if(node.next.key == key) {
                return node.next.value;
            }
            node = node.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        Node node = buckets[hash(key)];

        while(node.next != null) {
            if(node.next.key == key) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
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

    public Node() {
        this(-1, -1);
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */