class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        for (char task : tasks) freqs[task - 'A']++;

        Arrays.sort(freqs);
        int max = freqs[25];
        int idle = (max - 1) * n;
        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(max - 1, freqs[i]);
        }

        return idle > 0 ? tasks.length + idle : tasks.length;
    }
}
