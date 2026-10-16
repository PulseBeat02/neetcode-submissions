class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> firstSeen = new HashMap<>();
        Map<Character, Integer> lastSeen = new HashMap<>();
        Set<Character> characters = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!firstSeen.containsKey(chars[i])) {
                firstSeen.put(chars[i], i);
            }
            lastSeen.put(chars[i], i);
            characters.add(chars[i]);
        }

        List<int[]> ranges = new ArrayList<>();
        for (char c : characters) {
            ranges.add(new int[] {firstSeen.get(c), lastSeen.get(c)});
        }
        Collections.sort(ranges, (a, b) -> a[0] - b[0]);
    
        for (int i = 1; i < ranges.size(); i++) {
            int[] previous = ranges.get(i - 1);
            int[] current = ranges.get(i);
            if (current[0] <= previous[1]) {
                previous[1] = Math.max(previous[1], current[1]);
                ranges.remove(i);
                i--;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int[] range : ranges) {
            result.add(range[1] - range[0] + 1);
        }

        return result;

        /*

        xyxxyzbzbbisl

        x -> 0..3
        y -> 1..4
        z -> 5..7
        b -> 6..9
        i -> 10..10
        s -> 11..11
        l -> 12..12


        */

    }
}
