class Solution {
public String reorganizeString(String s) {
    Map<Character, Integer> freqs = new HashMap<>();
    for (char c : s.toCharArray()) {
        freqs.put(c, freqs.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<int[]> pq =
        new PriorityQueue<>((x, y) -> Integer.compare(y[1], x[1]));

    for (var e : freqs.entrySet()) {
        pq.offer(new int[]{ e.getKey(), e.getValue() });
    }

    StringBuilder sb = new StringBuilder();
    int[] prev = null;

    while (!pq.isEmpty()) {
        int[] cur = pq.poll();

        sb.append((char) cur[0]);
        cur[1]--;

        if (prev != null && prev[1] > 0) {
            pq.offer(prev);
        }

        prev = cur;
    }

    if (prev != null && prev[1] > 0) return "";

    return sb.toString();
}
}