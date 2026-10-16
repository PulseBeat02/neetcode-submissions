class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> freqs = new TreeMap<>();
        int lowest = hand[0];
        int count = 0;
        for (int card : hand) {
            freqs.put(card, freqs.getOrDefault(card, 0) + 1);
            lowest = Math.min(lowest, card);
            count++;
        }

        if (count % groupSize != 0) return false;

        int groups = count / groupSize;
        int start = lowest;
        for (int i = 0; i < groups; i++) {
            for (int j = 0; j < groupSize; j++) {
                if (freqs.containsKey(start + j) && freqs.get(start + j) != 0) {
                    int afterUsed = freqs.get(start + j) - 1;
                    freqs.put(start + j, afterUsed);
                    if (afterUsed == 0) {
                        freqs.remove(start + j);
                    }
                } else {
                    return false;
                }
            }
            if (!freqs.isEmpty()) {
                start = freqs.firstKey();
            }
        }

        return true;
    }
}
