class MyHashSet {
    List<Integer>[] buckets;
    public MyHashSet() {
        buckets = new List[769];
        for(int i = 0;i < buckets.length;i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    private int hash(int key) {
        return key % buckets.length;
    }
    
    public void add(int key) {
        List<Integer> bucket = buckets[hash(key)];
        
        if(!bucket.contains((Integer) key)) bucket.add(key);
    }
    
    public void remove(int key) {
        List<Integer> bucket = buckets[hash(key)];

        bucket.remove((Integer) key);
    }
    
    public boolean contains(int key) {
        List<Integer> bucket = buckets[hash(key)];
        return bucket.contains((Integer) key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */