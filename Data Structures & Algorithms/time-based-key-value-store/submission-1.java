class TimeMap {
                      // key    // timestamp // value
    private final Map<String, Map<Integer, String>> values;

    public TimeMap() {
        this.values = new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {
        if (values.containsKey(key)) {
            Map<Integer, String> entry = values.get(key);
            entry.put(timestamp, value);
        } else {
            Map<Integer, String> entry = new TreeMap<>(Comparator.reverseOrder());
            entry.put(timestamp, value);
            values.put(key, entry);
        }
    }
    
    public String get(String key, int timestamp) {
        Map<Integer, String> value = values.get(key);
        if (value == null) return "";
        for (int ts : value.keySet()) {
            if (ts > timestamp) continue;
            return value.get(ts);
        }
        return "";
    }
}
