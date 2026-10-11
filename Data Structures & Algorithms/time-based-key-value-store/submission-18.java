class TimeMap {

    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) { 
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);

        int l = 0, r = list.size()-1;

        while(l <= r) {
            int m = l + (r - l) / 2;
            int time = list.get(m).timestamp;

            if(time <= timestamp) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r >= 0 ? list.get(r).value : "";
    }
}

class Pair {
    String value;
    int timestamp;

    public Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
