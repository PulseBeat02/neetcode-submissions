class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int[] bounds = stats(weights);
        int left = bounds[0];
        int right = bounds[1];
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean works = possible(weights, days, mid);
            if (works) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            System.out.println(mid + "=" + works);
        }
        return left;
    }

    private boolean possible(int[] weights, int days, int weight) {
        int count = 1;
        int running = 0;
        for (int i = 0; i < weights.length; i++) {
            running += weights[i];
            if (running > weight) {
                count++;
                running = 0;
                i--;
                if (count > days) return false;
            }
        }
        return true;
    }

    private int[] stats(int[] weights) {
        int max = 0;
        int sum = 0;
        for (int weight : weights) {
            max = Math.max(max, weight);
            sum += weight;
        }
        return new int[] {max, sum};
    }
}