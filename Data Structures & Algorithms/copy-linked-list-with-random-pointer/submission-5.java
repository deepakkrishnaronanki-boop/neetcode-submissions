/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copy = new HashMap<>();
        Node cur = head;

        while (cur != null) {
            Node tmp = new Node(cur.val);
            copy.put(cur, tmp);
            cur = cur.next;
        }

        for (Map.Entry<Node, Node> entry : copy.entrySet()) {
            Node dup = entry.getValue();
            dup.next = copy.get(entry.getKey().next);
            dup.random = copy.get(entry.getKey().random);
        }

        return copy.get(head);
    }
}
