public class Solution {

    Map<String, Integer> dp = new HashMap<>();

    public int maxCoins(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int x : nums) arr.add(x);
        return dfs(arr);
    }

    private int dfs(List<Integer> arr) {

        int n = arr.size();
        if (n == 0) return 0;

        String hash = arr.toString();
        if (dp.containsKey(hash)) return dp.get(hash);

        int best = 0;
        for (int i = 0; i < n; i++) {
            int left  = (i - 1 >= 0) ? arr.get(i - 1) : 1;
            int mid   = arr.get(i);
            int right = (i + 1 < n) ? arr.get(i + 1) : 1;
            int coins = left * mid * right;
            List<Integer> next = new ArrayList<>(n - 1);
            next.addAll(arr.subList(0, i));
            if (i + 1 < n) next.addAll(arr.subList(i + 1, n));
            best = Math.max(best, coins + dfs(next));
        }

        dp.put(hash, best);
        return best;
    }
}
