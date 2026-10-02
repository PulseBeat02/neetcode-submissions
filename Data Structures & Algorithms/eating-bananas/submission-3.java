class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = piles[0];
        for (int pile : piles) right = Math.max(pile, right);
        int left = 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canFinish(int[] piles, int rate, int target) {
        int time = 0;
        for (int pile : piles) {
            time += Math.ceil((double) pile / rate);
        }
        return time <= target;
    }
}
