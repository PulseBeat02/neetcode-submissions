class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freqs = new int[26];
        for (char task : tasks) freqs[task - 'A']++;

        Queue<Character> queue = new PriorityQueue<>((c0, c1) -> {
            return freqs[c1 - 'A'] - freqs[c0 - 'A'];
        });
        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i] != 0) queue.add((char) (i + 'A'));
        }

        Queue<int[]> cd = new LinkedList<>();
        int i = 0;
        while (!queue.isEmpty() || !cd.isEmpty()) {
            while (!cd.isEmpty() && cd.peek()[1] <= i) {
                queue.offer((char) cd.poll()[0]);
            }
            if (!queue.isEmpty()) {
                char c = queue.poll();
                freqs[c - 'A']--;
                if (freqs[c - 'A'] > 0) {
                    cd.offer(new int[]{c, i + n + 1});
                }
            }
            i++;
        }

        return i;
    }
}
