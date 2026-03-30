class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n =  1_000_000_000;
        int left = 1;
        int right = n - 1;
        while (left <= right) {
            int rate = (left + right) / 2;
            int time = calculate(piles, rate);
            if (time <= h) {
               right = rate - 1; 
            } else {
               left = rate + 1;
            }
        }
        return left;
    }

    public int calculate(int[] piles, int rate) {
        int hours = 0;
        for (int pile : piles) {
            int time = pile / rate;
            int leftover = pile % rate;
            hours += time;
            if (leftover != 0) {
                hours++;
            }
        }
        return hours;
    }
}
