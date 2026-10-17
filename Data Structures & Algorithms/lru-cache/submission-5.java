class LRUCache {
    private Node left;
    private Node right;
    private int size;
    private Map<Integer, Node> nodeMap;
    public LRUCache(int capacity) {
        left = new Node(-1, -1);
        right = new Node(-1, -1);
        left.next = right;
        right.prev = left;
        size = capacity;
        nodeMap = new HashMap<>();
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key))
            return -1;
        Node node = nodeMap.get(key);
        remove(node);
        add(node);
        return node.value;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void add(Node node) {
        Node tmp = right.prev;
        node.next = right;
        node.prev = tmp;
        tmp.next = node;
        right.prev = node;
    }

    public void put(int key, int value) {
        Node node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            remove(node);
            node.value = value;
            add(node);
            nodeMap.put(key, node);
        } else {
            node = new Node(key, value);
            if (nodeMap.size() == size) {
                nodeMap.remove(left.next.key);
                remove(left.next);
            }
            add(node);
            nodeMap.put(key, node);
        }
    }
}

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
