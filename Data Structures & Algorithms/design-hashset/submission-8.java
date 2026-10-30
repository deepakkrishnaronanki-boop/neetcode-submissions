class MyHashSet {

    List[] buckets;
    public MyHashSet() {
        buckets = new List[769];
        for(int i = 0;i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
    }
    
    public void add(int key) {
        int hash = hash(key);
        if(!buckets[hash].contains((Integer) key)) {
            buckets[hash].add(key);
        }
    }

    private int hash(int key) {
        return key % buckets.length;
    }
    
    public void remove(int key) {
        int hash = hash(key);
        if(buckets[hash].contains((Integer) key)) {
            buckets[hash].remove((Integer) key);
        }
    }
    
    public boolean contains(int key) {
        return buckets[hash(key)].contains((Integer) key);   
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */