class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> freqs = new HashMap<>();
        for (int card : hand) {
            if (freqs.containsKey(card)) freqs.put(card, freqs.get(card) + 1);
            else freqs.put(card, 1);
        }

        Arrays.sort(hand);
        for (int card : hand) {
            if (freqs.get(card) > 0) {
                for (int i = card; i < card + groupSize; i++) {
                    if (!freqs.containsKey(i) || freqs.get(i) == 0) return false;
                    freqs.put(i, freqs.get(i) - 1);
                }
            }
        }

        return true;
    }
}
