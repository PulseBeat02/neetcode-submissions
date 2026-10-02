class TimeMap {

    private final Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        final TreeMap<Integer, String> treeMap = map.get(key);
        final Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        if (entry == null) return "";
        return entry.getValue();
    }
}
