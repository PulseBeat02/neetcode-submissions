class RandomizedSet {

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        int size = list.size();
        list.add(val);
        map.put(val, size);
        return true;
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {

            int size = map.size();

            // val, remove
            int remove = map.get(val);

            // last, index (keep)
            int last = list.getLast();
            int index = map.get(last);

            list.set(remove, last);
            map.put(last, remove);

            map.remove(val);
            list.removeLast();
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */